package com.softjourn.practise.library.restservice.repository;

import com.softjourn.practise.library.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

    @Query("select a from Publisher a where a.deleted is null")
    List<Publisher> getAll();

    @Query("select a from Publisher a where a.name like :name and a.deleted is null")
    List<Publisher> findByName(@Param("name") String name);
}
