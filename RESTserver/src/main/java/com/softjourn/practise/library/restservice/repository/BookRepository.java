package com.softjourn.practise.library.restservice.repository;

import com.softjourn.practise.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select a from Book a where a.deleted is null")
    List<Book> getAll();

    @Query("select a from Book a where a.name like :name and a.deleted is null")
    List<Book> findByName(@Param("name") String name);
}
