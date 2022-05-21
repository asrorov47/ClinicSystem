package com.tests.tester.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.tests.tester.model.Visit;
import com.tests.tester.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Visit visit){
        Visit result = visitService.create(visit);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        Visit result=visitService.get(id);
        return ResponseEntity.ok(result);
    }

  @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody Visit visit){
        Visit result = visitService.update(id,visit);
            return ResponseEntity.ok(result);
      }

@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        boolean result = visitService.delete(id);
        return ResponseEntity.ok(result);
}









}
