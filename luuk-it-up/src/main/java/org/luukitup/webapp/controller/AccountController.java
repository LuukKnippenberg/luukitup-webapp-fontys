package org.luukitup.webapp.controller;

import org.luukitup.webapp.dal.Account;
import org.luukitup.webapp.dal.Blog;
import org.luukitup.webapp.logic.AccountManager;
import org.luukitup.webapp.logic.BlogManager;
import org.luukitup.webapp.model.AddAccount;
import org.luukitup.webapp.model.AddBlog;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Blog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class AccountController
{
    @Inject
    AccountManager accountManager;

    @GET
    public List<Account> GetAllAccounts()
    {
        return accountManager.GetAllAccounts();
    }

    //New
    @POST
    @Path("Add")
    public Account AddAccount(AddAccount addAccount)
    {
        return accountManager.CreateAccount(addAccount);
    }

    //Edit
    //@PUT
}
