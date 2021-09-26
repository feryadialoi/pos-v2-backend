package com.gdi.posbackend.model.request;

import com.gdi.posbackend.validation.constraint.ConfirmationPasswordMatchConstraint;
import com.gdi.posbackend.validation.constraint.EmailUnique;
import com.gdi.posbackend.validation.constraint.UsernameUnique;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 9/14/2021 10:02 AM
 */
@Data
@ConfirmationPasswordMatchConstraint
public class CreateUserRequest {

    @NotBlank
    @ApiModelProperty(required = true)
    private String name;

    @NotBlank
    @ApiModelProperty(required = true)
    @UsernameUnique
    private String username;

    @NotBlank
    @EmailUnique
    String email;

    String phone;

    @NotBlank
    @ApiModelProperty(required = true)
    private String password;

    @NotBlank
    @ApiModelProperty(required = true)
    private String confirmationPassword;

}
