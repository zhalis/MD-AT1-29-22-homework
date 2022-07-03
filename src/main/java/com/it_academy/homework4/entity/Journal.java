package com.it_academy.homework4.entity;

import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang.StringUtils.EMPTY;

public class Journal {

    private String title;
    private Contacts contacts;
    private List<Article> articles;

    public Journal() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal:\n  title: %s\n  contacts: %s\n  articles: %s"
                .formatted(title, contacts, articles.stream()
                        .map(Article::toString)
                        .map("\n      article: "::concat)
                        .reduce(EMPTY, String::concat));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return Objects.equals(title, journal.title)
                && Objects.equals(contacts, journal.contacts)
                && Objects.equals(articles, journal.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, contacts, articles);
    }
}
