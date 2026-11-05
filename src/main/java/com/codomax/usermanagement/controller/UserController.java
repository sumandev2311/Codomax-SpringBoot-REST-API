package com.codomax.usermanagement.controller;
import com.codomax.usermanagement.dto.UserRequest;
import com.codomax.usermanagement.entity.User;
import com.codomax.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
    @GetMapping public List<User> getAll() { return service.findAll(); }
    @GetMapping("/{id}") public User getById(@PathVariable Long id) { return service.findById(id); }
    @PutMapping("/{id}") public User update(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id); return ResponseEntity.noContent().build();
    }
}
