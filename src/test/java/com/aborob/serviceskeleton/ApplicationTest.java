package com.aborob.serviceskeleton;

import static org.assertj.core.api.Assertions.assertThat;

import com.aborob.serviceskeleton.repository.TestEntityRepository;
import com.aborob.serviceskeleton.service.TestEntityService;
import com.aborob.serviceskeleton.entity.TestEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    TestEntityRepository testEntityRepository;

    @Autowired
    TestEntityService testEntityService;

    @Test
    public void contextLoads() {

        // Basic integration test that shows the context starts up properly
        assertThat(testEntityService).isNotNull();
        assertThat(testEntityRepository).isNotNull();
    }

    @Test
    public void dataLoad() {

        // Based on data applied from data.sql

        List<TestEntity> testEntityList = testEntityRepository.getTestEntityList();
        assertThat(testEntityList).isNotNull();
        assertThat(testEntityList.size()).isEqualTo(2);

    }

}
