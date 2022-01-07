package com.example.StudyTestCode.domain.auth.controller;

import com.example.StudyTestCode.domain.auth.controller.AuthController;
import com.example.StudyTestCode.domain.auth.entity.Account;
import com.example.StudyTestCode.domain.auth.service.AuthService;
import com.example.StudyTestCode.domain.main.controller.MainController;
import com.example.StudyTestCode.global.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AuthController.class)
class AuthControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @MockBean
    private AuthService authService;

    // 값이 null
    @Test
    void accounts() throws Exception {
        List<Account> accounts = new ArrayList<Account>();

        mvc.perform(get("/auth/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(accounts)));
    }

    @Test
    void join() throws Exception {
        mvc.perform(post("/auth/join"))
                .andExpect(status().isOk());
    }
}