package me.fiddelis.service;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import me.fiddelis.client.MatchClient;
import me.fiddelis.model.Match;
import me.fiddelis.repository.MatchRepository;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
public class MatchService {
    @Inject
    MatchRepository matchRepository;

    @Inject
    @RestClient
    MatchClient matchClient;

    @Inject
    AccountService accountService;

    @Inject
    ParticipantService participantService;

    public Match getMatchById(String matchId) {
        return matchRepository.findById(matchId);
    }

    public List<String> getAllMatchIds() {
        return matchRepository.find("SELECT m.matchId FROM Match m").project(String.class).list();
    }

    public List<String> getMatchesByParticipantPuuid(String puuid) {
        return participantService.getAllMatchIdByPuuid(puuid);
    }

    @Transactional
    public void save(Match match) {
        matchRepository.persist(match);
    }

    @Transactional
    public void delete(String match) {
        matchRepository.deleteById(match);
    }

    @Scheduled(every = "10m")
    public void updateMatches() {
        List<String> puuids = accountService.getPuuids();
        int start = 0;
        int count = 20;

        List<String> existingMatchIds = getAllMatchIds();

        for(String puuid : puuids) {
            List<String> newMatchIds= matchClient.getMatches(puuid, start, count);

            List<String> onlyNew = newMatchIds.stream().filter(id -> !existingMatchIds.contains(id)).toList();
            for(String newMatchId : onlyNew) {
                Match match = matchClient.getMatch(newMatchId);
                persistOrUpdateMatch(match);
            }
        }
    }

    @Transactional
    public void persistOrUpdateMatch(Match match) {
    matchRepository.persistOrUpdate(match);
}
}
