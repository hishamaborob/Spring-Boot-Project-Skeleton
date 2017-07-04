package com.aborob.serviceskeleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestEntitiesAPITest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void test_end_points() throws Exception {

        // Based on data applied from data.sql

        mvc.perform(get("/api/v1/testEntities/{test_entity_id}", 1))
                .andExpect(status().isOk());

        mvc.perform(get("/api/v1/testEntities/{test_entity_id}", 2))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"test_entity_id\":2,\"code\":1}"));

        mvc.perform(get("/api/v1/testEntities/{test_entity_id}", 6))
                .andExpect(status().isNotFound());

    }
}
