package com.covidtracker.models;

// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.ToString;

// @Data
// @NoArgsConstructor
// @ToString
public class LocationStats {
    private String state;
    private String country;
    private String latestCases;
    private String latestTotalCases;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getLatestCases() {
        return latestCases;
    }
    public void setLatestCases(String latestCases) {
        this.latestCases = latestCases;
    }
    public String getLatestTotalCases() {
        return latestTotalCases;
    }
    public void setLatestTotalCases(String latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }
    public LocationStats() {
    }

}

