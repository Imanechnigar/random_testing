package com.example.begg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RandomTestingRepository extends JpaRepository<RandomTesting, Integer>{

}


