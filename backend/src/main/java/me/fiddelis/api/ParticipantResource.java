package me.fiddelis.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import me.fiddelis.model.Participant;
import me.fiddelis.service.ParticipantService;

import java.util.List;

@Path("/participant")
public class ParticipantResource {
    @Inject
    ParticipantService participantService;

    @GET
    @Path("/{puuid}")
    public Response getMatchesByParticipantPuuid(@PathParam("puuid") String puuid) {
        List<Participant> participants = participantService.getAllParticipantByPuuid(puuid);
        return Response.ok(participants).build();
    }
}
