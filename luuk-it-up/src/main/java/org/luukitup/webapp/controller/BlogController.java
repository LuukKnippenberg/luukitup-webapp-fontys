package org.luukitup.webapp.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.luukitup.webapp.dal.Blog;
import org.luukitup.webapp.dal.Project;
import org.luukitup.webapp.logic.BlogManager;
import org.luukitup.webapp.model.AddBlog;
import org.luukitup.webapp.model.EditBlog;
import org.luukitup.webapp.model.EditProject;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/Blog")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
public class BlogController
{
    @Inject
    BlogManager blogManager;

    @GET
    @Path("/All")
    public List<Blog> GetAllBlogs()
    {
        return blogManager.GetAllBlogs();
    }

    @GET
    @Path("{Id}")
    public Blog GetBlogById(@PathParam("Id") String id)
    {
        return blogManager.GetBlogById(id);
    }

    //New
    @POST
    @Path("Add")
    public Blog AddBlog(AddBlog addBlog)
    {
        return blogManager.CreateBlog(addBlog);
    }

    @PUT
    @Path("/Edit")
    public boolean EditBlog(EditBlog project){
        return blogManager.EditBlog(project);
    }

    @DELETE
    @Path("/Delete")
    public boolean DeleteBlog(String data){
        JsonObject obj = new Gson().fromJson(data, JsonObject.class);

        return blogManager.DeleteBlog(obj);
    }
}
