package com.gdi.posbackend.listener.publisher;

import com.gdi.posbackend.listener.event.CustomEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/10/2021 11:30 PM
 */
@Slf4j
@Component
@AllArgsConstructor
public class CustomEventPublisher {
    private final ApplicationEventPublisher applicationEventPublisher;


    public void publishCustomEvent(final String message) {
        log.info("Publishing custom event.");
        CustomEvent customEvent = new CustomEvent(this, message);
        applicationEventPublisher.publishEvent(customEvent);
    }
}
