package com.example.kylay_project2_fixed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileMethodsTest {
    private Journal journal1;
    private Journal journal2;
    private final String JOURNAL_TITLE_1 = "TEST Journal Title 1";
    private final String JOURNAL_AUTHOR_1 = "TEST Journal Author 1";
    private final String JOURNAL_TITLE_2 = "TEST Journal Title 2";
    private final String JOURNAL_AUTHOR_2 = "TEST Journal Author 2";
    private Entry entry1;
    private Entry entry2;
    private final String ENTRY_TITLE_1 = "Entry Title1";
    private final String ENTRY_TEXT_1 = "Entry1 Text";
    private final String ENTRY_TITLE_2 = "Entry Title2";
    private final String ENTRY_TEXT_2 = "Entry2 Text";

    @BeforeEach
    void setUp() {
        journal1 = new Journal(JOURNAL_TITLE_1, JOURNAL_AUTHOR_1);
        journal2 = new Journal(JOURNAL_TITLE_2, JOURNAL_AUTHOR_2);
        entry1 = new Entry(ENTRY_TITLE_1, ENTRY_TEXT_1);
        entry2 = new Entry(ENTRY_TITLE_2, ENTRY_TEXT_2);

        ArrayList<Entry> entryList = new ArrayList<>();
        entryList.add(entry1);
        entryList.add(entry2);

        journal1.setEntries(entryList);
    }

    @Test
    void testLoadEntries() throws IOException {
        // Setup a test file
        File file1 = new File(journal1.getFileName());
        file1.createNewFile();
        file1.deleteOnExit();

        // Write test here. Write entries to journal1 and then try to load it
        List<Entry> expected = new ArrayList<>();
        expected.add(entry1);
        expected.add(entry2);

        FileMethods.writeEntry(journal1, entry1);
        FileMethods.writeEntry(journal1, entry2);

        assertEquals(expected, FileMethods.loadEntries(journal1));
    }

    @Test
    void testLoadEntriesWithEmptyNoEntries() throws IOException {
        // Setup a test file
        File file2 = new File(journal2.getFileName());
        file2.createNewFile();
        file2.deleteOnExit();

        // Write test here
        List<Entry> expected = new ArrayList<>();

        assertEquals(expected, FileMethods.loadEntries(journal2));

    }

    @Test
    void testParseEmptyEntry() {
        assertEquals(null, FileMethods.parseEntry(""));
    }

    @Test
    void testParseEntry() throws IOException {
        String entry1TestLine = ENTRY_TITLE_1 + "|" + ENTRY_TEXT_1;
        assertEquals(entry1, FileMethods.parseEntry(entry1TestLine));
    }
}