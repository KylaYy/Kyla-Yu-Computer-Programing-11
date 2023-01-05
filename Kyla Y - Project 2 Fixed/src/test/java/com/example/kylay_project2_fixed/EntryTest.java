package com.example.kylay_project2_fixed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryTest {
    Entry entry1;
    Entry entry2;
    Entry entry3;


    @BeforeEach
    void setUp() {
        entry1 = new Entry("Title 1", "Text 1");
        entry2 = new Entry("Title 2", "Title 2");
        entry3 = new Entry("Title 1", "Text 1");
    }

    @Test
    void testEquals(){assertEquals(entry1, entry3);}

    @Test
    void testNotEquals(){assertNotEquals(entry1, entry3);}
}