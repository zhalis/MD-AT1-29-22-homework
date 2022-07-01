package com.it_academy.homework4.dom;

public class DOMParseDemo {

    private static final String RESOURCE_NAME = "journal.xml";

    public static void main(String[] args) {
        System.out.println(JournalDomParser.parseJournal(RESOURCE_NAME));
    }
}
