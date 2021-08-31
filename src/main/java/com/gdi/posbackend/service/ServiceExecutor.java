package com.gdi.posbackend.service;

import com.gdi.posbackend.command.core.ConsumerSupplierCommand;
import com.gdi.posbackend.command.core.SupplierCommand;
import com.gdi.posbackend.model.commandparam.CommandParam;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:57 PM
 */
public interface ServiceExecutor {

    <RESPONSE, REQUEST extends CommandParam> RESPONSE execute(
            Class<? extends ConsumerSupplierCommand<RESPONSE, REQUEST>> commandClass,
            REQUEST request
    );

    <RESPONSE> RESPONSE execute(
            Class<? extends SupplierCommand<RESPONSE>> commandClass
    );

}

