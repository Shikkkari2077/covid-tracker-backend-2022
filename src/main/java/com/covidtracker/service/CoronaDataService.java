package com.covidtracker.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.covidtracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class CoronaDataService {
    private static String VIRUS_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    public List<LocationStats> fetchData() throws IOException, InterruptedException {
        List<LocationStats> newStats=new ArrayList<>();

        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();

        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader=new StringReader(response.body());
        String temp=null;

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            LocationStats locationStat = new LocationStats();
            temp=record.get("Province/State");
            if(temp.equals(""))
                temp="---------";
            locationStat.setState(temp);
            locationStat.setCountry(record.get("Country/Region"));
            temp=String.valueOf(Integer.parseInt(record.get(record.size()-1))-Integer.parseInt(record.get(record.size()-2)));
            if(temp.equals("0"))
                temp="---------";
            locationStat.setLatestCases(temp);
            locationStat.setLatestTotalCases(record.get(record.size()-1));
            newStats.add(locationStat);

        }


        return newStats;
    }

}
