package org.luukitup.webapp.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class BlogRepository implements PanacheRepository<Blog>
{
    public Blog FindById(String id)
    {
        return find("id", id).firstResult();
    }

    public List<Blog> FindAll()
    {
        return listAll();
    }
}
