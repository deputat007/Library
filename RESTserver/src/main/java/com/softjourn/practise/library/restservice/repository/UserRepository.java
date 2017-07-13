package com.softjourn.practise.library.restservice.repository;

import com.softjourn.practise.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select a from User a where a.deleted is null")
    List<User> getAll();

    @Query("select a from User a where a.userName = :userName and a.password = :password  and a.deleted is null")
    User findByCredential(@Param("userName") String userName, @Param("password") String password);

    @Query("select a from User a where a.userName like :userName and a.deleted is null")
    User findByName(@Param("userName") String userName);
}
