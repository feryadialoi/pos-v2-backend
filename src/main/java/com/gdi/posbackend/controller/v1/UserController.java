package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.UserCriteria;
import com.gdi.posbackend.model.request.CreateUserRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.UserResponse;
import com.gdi.posbackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 9/14/2021 10:14 AM
 */
@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN', 'ROLE_ADMIN', 'CREATE_USER')")
    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        return response("create users success", userService.createUser(createUserRequest));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN', 'ROLE_ADMIN', 'GET_USERS')")
    @GetMapping
    public ResponseEntity<ApiResponse<Page<UserResponse>>> getUsers(UserCriteria userCriteria, Pageable pageable) {
        return response("get users success", userService.getUsers(userCriteria, pageable));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN', 'ROLE_ADMIN', 'GET_USER')")
    @GetMapping("/{userId}")
    public Object getUser(@PathVariable(name = "userId") String userId) {
        return response("get user success", userService.getUser(userId));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN', 'ROLE_ADMIN', 'GET_USER_WITH_ROLES')")
    @GetMapping("/{userId}/roles")
    public Object getUserWithRoles(@PathVariable(name = "userId") String userId) {
        return response("get user with roles success", userService.getUserWithRoles(userId));
    }
}
