package ru.cubesolutions.rabbitmq;

/**
 * Created by Garya on 24.12.2017.
 */
public class RabbitConfig {

    private String host;
    private int port;
    private String vHost;
    private String user;
    private String password;

    public RabbitConfig(String host, int port, String vHost, String user, String password) {
        this.host = host;
        this.port = port;
        this.vHost = vHost;
        this.user = user;
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getvHost() {
        return vHost;
    }

    public void setvHost(String vHost) {
        this.vHost = vHost;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}