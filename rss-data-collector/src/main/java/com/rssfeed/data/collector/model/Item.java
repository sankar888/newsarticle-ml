package com.rssfeed.data.collector.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

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
}
