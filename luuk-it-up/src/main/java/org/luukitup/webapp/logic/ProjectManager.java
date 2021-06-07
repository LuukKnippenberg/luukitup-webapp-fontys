package org.luukitup.webapp.logic;

import com.google.gson.JsonObject;
import org.luukitup.webapp.dal.Project;
import org.luukitup.webapp.dal.ProjectRepository;
import org.luukitup.webapp.model.AddProject;
import org.luukitup.webapp.model.EditProject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProjectManager
{
    @Inject
    ProjectRepository projectRepository;

    public Project CreateProject(AddProject addProject)
    {
        Project project = new Project();
        project.setTitle(addProject.getTitle());
        project.setDescription(addProject.getDescription());
        project.setFeaturedImageUrl(addProject.getFeaturedImageUrl());
        project.setFeatured(addProject.getFeatured());
        project.setLinkToProject(addProject.getLinkToProject());
        //project.setGalleryImageUrls(addProject.getGalleryImageUrls());
        project.setId(UUID.randomUUID().toString());

        try
        {
            projectRepository.persist(project);
            return project;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Project GetProjectById(String id)
    {
        return projectRepository.FindById(id);
    }

    public List<Project> GetAllProjects()
    {
        return projectRepository.FindAll();
    }

    public List<Project> GetFeaturedProjects()
    {
        return projectRepository.FindFeaturedProjects();
    }

    public List<Project> GetVariableAmountOfProjects(int amount)
    {
        List<Project> projects = projectRepository.FindAll();
        List<Project> sortedProjects = null;

        //Replace with helper function
        if(projects.size() >= 1)
        {
            sortedProjects.add(projects.get(0));

            if(sortedProjects.size() >= 2)
            {
                sortedProjects.add(projects.get(1));
                if(sortedProjects.size() >= 3)
                {
                    sortedProjects.add(projects.get(2));
                }
            }
        }

        return projects;
    }

    public Boolean EditProject(EditProject projectModel)
    {
        Project project = projectRepository.FindById((projectModel.getId()));
        project.setLinkToProject(projectModel.getLinkToProject());
        project.setFeatured(projectModel.getFeatured());
        project.setDescription(projectModel.getDescription());
        project.setFeaturedImageUrl(projectModel.getFeaturedImageUrl());
        project.setTitle(projectModel.getTitle());
        project.Save();

        return true;
    }

    public Boolean DeleteProject(String id) {
        return projectRepository.DeleteProject(id);
    }
}
