package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.mapper.UserMapper;
import com.gdi.posbackend.model.criteria.UserCriteria;
import com.gdi.posbackend.model.request.CreateUserRequest;
import com.gdi.posbackend.model.response.UserResponse;
import com.gdi.posbackend.model.response.UserWithRolesResponse;
import com.gdi.posbackend.repository.UserRepository;
import com.gdi.posbackend.service.UserService;
import com.gdi.posbackend.specification.UserSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.gdi.posbackend.specification.UserSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

/**
 * @author Feryadialoi
 * @date 9/13/2021 2:24 AM
 */
@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public User findUserByIdOrThrowNotFound(String userId) {
        return userRepository.findByIdOrThrowNotFound(userId);
    }

    @Override
    public UserResponse createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setName(createUserRequest.getName());
        user.setUsername(createUserRequest.getUsername());
        user.setEmail(createUserRequest.getEmail());
        user.setPhone(createUserRequest.getPhone());
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));

        user = userRepository.save(user);

        return userMapper.mapUserToUserResponse(user);
    }

    @Override
    public Page<UserResponse> getUsers(UserCriteria userCriteria, Pageable pageable) {
        Specification<User> specification = where(null);

        if (userCriteria.getName() != null)
            specification = specification.or(nameIsLike(userCriteria.getName()));

        if (userCriteria.getUsername() != null)
            specification = specification.or(usernameIsLike(userCriteria.getUsername()));

        if (userCriteria.getEmail() != null)
            specification = specification.or(emailIsLike(userCriteria.getEmail()));

        if (userCriteria.getPhone() != null)
            specification = specification.or(phoneIsLike(userCriteria.getPhone()));

        return userRepository.findAll(specification, pageable).map(userMapper::mapUserToUserResponse);

    }

    @Override
    public UserWithRolesResponse getUserWithRoles(String userId) {
        return userMapper.mapUserToUserWithRolesResponse(findUserByIdOrThrowNotFound(userId));
    }

    @Override
    public UserResponse getUser(String userId) {
        return userMapper.mapUserToUserResponse(findUserByIdOrThrowNotFound(userId));
    }
}
