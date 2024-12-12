package com.example.sso_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.DefaultSpringSecurityContextSource;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;

@Configuration
public class LdapConfig {
    @Bean
    public DefaultSpringSecurityContextSource contextSource() {
        DefaultSpringSecurityContextSource contextSource = new DefaultSpringSecurityContextSource("ldap://192.168.100.24:389/dc=example,dc=local");
        // Usuario y contraseña de un admin 
        contextSource.setUserDn("cn=agustin,dc=example,dc=local");  // Especifica el DN del usuario para autenticar
        contextSource.setPassword("agustin");  // Establece la contraseña del usuario
        return contextSource;
    }
    
    @Bean
    public ActiveDirectoryLdapAuthenticationProvider authenticationProvider() {
        // dominio , url 
        return new ActiveDirectoryLdapAuthenticationProvider("example.local", "ldap://192.168.100.24:389");
    }
}
