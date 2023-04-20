package com.lowes.ezship.config;

import com.lowes.ezship.security.util.JasyptUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Singleton;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

@Slf4j
@Data
@Singleton
public class AuthorizationService {

    private String vendorSrvCreds;
    private String geographySrvCreds;
    private String baseRateSrvCreds;
    private String fuseSrvCreds;

    public AuthorizationService() throws Exception {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("src/main/resources/application.properties");
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String basicPassword = prop.getProperty(Configuraton.CRED_PASSWORD.getProperty());
        JasyptUtil jasyptUtil = new JasyptUtil(basicPassword);
        this.vendorSrvCreds = createCreds(jasyptUtil,
                prop.getProperty(Configuraton.VENDOR_USERNAME.getProperty()),
                prop.getProperty(Configuraton.VENDOR_PASSWORD.getProperty()));
//        log.info("Vendor service creds {}", this.vendorSrvCreds);
        this.geographySrvCreds = createCreds(jasyptUtil,
                prop.getProperty(Configuraton.GEOGRAPHY_USERNAME.getProperty()),
                prop.getProperty(Configuraton.GEOGRAPHY_PASSWORD.getProperty()));
        this.baseRateSrvCreds = createCreds(jasyptUtil,
                prop.getProperty(Configuraton.BASE_RATE_USERNAME.getProperty()),
                prop.getProperty(Configuraton.BASE_RATE_PASSWORD.getProperty()));
        this.fuseSrvCreds = createCreds(jasyptUtil,
                prop.getProperty(Configuraton.FUSE_USERNAME.getProperty()),
                prop.getProperty(Configuraton.FUSE_PASSWORD.getProperty()));
    }

    private String createCreds(JasyptUtil jasyptUtil, String userName, String password) throws Exception {
        try {
            String decodedUsername = jasyptUtil.decrypt(userName);
            String decodedPassword = jasyptUtil.decrypt(password);
            String authStr = decodedUsername + ":" + decodedPassword;
            return "Basic " + Base64.getEncoder().encodeToString(authStr.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

}
