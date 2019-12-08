package avi.practice.microservice.limitsservice.controller;

import avi.practice.microservice.limitsservice.beans.Limits;
import avi.practice.microservice.limitsservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public Limits getAllLimits() {
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
