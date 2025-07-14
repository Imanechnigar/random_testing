package com.example.begg;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("random-testing")
public class RandomTestingController {
    private final RandomTestingRepository repository;

    public RandomTestingController(RandomTestingRepository repository) {
        this.repository = repository;
    }

    ///  read method
    @GetMapping
    public RandomTesting getById(@RequestParam Integer id) {
        System.out.println("🔍 Received request for Id: " + id);
        return repository.findById(id).orElse(null);
    }

    ///  create method
    @PostMapping("/add_new")
    public ResponseEntity<RandomTesting> create(@RequestBody RandomTesting newTest) {
        if (newTest.getId() != null) {
            newTest.setId(null);
        }
        RandomTesting saved = repository.save(newTest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /// update method
    @PutMapping("/update/{id}")
    public ResponseEntity<RandomTesting> update(@PathVariable Integer id, @RequestBody RandomTesting newTest) {
        Optional<RandomTesting> test = repository.findById(id);

        if (test.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        RandomTesting existing = test.get();

        existing.setName(newTest.getName());
        existing.setEmail(newTest.getEmail());
        existing.setPassword(newTest.getPassword());

        RandomTesting saved = repository.save(existing);
        System.out.println("An update has been made on Id="+id);
        return ResponseEntity.ok(saved);
    }

    /// Delete method
   @DeleteMapping ("/delete/{id}")
    public ResponseEntity<RandomTesting> delete(@PathVariable Integer id) {
       Optional<RandomTesting> test = repository.findById(id);
       if (test.isEmpty()) {
           return ResponseEntity.notFound().build();
       }
       repository.deleteById(id);
       System.out.println("Id=" +id + " has been deleted");
       return ResponseEntity.ok(test.get());
   }





}