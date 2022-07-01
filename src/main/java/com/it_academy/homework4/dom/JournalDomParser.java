package com.it_academy.homework4.dom;

import com.it_academy.homework4.entity.Article;
import com.it_academy.homework4.entity.Contacts;
import com.it_academy.homework4.entity.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JournalDomParser {

    private static final String TITLE = "title";
    private static final String AUTHOR = "author";
    private static final String URL = "url";
    private static final String HOTKEYS = "hotkeys";
    private static final String ADDRESS = "address";
    private static final String TEL = "tel";
    private static final String EMAIL = "email";
    private static final String ARTICLES = "articles";
    private static final String CONTACTS = "contacts";

    public static Journal parseJournal(String resourceName) {
        Document document = JournalDomParser.parseXMLDocument(resourceName);
        NodeList nodeList = JournalDomParser.getNodeList(document);
        Journal journal = new Journal();
        getNodeListStream(nodeList)
                .filter(Element.class::isInstance)
                .forEach(node -> setJournalNodeValues(journal, node));
        return journal;
    }

    private static void setJournalNodeValues(Journal journal, Node node) {
        String content = node.getLastChild().getTextContent().trim();
        switch (node.getNodeName()) {
            case TITLE -> journal.setTitle(content);
            case CONTACTS -> journal.setContacts(convertContacts(node));
            case ARTICLES -> journal.setArticles(convertArticles(node));
        }
    }

    private static Contacts convertContacts(Node node) {
        Contacts contacts = new Contacts();
        getNodeListStream(node.getChildNodes())
                .filter(Element.class::isInstance)
                .forEach(childNode -> setContactField(contacts, childNode));
        return contacts;
    }

    private static void setContactField(Contacts contacts, Node node) {
        String content = node.getLastChild().getTextContent().trim();
        switch (node.getNodeName()) {
            case ADDRESS -> contacts.setAddress(content);
            case TEL -> contacts.setTel(content);
            case EMAIL -> contacts.setEmail(content);
            case URL -> contacts.setUrl(content);
        }
    }

    private static List<Article> convertArticles(Node node) {
        return getNodeListStream(node.getChildNodes())
                .filter(Element.class::isInstance)
                .map(JournalDomParser::convertArticle)
                .collect(Collectors.toList());
    }

    private static Article convertArticle(Node node) {
        Article article = new Article();
        article.setId(node.getAttributes().getNamedItem("ID").getNodeValue());
        getNodeListStream(node.getChildNodes())
                .filter(Element.class::isInstance)
                .forEach(childNode -> setArticleField(article, childNode));
        return article;
    }

    private static void setArticleField(Article article, Node node) {
        String content = node.getLastChild().getTextContent().trim();
        switch (node.getNodeName()) {
            case TITLE -> article.setTitle(content);
            case AUTHOR -> article.setAuthor(content);
            case URL -> article.setUrl(content);
            case HOTKEYS -> article.setHotkeys(convertHotkeys(node.getChildNodes()));
        }
    }

    private static List<String> convertHotkeys(NodeList nodeList) {
        return getNodeListStream(nodeList)
                .filter(Element.class::isInstance)
                .map(node -> node.getLastChild().getTextContent().trim())
                .collect(Collectors.toList());
    }

    private static Document parseXMLDocument(String path) {
        DocumentBuilder documentBuilder = createDocumentBuilder();
        try {
            return documentBuilder.parse(ClassLoader.getSystemResourceAsStream(path));
        } catch (SAXException e) {
            System.out.println("SAXException log");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("IOException log");
            throw new RuntimeException(e);
        }
    }

    private static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            return documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfigurationException log");
            throw new RuntimeException(e);
        }
    }

    private static NodeList getNodeList(Document document) {
        return document.getDocumentElement().getChildNodes();
    }

    private static Stream<Node> getNodeListStream(NodeList nodeList) {
        return IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item);
    }
}
