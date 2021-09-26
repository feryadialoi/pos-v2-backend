package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.model.criteria.UserCriteria;
import com.gdi.posbackend.model.request.CreateUserRequest;
import com.gdi.posbackend.model.response.UserResponse;
import com.gdi.posbackend.model.response.UserWithRolesResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/5/2021 1:42 PM
 */
public interface UserService {
    User findUserByIdOrThrowNotFound(String userId);

    UserResponse createUser(CreateUserRequest createUserRequest);

    Page<UserResponse> getUsers(UserCriteria userCriteria, Pageable pageable);

    UserWithRolesResponse getUserWithRoles(String userId);

    UserResponse getUser(String userId);
}
