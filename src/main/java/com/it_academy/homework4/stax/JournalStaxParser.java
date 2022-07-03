package com.it_academy.homework4.stax;

import com.it_academy.homework4.entity.Article;
import com.it_academy.homework4.entity.Contacts;
import com.it_academy.homework4.entity.Journal;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JournalStaxParser {

    private static final String JOURNAL = "journal";
    private static final String CONTACTS = "contacts";
    private static final String ARTICLES = "articles";
    private static final String ARTICLE = "article";
    private static final String HOTKEYS = "hotkeys";
    private static final String TITLE = "title";
    private static final String ADDRESS = "address";
    private static final String TEL = "tel";
    private static final String EMAIL = "email";
    private static final String URL = "url";
    private static final String AUTHOR = "author";
    private static final String HOTKEY = "hotkey";

    /**
     * Parse XML file in journal object
     *
     * @param resourceName XML file to be parsed
     * @return Journal object
     * @throws XMLStreamException
     */
    public static Journal parseJournal(String resourceName) throws XMLStreamException {
        Journal journal = null;
        Contacts contacts = null;
        List<Article> articles = null;
        List<String> hotkeys = null;
        Article article = null;
        String tagContent = null;
        String currentObject = null;

        XMLStreamReader reader = reader(resourceName);
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT -> {
                    switch (reader.getLocalName()) {
                        case JOURNAL -> {
                            currentObject = reader.getLocalName();
                            journal = new Journal();
                        }
                        case CONTACTS -> {
                            currentObject = reader.getLocalName();
                            contacts = new Contacts();
                        }
                        case ARTICLES -> articles = new ArrayList<>();
                        case ARTICLE -> {
                            article = new Article();
                            article.setId(reader.getAttributeValue(0));
                            currentObject = reader.getLocalName();
                        }
                        case HOTKEYS -> hotkeys = new ArrayList<>();
                    }
                }
                case XMLStreamConstants.CHARACTERS -> tagContent = reader.getText().trim();
                case XMLStreamConstants.END_ELEMENT -> {
                    switch (reader.getLocalName()) {
                        case TITLE -> {
                            switch (currentObject) {
                                case JOURNAL -> journal.setTitle(tagContent);
                                case ARTICLE -> article.setTitle(tagContent);
                            }
                        }
                        case URL -> {
                            switch (currentObject) {
                                case CONTACTS -> contacts.setUrl(tagContent);
                                case ARTICLE -> article.setUrl(tagContent);
                            }
                        }
                        case ADDRESS -> contacts.setAddress(tagContent);
                        case TEL -> contacts.setTel(tagContent);
                        case EMAIL -> contacts.setEmail(tagContent);
                        case AUTHOR -> article.setAuthor(tagContent);
                        case CONTACTS -> journal.setContacts(contacts);
                        case ARTICLES -> journal.setArticles(articles);
                        case ARTICLE -> articles.add(article);
                        case HOTKEY -> hotkeys.add(tagContent);
                        case HOTKEYS -> article.setHotkeys(hotkeys);
                    }
                }
            }
        }
        return journal;
    }

    private static XMLStreamReader reader(String resourceName) {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {
            return factory.createXMLStreamReader(
                    ClassLoader.getSystemResourceAsStream(resourceName));
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }
}
