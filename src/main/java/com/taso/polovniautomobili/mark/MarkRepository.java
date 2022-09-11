package com.taso.polovniautomobili.mark;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    Optional<Mark> findByName(String name);
    List<Mark> findAllByOrderByName();

    Optional<Object> getByName(String name);
}
