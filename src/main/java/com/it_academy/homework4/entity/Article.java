package com.it_academy.homework4.entity;

import java.util.List;

import static org.apache.commons.lang.StringUtils.EMPTY;

public class Article {

    private String id;
    private String title;
    private String author;
    private String url;
    private List<String> hotkeys;

    public Article() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getHotkeys() {
        return hotkeys;
    }

    public void setHotkeys(List<String> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return ("""
                id%s
                         title: %s
                         author: %s
                         url: %s
                         hotkeys: %s""")
                .formatted(id, title, author, url, hotkeys.stream()
                        .map("\n            hotkey: "::concat)
                        .reduce(EMPTY, String::concat));
    }
}
