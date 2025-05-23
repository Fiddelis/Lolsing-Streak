package me.fiddelis.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import me.fiddelis.model.Account;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<Account, String> {
}
