package me.fiddelis.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import me.fiddelis.client.MatchService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/matches")
public class MatchResource {
    @Inject
    @RestClient
    MatchService matchService;

    @GET
    @Path("/by-puuid/{puuid}")
    public List<String> getMatches(@PathParam("puuid") String puuid,
                                   @QueryParam("start") @DefaultValue("0") int start,
                                   @QueryParam("count") @DefaultValue("100") int count,
                                   @QueryParam("type") @DefaultValue("ranked") String type) {
        return matchService.getMatches(puuid, start, count, type);
    }

    @GET
    @Path("/{match_id}")
    public Map<?, ?> getMatch(@PathParam("match_id") String matchId) {
        return matchService.getMatch(matchId);
    }
}
