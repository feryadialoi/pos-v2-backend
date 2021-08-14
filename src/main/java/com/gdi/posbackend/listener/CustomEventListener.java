package com.gdi.posbackend.listener;

import com.gdi.posbackend.listener.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/10/2021 11:26 PM
 */
@Slf4j
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        log.info("Received spring custom event - {}", customEvent.getMessage());
    }
}
