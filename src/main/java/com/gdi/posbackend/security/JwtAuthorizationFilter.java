package com.gdi.posbackend.security;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.gdi.posbackend.exception.TokenNotContainUsernameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final JwtUtil jwtUtil;
    private final HandlerExceptionResolver handlerExceptionResolver;
    private final UserDetailsService userDetailsService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,
                                  HandlerExceptionResolver handlerExceptionResolver,
                                  JwtUtil jwtUtil,
                                  UserDetailsService userDetailsService) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
        this.handlerExceptionResolver = handlerExceptionResolver;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        try {
            String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
//            log.info(HttpHeaders.AUTHORIZATION + "=" + authorizationHeader);
            boolean hasAuthorization = authorizationHeader != null && authorizationHeader.startsWith("Bearer ");

            if (hasAuthorization) {
                String token = authorizationHeader.replace("Bearer ", "");
                SecurityContextHolder.getContext().setAuthentication(authenticate(token));
            }

            chain.doFilter(request, response);
        } catch (Exception e) {
            log.info(e.getClass().getSimpleName());
            log.info(e.getMessage());
            e.printStackTrace();
            handlerExceptionResolver.resolveException(request, response, null, e);
        }
    }


    private UsernamePasswordAuthenticationToken authenticate(String token) {
        DecodedJWT decodedJWT = jwtUtil.verifyToken(token);
        String userId = jwtUtil.getUserId(decodedJWT);
        String subject = jwtUtil.getSubject(decodedJWT);
        log.info("Token [subject = \"" + subject + "\", id = \"" + userId + "\"]");

        if (subject == null) throw new TokenNotContainUsernameException("token invalid");

        ApplicationUserDetails userDetails = (ApplicationUserDetails) userDetailsService.loadUserByUsername(subject);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }
}
