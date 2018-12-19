package com.example.demo.dao;

import com.example.demo.entity.Chat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatDao extends CrudRepository<Chat, Integer> {

}
