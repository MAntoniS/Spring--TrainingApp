package com.example.demoWebApp;

import java.util.Date;

public class Lecture {

    private final Long id;
    private final String topic;
    private final Date time;



    public Lecture(String topic, Date time) {
        this.id = null;
        this.topic = topic;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Date getTime() {
        return time;
    }




}
