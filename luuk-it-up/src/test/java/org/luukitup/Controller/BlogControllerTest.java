package org.luukitup.Controller;

//Testing Imports
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

//Project Imports
import org.luukitup.webapp.controller.BlogController;
import org.luukitup.webapp.dal.Blog;
import org.luukitup.webapp.logic.BlogManager;

//Syntax Imports
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class BlogControllerTest {
    @Inject BlogController blogController;
    @InjectMock BlogManager blogManager;

    @Test
    public void GetAllProjects() {
        //Arrange
        List<Blog> expected = new ArrayList<>();
        Mockito.when(blogManager.GetAllBlogs()).thenReturn(expected);
        //Act
        List<Blog> actual = blogController.GetAllBlogs();
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void GetProjectByIdNotEqual() {

        //Arrange
        Blog expected = new Blog();
        Mockito.when(blogManager.GetBlogById("id")).thenReturn(expected);
        //Act
        Blog actual = blogController.GetBlogById("id2");
        //Assert
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void GetProjectByIdAreEqual() {

        //Arrange
        Blog expected = new Blog();
        Mockito.when(blogManager.GetBlogById("id")).thenReturn(expected);
        //Act
        Blog actual = blogController.GetBlogById("id");
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void DeleteProjectByJsonData() {
        //Arrange

        //Act

        //Assert
    }

}