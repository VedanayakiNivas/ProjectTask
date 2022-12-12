package com.te.crudoperationInMongoDB.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.te.crudoperationInMongoDB.entity.Department;
@Service
public class GenerateSequence {

	@Autowired
	private MongoOperations mongoOperations;
	
	public Integer getSequenceNumber(String sequenceName) {
		Query query = new Query(Criteria.where("deptId").is(sequenceName));
		Update update = new Update().inc("seq", 1);
		Department department = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
				Department.class);
		return !Objects.isNull(department) ? department.getSeq() : 1; 
	}
}
