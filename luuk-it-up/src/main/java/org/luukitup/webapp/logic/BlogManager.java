package org.luukitup.webapp.logic;

import org.luukitup.webapp.dal.Blog;
import org.luukitup.webapp.dal.BlogRepository;
import org.luukitup.webapp.model.AddBlog;

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
}
