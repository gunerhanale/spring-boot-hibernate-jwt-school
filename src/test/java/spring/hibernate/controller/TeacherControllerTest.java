package spring.hibernate.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import spring.hibernate.dto.Teacher;

public class TeacherControllerTest extends AbstractTest {

    final String URI = "/teachers";

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getTeachers() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URI)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Teacher[] teacherlist = super.mapFromJson(content, Teacher[].class);
        Assert.assertTrue(teacherlist.length > 0);
    }

    @Test
    public void getTeacher() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(URI + "/10").
                accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Teacher teacher = super.mapFromJson(content, Teacher.class);
        Assert.assertEquals(teacher.getName(), "Mile");
    }

    @Test
    public void createTeacher() throws Exception {

        Teacher teacher = new Teacher();
        teacher.setName("Dennis");

        String inputJson = super.mapToJson(teacher);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(content, "Teacher is created successfully");
    }

    @Test
    public void updateTeacher() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setId(10l);
        teacher.setName("Mile");

        String inputJson = super.mapToJson(teacher);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(URI)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(content, "Teacher is updated successfully");
    }

    @Test
    public void removeTeacher() throws Exception {

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(URI + "/13")).andReturn();
        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(content, "Teacher is removed successfully");
    }

}