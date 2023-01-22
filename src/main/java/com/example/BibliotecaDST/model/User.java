package com.example.BibliotecaDST.model;

import jakarta.persistence.*;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;
import org.springframework.lang.NonNull;

import java.util.Objects;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    private String nick;
    @NonNull
    private String passWord;

    public User(Long id, String nick, String passWord) {
        this.id = id;
        this.nick = nick;
        this.passWord = passWord;
    }

    public User() {
    }

    public User(String nick) {
        this.nick = nick;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        nick = nick;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return nick.equals(user.nick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nick);
    }

    @Override
    public String toString() {
        return "User{" +
                ", Nick='" + nick + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
