package com.aborob.serviceskeleton.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class TestEntity {

    private Integer testEntityId;
    private Short code;

    public TestEntity() {
    }

    public TestEntity(Integer testEntityId, Short code) {
        this.testEntityId = testEntityId;
        this.code = code;
    }

    public Integer getTestEntityId() {
        return testEntityId;
    }

    public void setTestEntityId(Integer testEntityId) {
        this.testEntityId = testEntityId;
    }

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }
}
