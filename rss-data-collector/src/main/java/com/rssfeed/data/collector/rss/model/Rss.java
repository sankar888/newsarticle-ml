package com.rssfeed.data.collector.rss.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.*;

/**
 * A Rss pojo which represents 2.0.11 specification
 */

@JacksonXmlRootElement(localName = "rss")
public class Rss {

    @JacksonXmlProperty(localName = "channel")
    private Channel channel;

    public List<Item> getNewsItems() {
        //if list is empty no transformation
        if (null == channel || null == channel.getItem() || (channel.getItem().size() == 0) ) {
            return Collections.EMPTY_LIST;
        }
        return Collections.unmodifiableList(channel.getItem());
    }
}
