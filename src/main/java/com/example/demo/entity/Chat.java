package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Chat extends AbstractPersistable<Integer> {

    private String chatName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "chats")
    private List<User> users;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    List<Message> messages;

}
