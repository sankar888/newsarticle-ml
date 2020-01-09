package com.rssfeed.data.collector.configuration;

import com.rssfeed.data.collector.Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

/**
 * A RssFeedConfig represents a feed to be scrapped
 */
public final class RssFeedConfig {
    private URL rssUrl;
    private String uniqueName; //a unique string which represents the rss feed

    public RssFeedConfig(String uniqueName, String rssUrl) throws MalformedURLException {
        Utils.checkNotEmpty(uniqueName, "RssFeedName");
        this.rssUrl = Utils.checkValidUrl(rssUrl, "Rss url for : "+uniqueName);
        this.uniqueName = uniqueName;
    }

    public URL getRssUrl() {
        return rssUrl;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RssFeedConfig that = (RssFeedConfig) o;
        return rssUrl.equals(that.rssUrl) &&
                uniqueName.equals(that.uniqueName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rssUrl, uniqueName);
    }
}
