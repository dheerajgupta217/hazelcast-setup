package com.dheeraj.hazelcastSetup.services;

import com.hazelcast.core.IMap;
import org.springframework.stereotype.Service;

@Service
public interface HazelcastService {
    String createData(String key, String value);
    String getDataByKey(String key);
    IMap<String, String> getData();
    String update(String key, String value);
    String deleteData(String key);

}
