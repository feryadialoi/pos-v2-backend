package com.gdi.posbackend.command.core;

import com.gdi.posbackend.model.commandparam.CommandParam;

public interface ConsumerSupplierCommand<RESPONSE, REQUEST extends CommandParam> extends Command {
    RESPONSE execute(REQUEST request);
}