package com.it_academy.homework4.dom;

import com.it_academy.homework4.entity.Article;
import com.it_academy.homework4.entity.Contacts;
import com.it_academy.homework4.entity.Journal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import javax.xml.stream.XMLStreamException;
import java.util.List;

import static com.it_academy.homework4.dom.JournalDomParser.parseJournal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@Execution(ExecutionMode.CONCURRENT)
class JournalDomParserTest {

    @Test
    public void testParseContacts() {
        Contacts contacts = new Contacts();
        contacts.setUrl("www.j.com");
        contacts.setEmail("j@j.com");
        contacts.setTel("8-3232-121212");
        contacts.setAddress("Minsk");
        assertEquals(contacts, parseJournal("contacts.xml").getContacts(),
                "Contacts object is not parsed correctly");
    }

    @Test
    public void testParserTitle() {
        Journal journal = new Journal();
        journal.setTitle("Issue overview");
        assertEquals(journal.getTitle(), parseJournal("title.xml").getTitle(),
                "Title object is not parsed correctly");
    }

    @Test
    public void testParseArticles() throws XMLStreamException {
        Article article = new Article();
        article.setId("1");
        article.setTitle("Issue overview");
        article.setAuthor("Jhon");
        article.setUrl("/article1");
        article.setHotkeys(List.of("language"));
        assertEquals(article, parseJournal("article.xml").getArticles().get(0),
                "Articles object is not parsed correctly");
    }

    @Test
    public void testNotFile() {
        assertThrows(RuntimeException.class, () -> parseJournal(""),
                "Document is not found");
    }
}