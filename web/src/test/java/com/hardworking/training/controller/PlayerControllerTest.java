//package com.hardworking.training.controller;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.beans.AppletInitializer;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = AppletInitializer.class)
//@AutoConfigureMockMvc
//public class PlayerControllerTest {
//    @Autowired
//    MockMvc mockMvc;
//
//    private static String token;
////TODO: Try controller test.
//
//    @Before
//    public void init() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/auth")
//                .content("{" +
//                        " \"password\": \"123456789\"," +
//                        " \"email\": \"hangechen@training.ascendingdc.com\"" +
//                        "}")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print()).andReturn();
//        token = result.getResponse().getContentAsString().replaceAll("Authorization:", "");
//    }
//
//    @Test
//    public void getAllPlayers() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/player").header("Authorization", token))
//                .andDo(MockMvcResultHandlers.print())
//                //.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//    }
//}
