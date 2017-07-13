package com.softjourn.practise.library.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column(name = "user_name")
    private String userName;

    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "user_role_id")
    private Role role;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(int id, String userName, Role role, String password) {
        this.id = id;
        this.userName = userName;
        this.role = role;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
