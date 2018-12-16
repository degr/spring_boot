package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    @Query("select user from User user where user.name = :name ")
    User findUserByName(@Param("name") String name);
}
