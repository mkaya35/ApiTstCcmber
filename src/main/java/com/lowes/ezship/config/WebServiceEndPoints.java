package com.lowes.ezship.config;

public enum WebServiceEndPoints {
    VENDOR_SERVICE_POST("/smsezcvsrv/v1/shipments/vendor-carrierselection","POST"),
    VENDOR_SERVICE_PING("/smsezcvsrv/v1/shipments/ping", "GET"),
    GEO_SERVICE_PING("/smsezcgsrv/test", "GET");

    private final String url;
    private final String method;

    WebServiceEndPoints(String url, String method) {
        this.url = url;
        this.method = method;
    }

    public String getUrl() {
        return url;
    }
    public String getMethod() {return method;}
}
