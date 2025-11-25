package com.docencia.rest.service.interfaces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;

import com.docencia.rest.exception.ResourceNotFoundException;
import com.docencia.rest.model.User;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface UserServiceInterface {
    public List<User> getAllUsers();

    public User getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;

    public User createUser(@Valid @RequestBody User user);

    public User updateUser(@PathVariable(value = "id") int userId, @Valid @RequestBody User userDetails) throws ResourceNotFoundException;

    public boolean deleteUser(@PathVariable(value = "id") int userId) throws ResourceNotFoundException;
}
