package com.gdi.posbackend.listener.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;

/**
 * @author Feryadialoi
 * @date 8/10/2021 11:27 PM
 */
public class CustomEvent extends ApplicationEvent {
    private String message;

    public CustomEvent(Object source, String message) {
        super(source);
    }

    public String getMessage() {
        return message;
    }
}
