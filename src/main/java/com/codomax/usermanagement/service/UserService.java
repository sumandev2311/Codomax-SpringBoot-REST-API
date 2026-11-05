package com.codomax.usermanagement.service;
import com.codomax.usermanagement.dto.UserRequest;
import com.codomax.usermanagement.entity.User;
import com.codomax.usermanagement.exception.*;
import com.codomax.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) { this.repository = repository; }
    public User create(UserRequest request) {
        String email = request.getEmail().trim().toLowerCase();
        if (repository.existsByEmailIgnoreCase(email)) throw new DuplicateEmailException("Email is already registered: " + email);
        return repository.save(new User(request.getName().trim(), email, request.getPhone(), request.getAge()));
    }
    @Transactional(readOnly = true)
    public List<User> findAll() { return repository.findAll(); }
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    public User update(Long id, UserRequest request) {
        User user = findById(id);
        String email = request.getEmail().trim().toLowerCase();
        repository.findByEmailIgnoreCase(email).ifPresent(existing -> {
            if (!existing.getId().equals(id)) throw new DuplicateEmailException("Email is already registered: " + email);
        });
        user.setName(request.getName().trim()); user.setEmail(email);
        user.setPhone(request.getPhone()); user.setAge(request.getAge());
        return repository.save(user);
    }
    public void delete(Long id) { repository.delete(findById(id)); }
}
