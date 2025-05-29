package me.fiddelis.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import me.fiddelis.client.AccountClient;
import me.fiddelis.dto.AccountDTO;
import me.fiddelis.dto.ErrorResponseDTO;
import me.fiddelis.model.Account;
import me.fiddelis.service.AccountService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/account")
public class AccountResource {

    @Inject
    @RestClient
    AccountClient accountClient;

    @Inject
    AccountService accountService;

    @POST
    @Path("/")
    public Response newAccount(AccountDTO dto) {
        Account account = accountClient.getAccount(dto.gameName, dto.tagLine);

        if(accountService.getAccountById(account.puuid).isPresent()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorResponseDTO("Account already exists", 400))
                    .build();
        }

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
