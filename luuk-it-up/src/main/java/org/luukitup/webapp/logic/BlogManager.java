package org.luukitup.webapp.logic;

import com.google.gson.JsonObject;
import org.luukitup.webapp.dal.Blog;
import org.luukitup.webapp.dal.BlogRepository;
import org.luukitup.webapp.model.AddBlog;
import org.luukitup.webapp.model.EditBlog;
import org.luukitup.webapp.model.EditProject;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BlogManager
{
    @Inject
    BlogRepository blogRepository;

    public Blog CreateBlog(AddBlog addBlog)
    {
        Blog blog = new Blog();
        blog.setTitle(addBlog.getTitle());
        blog.setText(addBlog.getText());
        blog.setFeaturedImageUrl(addBlog.getFeaturedImageUrl());
        blog.setDateTime(addBlog.getDateTime());
        blog.setId(UUID.randomUUID().toString());

        try
        {
            blogRepository.persist(blog);
            return blog;
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Blog GetBlogById(String id)
    {
        return blogRepository.FindById(id);
    }

    public List<Blog> GetAllBlogs()
    {
        return blogRepository.FindAll();
    }

    public Boolean EditBlog(EditBlog blog){
        return true;
    }

    public boolean DeleteBlog(JsonObject obj) {
        if (!obj.has("ID")) {
            return false;
        }
        blogRepository.DeleteBlog(obj.get("ID").getAsString());
        return true;
    }
}
