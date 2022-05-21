package com.tests.tester.repository;

import com.tests.tester.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository <Visit,Integer> {
}
