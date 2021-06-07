package org.luukitup.webapp.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.luukitup.webapp.dal.Project;
import org.luukitup.webapp.logic.ProjectManager;
import org.luukitup.webapp.model.AddProject;
import org.luukitup.webapp.model.EditProject;

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
    @Path("/All")
    public List<Project> GetAllProjects()
    {
        return projectManager.GetAllProjects();
    }

    @GET
    @Path("{Id}")
    public Project GetProjectById(@PathParam("Id") String id)
    {
        return projectManager.GetProjectById(id);
    }

    @GET
    @Path("/Amount/{Amount}")
    public List<Project> GetFeaturedProjects(@PathParam("Amount") int amount) {return  projectManager.GetVariableAmountOfProjects(amount); }

    @GET
    @Path("/Featured")
    public List<Project> GetFeaturedProjects() {return projectManager.GetFeaturedProjects(); }

    //New
    @POST
    @Path("/Add")
    public Project AddProject(AddProject addProject)
    {
        return projectManager.CreateProject(addProject);
    }

    @PUT
    @Path("/Edit")
    public boolean EditProject(EditProject project){
        return projectManager.EditProject(project);
    }

    @DELETE
    @Path("/Delete")
    public boolean DeleteProject(String data){
        JsonObject obj = new Gson().fromJson(data, JsonObject.class);

        return projectManager.DeleteProject(obj);
    }

}
