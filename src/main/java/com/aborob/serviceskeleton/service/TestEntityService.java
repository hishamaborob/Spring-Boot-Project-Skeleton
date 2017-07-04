package com.aborob.serviceskeleton.service;

import com.aborob.serviceskeleton.repository.TestEntityRepository;
import com.aborob.serviceskeleton.entity.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestEntityService {

    private static final Logger log = LoggerFactory.getLogger(TestEntityService.class);

    @Autowired
    TestEntityRepository testEntityRepository;

    public Optional<TestEntity> getTestEntity(Integer test_entity_id) {

        return this.testEntityRepository.getTestEntityByTestEntityId(test_entity_id);
    }
}
