package com.dheeraj.hazelcastSetup.configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dheeraj Gupta
 */

@Configuration
public class HazelcastConfig {
    @Bean
    public Config configuration(){
        Config config = new Config();
        config.setInstanceName("hazelcast-instance");
        MapConfig mapConfig= new MapConfig();
        mapConfig.setName("configuration");
        mapConfig.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE));
        mapConfig.setEvictionPolicy(EvictionPolicy.LRU);
        mapConfig.setTimeToLiveSeconds(-1);
        config.addMapConfig(mapConfig);
        return config;
    }
}
