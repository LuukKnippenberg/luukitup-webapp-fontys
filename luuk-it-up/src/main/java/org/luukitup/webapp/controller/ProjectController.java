package org.luukitup.webapp.controller;

import org.luukitup.webapp.dal.Project;
import org.luukitup.webapp.logic.ProjectManager;
import org.luukitup.webapp.model.AddProject;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Project")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class ProjectController
{
    @Inject
    ProjectManager projectManager;

    @GET
    public List<Project> GetAllProjects()
    {
        return projectManager.GetAllProjects();
    }

    //New
    @POST
    @Path("Add")
    public Project AddProject(AddProject addProject)
    {
        return projectManager.CreateProject(addProject);
    }

    //Edit
    //@PUT
}
