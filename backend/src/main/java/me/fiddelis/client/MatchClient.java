package me.fiddelis.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import me.fiddelis.model.Match;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient(baseUri = "https://americas.api.riotgames.com/lol/match/v5/matches")
@RegisterProvider(RiotApiKeyFilter.class)
public interface MatchClient {
    @GET
    @Path("/by-puuid/{puuid}/ids")
    List<String> getMatches(@PathParam("puuid") String puuid, @QueryParam("start") int start, @QueryParam("count") int count, @QueryParam("type") String type);

    @GET
    @Path("/{match_id}")
    Match getMatch(@PathParam("match_id") String match_id);

}
