package com.gdi.posbackend.security.rule;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Feryadialoi
 * @date 7/29/2021 11:13 PM
 */
@Slf4j
@Component("routeSecurity")
@AllArgsConstructor
public class RouteSecurity {

    private final HttpServletRequest request;


    public boolean hasAuthority() {


        return true;
    }
}
