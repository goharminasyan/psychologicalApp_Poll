package com.epam.repository;

import com.epam.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
}
