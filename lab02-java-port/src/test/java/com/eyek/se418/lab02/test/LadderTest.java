package com.eyek.se418.lab02.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class LadderTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser("tom")
    public void shouldReturnLadder() throws Exception {
        mockMvc.perform(get("/get-ladder?src=path&dst=love"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"state\":\"OK\",\"src\":\"path\",\"dst\":\"love\",\"ladder\":[\"path\",\"pate\",\"pave\",\"lave\",\"love\"]}"
                ));
    }

    @Test
    @WithMockUser("tom")
    public void shouldReturnNoLadder() throws Exception {
        mockMvc.perform(get("/get-ladder?src=history&dst=justify"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"state\":\"OK\",\"src\":\"history\",\"dst\":\"justify\",\"ladder\":null}"
                ));
    }

    @Test
    @WithMockUser("tom")
    public void shouldReturnInputError() throws Exception {
        mockMvc.perform(get("/get-ladder?src=path&dst=lov"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"state\":\"input error\",\"src\":\"path\",\"dst\":\"lov\",\"ladder\":null}"
                ));
    }

}
