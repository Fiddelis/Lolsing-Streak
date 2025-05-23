package me.fiddelis.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import me.fiddelis.model.Account;
import me.fiddelis.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AccountService {
    @Inject
    AccountRepository accountRepository;

    public Optional<Account> getAccountById(String accountId) {
        return accountRepository.findByIdOptional(accountId);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.listAll();
    }

    public List<String> getPuuids() {
        return accountRepository.find("SELECT a.puuid FROM Account a").project(String.class).list();
    }

    @Transactional
    public void save(Account account) {
        accountRepository.persist(account);
    }
}
