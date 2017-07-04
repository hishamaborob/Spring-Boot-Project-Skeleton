package com.aborob.serviceskeleton.api.v1;

import com.aborob.serviceskeleton.entity.TestEntity;
import com.aborob.serviceskeleton.exception.ResourceNotFoundException;
import com.aborob.serviceskeleton.service.TestEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/api/v1")
public class TestEntitiesAPI {

    @Autowired
    private TestEntityService testEntityService;

    @RequestMapping(value = "/testEntities/{test_entity_id}", method = GET,
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public ResponseEntity<TestEntity> getTestEntity(@PathVariable Integer test_entity_id)
            throws ResourceNotFoundException {

        return this.testEntityService.getTestEntity(test_entity_id)
                .map(testEntity -> {
                    return new ResponseEntity<TestEntity>(testEntity, HttpStatus.OK);
                }).orElseThrow(
                        () -> new ResourceNotFoundException("Not found")
                );
    }

}
