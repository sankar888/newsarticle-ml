package com.rssfeed.data.collector.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Rss pojo which represents 2.0.11 specification
 */

@JacksonXmlRootElement(localName = "rss")
public class Rss {

    @JacksonXmlProperty(localName = "channel")
    private Channel channel;
}
