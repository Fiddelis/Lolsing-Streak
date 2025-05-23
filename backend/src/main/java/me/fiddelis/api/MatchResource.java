package me.fiddelis.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import me.fiddelis.client.MatchClient;
import me.fiddelis.model.Match;
import me.fiddelis.service.MatchService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;


@Path("/matches")
public class MatchResource {
    @Inject
    @RestClient
    MatchClient matchClient;

    @Inject
    MatchService matchService;

    @GET
    public Response getMatch(@QueryParam("matchId") String matchId) {
        Match match = matchService.getMatchById(matchId);
        return Response.ok(match).build();
    }

    @GET
    @Path("/all/id")
    public Response getAllMatchesId() {
        List<String> matchIds = matchService.getAllMatchIds();
        return Response.ok(matchIds).build();
    }

    @GET
    @Path("/all/puuid/id")
    public Response getAllMatchIdByPuuid(@QueryParam("puuid") String puuid) {
        List<String> matchIds = matchService.getMatchesByParticipantPuuid(puuid);
        return Response.ok(matchIds).build();
    }

    @GET
    @Path("/all/puuid/{puuid}")
    public Response getAllMatchesByPuuid(@PathParam("puuid") String puuid) {
        List<String> matchIds = matchService.getMatchesByParticipantPuuid(puuid);

        List<Match> matches = new ArrayList<>();
        for(String id : matchIds) {
            Match match = matchService.getMatchById(id);
            matches.add(match);
        }

        return Response.ok(matches).build();
    }

    @POST
    @Path("/update")
    public Response updateMatches() {
        matchService.updateMatches();
        return Response.noContent().build();
    }

    @POST
    public Response saveMatchesByIdManual(List<String> matchesId) {
        for(String matchId : matchesId) {
            Match match = matchClient.getMatch(matchId);
            matchService.save(match);
        }
        return Response.noContent().build();
    }

    @DELETE
    public Response deleteMatch(List<String> matchId) {
        for(String id : matchId) {
            matchService.delete(id);
        }
        return Response.noContent().build();
    }
}
