package me.fiddelis.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.fiddelis.model.Match;

import java.util.List;

@ApplicationScoped
public class MatchRepository implements PanacheRepositoryBase<Match, String> {
}
