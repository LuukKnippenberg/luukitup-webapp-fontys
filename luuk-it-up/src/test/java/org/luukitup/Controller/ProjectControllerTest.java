package org.luukitup.Controller;

//Testing Imports
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

//Project Imports
import org.luukitup.webapp.controller.ProjectController;
import org.luukitup.webapp.dal.Project;
import org.luukitup.webapp.logic.ProjectManager;

//Syntax Imports
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@QuarkusTest
public class ProjectControllerTest {
    @Inject ProjectController projectController;
    @InjectMock ProjectManager projectManager;

    @Test
    public void GetAllProjects() {
        //Arrange
        List<Project> expected = new ArrayList<>();
        Mockito.when(projectManager.GetAllProjects()).thenReturn(expected);
        //Act
        List<Project> actual = projectController.GetAllProjects();
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void GetProjectByIdNotEqual() {

        //Arrange
        Project expected = new Project();
        Mockito.when(projectManager.GetProjectById("id")).thenReturn(expected);
        //Act
        Project actual = projectController.GetProjectById("id2");
        //Assert
        Assertions.assertNotEquals(expected, actual);
    }

    @Test
    public void GetProjectByIdAreEqual() {

        //Arrange
        Project expected = new Project();
        Mockito.when(projectManager.GetProjectById("id")).thenReturn(expected);
        //Act
        Project actual = projectController.GetProjectById("id");
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