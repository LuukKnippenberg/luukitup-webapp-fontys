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

    public Boolean EditProject(EditProject project){
        return true;
    }

    public boolean DeleteProject(JsonObject obj) {
        if (!obj.has("ID")) {
            return false;
        }
        projectRepository.DeleteProject(obj.get("ID").getAsString());
        return true;
    }
}
