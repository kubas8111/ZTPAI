package com.example.adwise.repositories;

import com.example.adwise.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User getUserByUserId(Integer userId);
    User findUserByUserId(Integer userId);
}
