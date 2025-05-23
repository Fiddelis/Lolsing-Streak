package me.fiddelis.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.fiddelis.model.Account;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "https://americas.api.riotgames.com/riot/account/v1/accounts")
@RegisterProvider(RiotApiKeyFilter.class)
public interface AccountClient {

    @GET
    @Path("/by-riot-id/{gameName}/{tagLine}")
    Account getAccount(@PathParam("gameName") String gameName, @PathParam("tagLine") String tagLine);
}
