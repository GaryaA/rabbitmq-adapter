package ru.cubesolutions.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Garya on 28.11.2017.
 */
public abstract class EndPoint {

    private final static Logger log = Logger.getLogger(EndPoint.class);

    protected Channel channel;
    protected Connection connection;

    public EndPoint(RabbitConfig rabbitConfig) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();

//        factory.setSaslConfig(new SaslConfig() {
//            @Override
//            public SaslMechanism getSaslMechanism(String[] strings) {
//                return null;
//            }
//        });

        factory.setHost(rabbitConfig.getHost());
        factory.setPort(rabbitConfig.getPort());
        factory.setVirtualHost(rabbitConfig.getvHost());
        factory.setUsername(rabbitConfig.getUser());
        factory.setPassword(rabbitConfig.getUser());

        //getting a connection
        try {
            connection = factory.newConnection();
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException("Can't connect to rabbitmq", e);
        }

        //creating a channel
        channel = connection.createChannel();
    }

    public void close() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }
}
