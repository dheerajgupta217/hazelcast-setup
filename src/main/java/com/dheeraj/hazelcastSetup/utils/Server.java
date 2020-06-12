package com.dheeraj.hazelcastSetup.utils;
import java.util.Map;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IdGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * @author Dheeraj Gupta
 */
public class Server {

    private static final Logger LOGGER = LogManager.getLogger(Server.class);

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Map<Long, String> map = instance.getMap("elements");
        IdGenerator idGenerator = instance.getIdGenerator("id");
        for (int i = 0; i < 10; i++) {
            map.put(idGenerator.newId(), "values"+i);
        }
        LOGGER.info("Map Components" , map);
    }
}
