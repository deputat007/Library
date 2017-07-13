package com.softjourn.practise.library.restservice.repository;

import com.softjourn.practise.library.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    @Query("select a from Role a where a.deleted is null")
    List<Role> getAll();

    @Query("select a from Role a where a.roleName like :name and a.deleted is null")
    List<Role> findByName(@Param("name") String name);
}
