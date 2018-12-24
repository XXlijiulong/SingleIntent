package com.example.a15828.singleintent.pojo;

import java.util.List;

public class Person {
    private String name;
    private String content;
    private int images;
//    private List<Integer> images;

    public Person(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Person( int images,String name, String content) {
        this.name = name;
        this.content = content;
        this.images = images;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "News{" +
                "images=" + images + '\'' +
                "title='" + name + '\'' +
                ", content='" + content +
                '}';
    }

}
