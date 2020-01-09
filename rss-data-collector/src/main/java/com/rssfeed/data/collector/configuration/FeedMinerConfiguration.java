package com.rssfeed.data.collector.configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FeedMinerConfiguration {
    private int connectionTimeoutMs;
    private int readTimeoutMs;
    private List<FeedConfig> feeds;

    private FeedMinerConfiguration(ConfigBuilder builder) {
        this.connectionTimeoutMs = builder.connectionTimeoutMs;
        this.readTimeoutMs = builder.readTimeoutMs;
        this.feeds = builder.feeds;
    }

    public static class FeedConfig {
        private String feedName;
        private String feedUrl;

        FeedConfig(String feedName, String feedUrl) {
            this.feedName = feedName;
            this.feedUrl = feedUrl;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof FeedConfig)) return false;
            FeedConfig that = (FeedConfig) o;
            return feedName.equals(that.feedName) &&
                    feedUrl.equals(that.feedUrl);
        }

        @Override
        public int hashCode() {
            return Objects.hash(feedName, feedUrl);
        }
    }

    public static class ConfigBuilder {
        private int connectionTimeoutMs;
        private int readTimeoutMs;
        private List<FeedConfig> feeds;

        public ConfigBuilder() {
            connectionTimeoutMs = 10000;
            readTimeoutMs = 10000;
            feeds = new ArrayList<>();
        }

        public ConfigBuilder addFeed(String feedName, String feedUrl) {
            feeds.add(new FeedConfig(feedName, feedUrl));
            return this;
        }

        public ConfigBuilder withConnectionTimeoutMs(int connectionTimeoutMs) {
            this.connectionTimeoutMs = connectionTimeoutMs;
            return this;
        }

        public ConfigBuilder withReadTimeoutMs(int readTimeoutMs) {
            this.readTimeoutMs = readTimeoutMs;
            return this;
        }

        public FeedMinerConfiguration build() {
            return new FeedMinerConfiguration(this);
        }
    }


}
