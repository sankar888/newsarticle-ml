package com.rssfeed.data.collector.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
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
    private String image;
    @JacksonXmlProperty
    private String rating;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "item")
    private List<Item> item;

}
