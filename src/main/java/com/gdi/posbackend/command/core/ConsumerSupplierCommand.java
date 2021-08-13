package com.gdi.posbackend.command.core;

import com.gdi.posbackend.model.commandrequest.CommandRequest;

public interface ConsumerSupplierCommand<RESPONSE, REQUEST extends CommandRequest> extends Command {
    RESPONSE execute(REQUEST request);
}