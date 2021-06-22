package org.luukitup.webapp.dal;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.luukitup.webapp.model.EditProject;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ProjectRepository implements PanacheRepository <Project>
{
    public Project FindById(String id)
    {
        return find("id", id).firstResult();
    }

    public List<Project> FindFeaturedProjects()
    {
        return list("featured", true);
    }

    public List<Project> FindAll()
    {
        return listAll();
    }

    public Boolean DeleteProject(String id)
    {
        try
        {
            delete("id", id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}
