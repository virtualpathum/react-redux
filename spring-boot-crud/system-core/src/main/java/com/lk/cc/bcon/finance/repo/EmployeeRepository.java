package com.lk.cc.bcon.finance.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lk.cc.bcon.finance.entity.EmployeeEntity;


//TODO : Remove below repository methods - extends QueryDslPredicateExecutor and implement predicates
public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {

    EmployeeEntity findByFirstName(String firstName);

}
