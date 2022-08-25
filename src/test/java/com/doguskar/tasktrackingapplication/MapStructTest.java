package com.doguskar.tasktrackingapplication;

import com.doguskar.tasktrackingapplication.data.UserData;
import com.doguskar.tasktrackingapplication.mapper.UserMapper;
import com.doguskar.tasktrackingapplication.model.UserModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MapStructTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        assertThat(userMapper).isNotNull();

        UserModel model = new UserModel();
        model.setName("name");
        model.setEmail("email");
        model.setPassword("password");
        UserData data = userMapper.model2data(model);

        assertThat(data.getName()).isEqualTo("name");
        assertThat(data.getEmail()).isEqualTo("email");
    }
}
