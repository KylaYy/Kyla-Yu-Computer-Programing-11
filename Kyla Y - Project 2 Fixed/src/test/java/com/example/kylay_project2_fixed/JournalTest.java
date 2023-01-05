package com.example.kylay_project2_fixed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JournalTest {
    private Journal journal1;
    private Journal journal2;
    private Journal journal3;
    private Entry entry1;
    private Entry entry2;

    @BeforeEach
    void setUp() {
        journal1 = new Journal("title1", "author1");
        journal2 = new Journal("title2", "author2");
        journal3 = new Journal("title1", "author1");
        // define the entries
    }
    @Test
    void testEquals(){
        assertEquals(journal1, journal3);
    }
    @Test
    void testNotEquals(){
        assertNotEquals(journal1, journal2);
    }
    @Test
    void testFileName(){
        String expected = "title1-author1.txt";
        assertEquals(expected, journal1.getFileName());
    }

    @Test
    void testGetEntries() {
        ArrayList<Entry> expected = new ArrayList<>();
        expected.add(entry1);
        expected.add(entry2);

        journal1.addEntry(entry1);
        journal1.addEntry(entry2);

        assertEquals(expected, journal1.getEntries());
    }
}