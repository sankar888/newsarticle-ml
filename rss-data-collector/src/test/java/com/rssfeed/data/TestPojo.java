package com.rssfeed.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="pojo")
@XmlAccessorType(XmlAccessType.FIELD)
public class TestPojo {

    private int id;
    private String name;

}
