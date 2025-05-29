package me.fiddelis.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.fiddelis.model.Match;

@ApplicationScoped
public class MatchRepository implements PanacheRepositoryBase<Match, String> {
    public void upsert(Match match) {
        getEntityManager().merge(match);
    }
}
