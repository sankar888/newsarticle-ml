package com.rssfeed.data.collector.rss.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A channel may contain any number of <item>s. An item may represent a "story"
 * much like a story in a newspaper or magazine; if so its description is a synopsis of the story,
 * and the link points to the full story. An item may also be complete in itself,
 *
 * All elements of an item are optional, however at least one of title or description must be present.
 */
@JacksonXmlRootElement(localName = "item")
public class Item {
    @JacksonXmlProperty
    private String guid;
    @JacksonXmlProperty
    private String title;
    @JacksonXmlProperty
    private String link;
    @JacksonXmlProperty
    private String description;
    @JacksonXmlProperty
    private String author;
    @JacksonXmlProperty
    private String category;
    @JacksonXmlProperty
    private String comments;
    @JacksonXmlProperty
    private String pubDate;
    @JacksonXmlProperty
    private String source;
    //Not part of rss spec. This is used to specify the rss feed to which this item belong to
    //This is populated from data from system metastore
    private String feedSource;

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getComments() {
        return comments;
    }

    public String getPubDate() {
        return pubDate;
    }

    public String getSource() {
        return source;
    }

    public String getFeedSource() {
        return feedSource;
    }

    public void setFeedSource(String feedSource) {
        this.feedSource = feedSource;
    }
}
