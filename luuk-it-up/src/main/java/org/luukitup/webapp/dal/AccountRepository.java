package org.luukitup.webapp.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AccountRepository implements PanacheRepository<Account>
{
    public Account FindById(String id)
    {
        return find("id", id).firstResult();
    }

    public List<Account> FindAll()
    {
        return listAll();
    }
}
