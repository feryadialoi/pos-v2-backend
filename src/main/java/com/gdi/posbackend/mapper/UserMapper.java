package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.model.response.UserResponse;

/**
 * @author Feryadialoi
 * @date 8/7/2021 11:56 PM
 */
public interface UserMapper {
    UserResponse mapUserToUserResponse(User user);
}
