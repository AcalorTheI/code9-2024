package com.example.etfcode9.controller;

import com.example.etfcode9.db.entity.Url;
import com.example.etfcode9.db.repository.UrlRepository;
import com.example.etfcode9.servis.UrlServis;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedirectionController {

    @Autowired
    private UrlServis urlServis;

    @GetMapping("/by/{path}")
    public ResponseEntity<Object> getRedirection(@PathVariable(name = "path") String path) {
        Url redirection = urlServis.redirection(path);
        ResponseEntity<Object> location = ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).header("location", redirection.getLongUrl()).build();
        return location;
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Url> getById(@PathVariable(name = "id") Integer id) {
        Url byId = urlServis.getById(id);
        if (byId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(byId);
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> saveUrl(@RequestBody Url url, HttpServletRequest servletRequest) {
        return ResponseEntity.ok(urlServis.save(url));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> deleteUrl(@RequestBody Url url) {
        return ResponseEntity.ok(urlServis.update(url));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUrl(@PathVariable(name = "id") Integer id) {
        urlServis.deleteById(id);
        return ResponseEntity.ok("Ok");
    }
}
