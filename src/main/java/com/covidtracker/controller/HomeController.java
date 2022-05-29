package com.covidtracker.controller;

import com.covidtracker.models.LocationStats;
import com.covidtracker.service.CoronaDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {

    @Autowired
    CoronaDataService coronaDataService;

    @GetMapping("/data")
    public List<LocationStats> home() throws IOException, InterruptedException {
        return coronaDataService.fetchData();
    }
}
