package com.srm4knowledge.springdataelasticsearchexample.repositories;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.srm4knowledge.springdataelasticsearchexample.domain.User;

public interface UserRepository extends ElasticsearchRepository<User, Long> {

	Page<User> findByFirstName(String firstName, Pageable pageable);

	List<User> findFirst5ByFirstName(String firstName, Sort sort);

	Future<List<User>> findByLastName(String lastName);

}
