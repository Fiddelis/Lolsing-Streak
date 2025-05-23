package me.fiddelis.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import me.fiddelis.client.AccountClient;
import me.fiddelis.model.Account;
import me.fiddelis.service.AccountService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/account")
public class AccountResource {

    @Inject
    @RestClient
    AccountClient accountClient;

    @Inject
    AccountService accountService;

    @POST
    @Path("/")
    public Response newAccount(Map<String, String> accountInfo) {
        Account account = accountClient.getAccount(accountInfo.get("gameName"), accountInfo.get("tagLine"));
        accountService.save(account);

        return Response.ok(account).build();
    }

    @GET
    @Path("/")
    public Response getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return Response.ok(accounts).build();
    }
}
