package com.doguskar.tasktrackingapplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAdmin() throws Exception {
        mockMvc.perform(get("/api/v1/users/admin")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void shouldReturnNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/users/")).andDo(print()).andExpect(status().isNotFound());
    }
}
