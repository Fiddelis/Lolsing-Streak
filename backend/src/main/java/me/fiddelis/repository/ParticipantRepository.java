package me.fiddelis.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.fiddelis.model.Participant;

@ApplicationScoped
public class ParticipantRepository implements PanacheRepositoryBase<Participant, String> {
}
