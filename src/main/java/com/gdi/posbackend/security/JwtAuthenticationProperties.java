package com.gdi.posbackend.security;

import java.util.concurrent.TimeUnit;

public class JwtAuthenticationProperties {
    public static final String KEY = "66b15576-fe8c-4156-9721-94eaabc41afd";

    public static final Long REFRESH_EXPIRATION_TIME = TimeUnit.DAYS.toMillis(30);

    public static final Long EXPIRATION_TIME = TimeUnit.HOURS.toMillis(1);

}
