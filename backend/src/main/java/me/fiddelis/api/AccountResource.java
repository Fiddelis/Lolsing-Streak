package me.fiddelis.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import me.fiddelis.client.AccountService;
import me.fiddelis.model.Account;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/account")
public class AccountResource {

    @Inject
    @RestClient
    AccountService accountService;

    @GET
    @Path("/{gameName}/{tagLine}")
    public Account getAccount(@PathParam("gameName") String gameName, @PathParam("tagLine") String tagLine) {
        return accountService.getAccount(gameName, tagLine);
    }
}
