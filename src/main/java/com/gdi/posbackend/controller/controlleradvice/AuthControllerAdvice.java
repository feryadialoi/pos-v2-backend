package com.gdi.posbackend.controller.controlleradvice;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.gdi.posbackend.controller.core.BaseControllerAdvice;
import com.gdi.posbackend.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:59 PM
 */
@Slf4j
@RestControllerAdvice
public class AuthControllerAdvice extends BaseControllerAdvice {

    @ExceptionHandler(BadCredentialsException.class)
    public Object badCredentials(BadCredentialsException badCredentialsException) {
        return response("login failed", badCredentialsException.getMessage(), getXErrorTypeHeader(badCredentialsException), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public Object usernameNotFound(UsernameNotFoundException usernameNotFoundException) {
        return response("login failed", usernameNotFoundException.getMessage(), getXErrorTypeHeader(usernameNotFoundException), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AlgorithmMismatchException.class)
    public Object algorithmMismatch(AlgorithmMismatchException algorithmMismatchException) {
        return response("authentication failed", algorithmMismatchException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(JWTDecodeException.class)
    public Object jwtDecode(JWTDecodeException jwtDecodeException) {
        return response("authentication valid", jwtDecodeException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenNotContainUsernameException.class)
    public Object tokenNotContainUsername(TokenNotContainUsernameException tokenNotContainUsernameException) {
        return response("authentication failed", tokenNotContainUsernameException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public Object insufficientAuthentication(InsufficientAuthenticationException insufficientAuthenticationException) {
        return response("authentication failed", insufficientAuthenticationException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthenticationTokenNotFoundException.class)
    public Object AuthenticationTokenNotFound(AuthenticationTokenNotFoundException authenticationTokenNotFoundException) {
        return response("authentication failed", authenticationTokenNotFoundException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public Object internalAuthenticationService(InternalAuthenticationServiceException internalAuthenticationServiceException) {
        return response("authentication failed", internalAuthenticationServiceException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Object accessDenied(AccessDeniedException accessDeniedException) {
        accessDeniedException.printStackTrace();
        return response("access denied", accessDeniedException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenIdNotMatchException.class)
    public Object tokenIdNotMatch(TokenIdNotMatchException tokenIdNotMatchException) {
        return response("token not valid", tokenIdNotMatchException.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public Object tokenExpired(TokenExpiredException tokenExpiredException) {
        return response("token expired", tokenExpiredException.getMessage(), getXErrorTypeHeader(tokenExpiredException), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RefreshTokenExpiredException.class)
    public Object refreshTokenExpired(RefreshTokenExpiredException refreshTokenExpiredException) {
        return response("refresh token failed", refreshTokenExpiredException.getMessage(), getXErrorTypeHeader(refreshTokenExpiredException), HttpStatus.UNAUTHORIZED);
    }


}
