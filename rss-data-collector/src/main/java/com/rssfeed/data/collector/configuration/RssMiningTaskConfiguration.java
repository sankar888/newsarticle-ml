package com.rssfeed.data.collector.configuration;

public class RssMiningTaskConfiguration {
    //todo : change to builder if  more params are  added
    private RssFeedConfig feedConfig;
    private int connectionTimeoutMs = 5000;
    private int readTimeoutMs = 5000;

    public RssMiningTaskConfiguration(RssFeedConfig feedConfig) {
        this.feedConfig = feedConfig;
    }

    public int getConnectionTimeoutMs() {
        return connectionTimeoutMs;
    }

    public void setConnectionTimeoutMs(int connectionTimeoutMs) {
        this.connectionTimeoutMs = connectionTimeoutMs;
    }

    public int getReadTimeoutMs() {
        return readTimeoutMs;
    }

    public void setReadTimeoutMs(int readTimeoutMs) {
        this.readTimeoutMs = readTimeoutMs;
    }

    public RssFeedConfig getFeedConfig() {
        return feedConfig;
    }
}
