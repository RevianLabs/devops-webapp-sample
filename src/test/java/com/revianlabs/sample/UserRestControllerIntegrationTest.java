package com.revianlabs.sample;

import com.revianlabs.sample.entities.User;
import com.revianlabs.sample.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class UserRestControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserRepository repository;

    private User testUser;

    @BeforeEach
    public void setup() {
        testUser = new User("TestUser", "test@email.com");
        repository.save(testUser);
    }

    @Test
    public void testIndexPage() throws Exception {
        mvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", List.of(testUser)));
    }

    @Test
    public void testSignupPage() throws Exception {
        mvc.perform(get("/signup"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-user"));
    }

    @Test
    public void testAddUser() throws Exception {
        mvc.perform(post("/adduser").param("name", "addtest").param("email", "add@email.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/index"));

        assertFalse(repository.findByName("addtest").isEmpty());
    }

    @Test
    public void testUpdateUser() throws Exception {
        mvc.perform(post("/update/{id}", repository.findByName("TestUser").get(0).getId())
                        .param("name", "updatetest").param("email", "update@email.com"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/index"));

        assertEquals("update@email.com", repository.findByName("updatetest").get(0).getEmail());
    }

    @Test
    public void testEditUser() throws Exception {
        mvc.perform(get("/edit/" + repository.findByName("TestUser").get(0).getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("update-user"));
    }

    @Test
    public void testEditUserInvalidId() throws Exception {
        mvc.perform(get("/edit/{id}", 9999))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException));
    }
    @Test
    public void testDeleteUser() throws Exception {
        mvc.perform(get("/delete/" + repository.findByName("TestUser").get(0).getId()))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/index"));
    }

    @Test
    public void testDeleteUserInvalidId() throws Exception {
        mvc.perform(get("/delete/{id}", 9999))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof IllegalArgumentException));
    }

}
