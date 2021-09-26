package com.gdi.posbackend.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 7/16/2021 11:02 AM
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * @PreAuthorize("hasRole('') or hasAuthority('')")
     * // custom
     * @PreAuthorize("customHasRole('') or customHasAuthority('')")
     */

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(httpServletRequest -> {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedMethod(HttpMethod.GET);
            corsConfiguration.addAllowedMethod(HttpMethod.POST);
            corsConfiguration.addAllowedMethod(HttpMethod.PUT);
            corsConfiguration.addAllowedMethod(HttpMethod.DELETE);

            return corsConfiguration.applyPermitDefaultValues();
        });

        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login", "/api/v1/auth/login").permitAll()
                .antMatchers(HttpMethod.POST, "/refresh-token", "/api/v1/auth/refresh-token").permitAll();

        http.authorizeRequests().antMatchers("/actuator/**").permitAll();

        // configuration for swagger
        http.authorizeRequests()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/v2/api-docs/**").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/configuration/security").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-ui/*").permitAll()
                .antMatchers("/webjars/**").permitAll();

        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .addFilter(getJwtAuthorizationFilter())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private JwtAuthorizationFilter getJwtAuthorizationFilter() throws Exception {
        return new JwtAuthorizationFilter(authenticationManager(), handlerExceptionResolver, jwtUtil, userDetailsService);
    }

}
