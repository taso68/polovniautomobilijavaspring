package com.taso.polovniautomobili.model;

import com.taso.polovniautomobili.model.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModelRepository extends JpaRepository<Model, Long> {

    Optional<Model> findByName(String name);
}
