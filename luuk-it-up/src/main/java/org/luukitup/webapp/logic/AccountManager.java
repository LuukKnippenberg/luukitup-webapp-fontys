package org.luukitup.webapp.logic;

import org.luukitup.webapp.dal.Account;
import org.luukitup.webapp.dal.AccountRepository;
import org.luukitup.webapp.dal.Blog;
import org.luukitup.webapp.dal.BlogRepository;
import org.luukitup.webapp.model.AddAccount;
import org.luukitup.webapp.model.AddBlog;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class AccountManager
{
    @Inject
    AccountRepository accountRepository;

    public Account CreateAccount(AddAccount addAccount)
    {
        Account account = new Account();
        account.setId(UUID.randomUUID().toString());
        account.setUsername(addAccount.getUsername());
        account.setPassword(addAccount.getPassword());
        account.setEmail(addAccount.getEmail());

        try
        {
            accountRepository.persist(account);
            return account;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Account GetAccountById(String id)
    {
        return accountRepository.FindById(id);
    }

    public List<Account> GetAllAccounts()
    {
        return accountRepository.FindAll();
    }
}
