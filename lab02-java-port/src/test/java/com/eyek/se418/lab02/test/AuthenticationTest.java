package com.eyek.se418.lab02.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class AuthenticationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAuthenticationShouldAccept() throws Exception {
        RequestBuilder requestBuilder = formLogin().user("tom").password("secretForTom");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void testAuthenticationShouldReject() throws Exception {
        RequestBuilder requestBuilder = formLogin().user("tom").password("incorrectPassword");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error"));
    }

}
