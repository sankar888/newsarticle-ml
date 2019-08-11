package com.rssfeed.data.collector.model;

/**
 * This class is the model class for the News Item. A news Item is class which represents along with its channel
 */
public class NewsItem {

    private String guid; //unique identifier of the article
    private String title; //title of the article
    private String description; //description, the actual content
    private String comments; //link to the comments section
    private String author;
    private String category;
    private String link;
    private String pubDate;
    private String source;

}
