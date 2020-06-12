package com.dheeraj.hazelcastSetup.services;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;

import com.hazelcast.core.IMap;
import org.springframework.stereotype.Service;

/**
 * @author Dheeraj Gupta
 */
@Service
public class HazelcastServiceImpl implements HazelcastService {
    private final HazelcastInstance hazelcastInstance;

    @Autowired
    HazelcastServiceImpl(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }
    @Override
    public String createData(String key, String value) {
        IMap<String, String> map = hazelcastInstance.getMap("my-map");
        map.put(key, value);
        return "Data is stored.";
    }

    @Override
    public String getDataByKey(String key) {
        IMap<String, String> map = hazelcastInstance.getMap("my-map");
        return map.get(key);
    }

    @Override
    public IMap<String, String> getData() {
        return hazelcastInstance.getMap("my-map");
    }
    @Override
    public String update(String key, String value) {
        IMap<String, String> map = hazelcastInstance.getMap("my-map");
        map.set(key, value);
        return "Data is stored.";
    }
    @Override
    public String deleteData(String key) {
        IMap<String, String> map = hazelcastInstance.getMap("my-map");
        return map.remove(key);
    }


}
