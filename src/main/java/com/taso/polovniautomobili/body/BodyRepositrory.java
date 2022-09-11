package com.taso.polovniautomobili.body;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BodyRepositrory extends JpaRepository<Body, Long> {
    List<Body> findAllByOrderByName();

    Optional<Body> findByName(String name);

    @Override
    Optional<Body> findById(Long aLong);
}
