package com.covidtracker.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class LocationStats {
    private String state;
    private String country;
    private String latestCases;
    private String latestTotalCases;

}

