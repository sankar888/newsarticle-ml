package com.rssfeed.data.collector.rss.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * A representation of channel 2.0.11 object
 * the fields which are not used for processing are ignored
 */

public class Channel {

    @JacksonXmlProperty
    private String title;
    @JacksonXmlProperty
    private String link;
    @JacksonXmlProperty
    private String description;
    @JacksonXmlProperty
    private String language;
    @JacksonXmlProperty
    private String managingEditor;
    @JacksonXmlProperty
    private String webMaster;
    @JacksonXmlProperty
    private String pubDate;
    @JacksonXmlProperty
    private String lastBuildDate;
    @JacksonXmlProperty
    private String category;
    @JacksonXmlProperty
    private String ttl;
    @JacksonXmlProperty
    private String rating;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private List<Item> item;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getManagingEditor() {
        return managingEditor;
    }

    public String getWebMaster() {
        return webMaster;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getLastBuildDate() {
        return lastBuildDate;
    }

    public String getCategory() {
        return category;
    }

    public String getTtl() {
        return ttl;
    }

    public String getRating() {
        return rating;
    }

    public List<Item> getItem() {
        return item;
    }
}
