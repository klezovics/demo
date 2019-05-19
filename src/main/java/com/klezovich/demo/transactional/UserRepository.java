package com.klezovich.demo.transactional;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.Id;

interface UserRepository extends CrudRepository<User, Id> {
}
