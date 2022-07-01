package com.it_academy.homework4.stax;

import javax.xml.stream.XMLStreamException;

public class StaxDemo {

    private static final String RESOURCE_NAME = "journal.xml";

    public static void main(String[] args) throws XMLStreamException {
        System.out.println(JournalStaxParser.parseJournal(RESOURCE_NAME));
    }
}
