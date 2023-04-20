package com.lowes.ezship.config;

public enum Configuraton {
    CRED_PASSWORD("http.credentials.encryptionPassword"),

    VENDOR_USERNAME("vendor-service.auth.username"),
    VENDOR_PASSWORD("vendor-service.auth.password"),


    GEOGRAPHY_USERNAME("geo-service.auth.username"),
    GEOGRAPHY_PASSWORD("geo-service.auth.password"),

    BASE_RATE_USERNAME("api.base-rate-service.auth.username"),
    BASE_RATE_PASSWORD("api.base-rate-service.auth.password"),

    FUSE_USERNAME("api.fuse-service.auth.username"),
    FUSE_PASSWORD("api.fuse-service.auth.password");

    private final String property;

    Configuraton(String property) { this.property = property; }

    public String getProperty() {
        return property;
    }
}
