package com.example.demuser.repository;

import com.example.demuser.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {

}
