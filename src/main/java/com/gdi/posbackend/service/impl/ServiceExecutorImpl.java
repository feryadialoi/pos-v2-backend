package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.command.core.SupplierCommand;
import com.gdi.posbackend.model.commandrequest.CommandRequest;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/5/2021 12:21 AM
 */
@Service
@AllArgsConstructor
public class ServiceExecutorImpl implements ServiceExecutor {

    private final ApplicationContext applicationContext;

    @Override
    public <RESPONSE, REQUEST extends CommandRequest> RESPONSE execute(Class<? extends ConsumerSupplierCommand<RESPONSE, REQUEST>> commandClass, REQUEST request) {
        return applicationContext.getBean(commandClass).execute(request);
    }

    @Override
    public <RESPONSE> RESPONSE execute(Class<? extends SupplierCommand<RESPONSE>> commandClass) {
        return applicationContext.getBean(commandClass).execute();
    }
}
