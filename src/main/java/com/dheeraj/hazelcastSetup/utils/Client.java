package com.dheeraj.hazelcastSetup.utils;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

/**
 * @author Dheeraj Gupta
 */
public class Client {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getGroupConfig().setName("dev");
        clientConfig.getGroupConfig().setPassword("dev-pass");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<Long, String> map = client.getMap("elements");
        for (Map.Entry<Long, String> entry : map.entrySet()) {
            LOGGER.info(String.format("Key: %d, Value: %s", entry.getKey(), entry.getValue()));
        }
    }
}
