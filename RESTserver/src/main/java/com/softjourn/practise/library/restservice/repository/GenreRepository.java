package com.softjourn.practise.library.restservice.repository;

import com.softjourn.practise.library.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {

    @Query("select a from Genre a where a.deleted is null")
    List<Genre> getAll();

    @Query("select a from Genre a where a.name like :name and a.deleted is null")
    List<Genre> findByName(@Param("name") String name);
}
