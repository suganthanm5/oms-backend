package com.example.outletmanagement.config;

import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Configuration
@ConditionalOnProperty(name = "socket-server.enabled", havingValue = "true", matchIfMissing = false)
public class SocketIOConfig {

    @Value("${socket-server.host:0.0.0.0}")
    private String host;

    @Value("${socket-server.port:8081}")
    private Integer port;

    @Bean
    public SocketIOServer socketIOServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(host);
        config.setPort(port);
        // Allow CORS for the frontend
        config.setOrigin("*");

        return new SocketIOServer(config);
    }
}
