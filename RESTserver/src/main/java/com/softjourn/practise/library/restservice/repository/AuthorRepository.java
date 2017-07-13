package com.softjourn.practise.library.restservice.repository;

import com.softjourn.practise.library.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query("select a from Author a where a.deleted is null")
    List<Author> getAll();

    @Query("select a from Author a where a.firstName like :firstName and a.deleted is null")
    List<Author> findByFirstName(@Param("firstName") String firstName);
}
