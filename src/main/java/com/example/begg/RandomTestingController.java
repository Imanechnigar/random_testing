package com.example.begg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("random-testing")
public class RandomTestingController {
    private final RandomTestingRepository repository;

    public RandomTestingController(RandomTestingRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public RandomTesting getById(@RequestParam Integer id) {
        System.out.println("🔍 Received request for Id: " + id);
        return repository.findById(id).orElse(null);
    }

}