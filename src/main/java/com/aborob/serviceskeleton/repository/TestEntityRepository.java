package com.aborob.serviceskeleton.repository;

import com.aborob.serviceskeleton.entity.TestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TestEntityRepository {

    private static final Logger log = LoggerFactory.getLogger(TestEntityRepository.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Optional<TestEntity> getTestEntityByTestEntityId(Integer testEntityId) {

        TestEntity testEntity = null;
        try {
            testEntity = (TestEntity) this.jdbcTemplate.queryForObject(
                    "SELECT test_entity_id, code FROM test_entity " +
                            "WHERE test_entity_id = ?", new Object[]{testEntityId},
                    new BeanPropertyRowMapper(TestEntity.class));

        } catch (Exception e) {
            log.info("TestEntity " + testEntityId + " not exist, " + e.getMessage());
        }
        return Optional.ofNullable(testEntity);
    }

    public List<TestEntity> getTestEntityList() {

        List<TestEntity> testEntityList = null;
        try {
            testEntityList = this.jdbcTemplate.query(
                    "SELECT t.test_entity_id, t.code FROM test_entity t",
                    (rs, rowNum) -> new TestEntity(rs.getInt("test_entity_id"), rs.getShort("code"))
            );
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return testEntityList;
    }

}
