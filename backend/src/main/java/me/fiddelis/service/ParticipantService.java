package me.fiddelis.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import me.fiddelis.model.Participant;
import me.fiddelis.repository.ParticipantRepository;

import java.util.List;

@ApplicationScoped
public class ParticipantService {
    @Inject
    ParticipantRepository participantRepository;

    public List<Participant> getAllParticipantByPuuid(String puuid) {
        return participantRepository.find("puuid = ?1", puuid).list();
    }

    public List<String> getAllMatchIdByPuuid(String puuid) {
        return participantRepository.getEntityManager()
                .createQuery("SELECT p.match.matchId FROM Participant p WHERE p.puuid = :puuid", String.class)
                .setParameter("puuid", puuid)
                .getResultList();
    }
}
