package com.dheeraj.hazelcastSetup.controllers;

import com.dheeraj.hazelcastSetup.services.HazelcastService;
import com.hazelcast.core.IMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Dheeraj Gupta
 */

@RestController
@RequestMapping("/v1/data")
public class HazelcastCRUDController {
    private static final Logger LOGGER = LogManager.getLogger(HazelcastCRUDController.class);

    @Autowired
    private HazelcastService hazelcastService;

    @PostMapping(value = "/create")
    public String createData(@RequestParam String key, @RequestParam String value) {
        hazelcastService.createData(key, value);
        return "Success";
    }

    @GetMapping(value = "/getByKey")
    public String getDataByKey(@RequestParam String key) {
        return hazelcastService.getDataByKey(key);
    }

    @GetMapping(value = "/get")
    public IMap<String, String> getData() {
        return hazelcastService.getData();
    }
    @PutMapping(value = "/update")
    public String updateData(@RequestParam String key, @RequestParam String value) {
        hazelcastService.update(key, value);
        return "Success";
    }
    @DeleteMapping(value = "/delete")
    public String deleteData(@RequestParam String key) {
        hazelcastService.deleteData(key);
        return "Success";
    }
}
