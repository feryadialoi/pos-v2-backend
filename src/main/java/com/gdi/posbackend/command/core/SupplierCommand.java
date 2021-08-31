package com.gdi.posbackend.command.core;

public interface SupplierCommand<RESPONSE> extends Command {
    RESPONSE execute();
}
