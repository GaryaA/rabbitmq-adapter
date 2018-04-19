package ru.cubesolutions.rabbitmq;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.concurrent.TimeoutException;

/**
 * Created by Garya on 28.11.2017.
 */
public class Producer extends EndPoint {

    public Producer(RabbitConfig rabbitConfig) throws IOException {
        super(rabbitConfig);
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Double.parseDouble("0.9");
        RabbitConfig rabbitConfig = new RabbitConfig(
                "x3.containerum.io",
                31242,
                "evam",
                "evam",
                "evam"
        );
        Producer producer = new Producer(rabbitConfig);
        String sentMessage = "<Doc>\n" +
                "            <TransType>\n" +
                "                <TransCode>\n" +
                "                    <MsgCode>PAYPER</MsgCode>\n" +
                "                </TransCode>\n" +
                "            </TransType>\n" +
                "            <DocRefSet>\n" +
                "                <Parm>\n" +
                "                    <ParmCode>DRN</ParmCode>\n" +
                "                    <Value></Value>\n" +
                "                </Parm>\n" +
                "            </DocRefSet>\n" +
                "            <LocalDt>2017-09-14 16:30:00</LocalDt>\n" +
                "            <Description>Бонусы</Description>\n" +
                "            <SourceDtls></SourceDtls>\n" +
                "            <Originator>\n" +
                "                <ContractNumber>200-CLIENT_FEE_KZT_RES</ContractNumber>\n" +
                "                <MemberId>PAY0001</MemberId>\n" +
                "            </Originator>\n" +
                "            <Destination>\n" +
                "                <ContractNumber>KZ0000000000000000000</ContractNumber>\n" +
                "                <MemberId>0001</MemberId>\n" +
                "            </Destination>\n" +
                "            <Transaction>\n" +
                "                <Currency>398</Currency>\n" +
                "                <Amount>3000</Amount>\n" +
                "            </Transaction>\n" +
                "        </Doc>";
        for (int i = 0; i < 1; i++) {
            producer.sendMessage(Base64.getEncoder().encode(sentMessage.getBytes(Charset.forName("UTF-8"))), "", "way4queuetest");
        }
        System.out.println("ok");
        producer.close();
    }

    public void sendMessage(String object, String exchange, String ruutingKey) throws IOException {
        sendMessage(object.getBytes("UTF-8"), exchange, ruutingKey);
    }

    public void sendMessage(byte[] object, String exchange, String ruutingKey) throws IOException {
        channel.basicPublish(exchange, ruutingKey, null, object);
    }
}