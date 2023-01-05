package com.example.kylay_project2_fixed;

import javafx.scene.control.ListView;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class FileMethods {
    private static String ALL_JOURNALS = "all_journals.txt";

    // write a method to write journals names to a text file
    public static void writeJournal(Journal journal) throws IOException {
        File file = new File(ALL_JOURNALS); // create file with name ALL_JOURNALS
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(journal.toString() + "\n");
        bw.close();
    }

    public static HashSet<Journal> loadJournals() throws IOException {
        HashSet<Journal> journals = new HashSet<>();
        File file = new File(ALL_JOURNALS);
        if (!file.exists()) {return journals;}
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            journals.add(parseJournal(line));
        }
        br.close();
        return journals;
    }

    private static Journal parseJournal(String s){
        s = s.replaceAll(" - ", "-");
        String [] strings = s.split("-");
        return new Journal(strings[0], strings[1]);
    }

    public static void createJournal(Journal journal) throws IOException {
        File file = new File(journal.getFileName());
        file.createNewFile();
    }

    public static void writeEntry(Journal journal, Entry entry) throws IOException {
        File file = new File(journal.getFileName());
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(entry.getEntryTitle() + "|\n" + entry.getEntry() + "|\n[END]\n");
        bw.close();
    }

    public static ArrayList<Entry> loadEntries(Journal journal) throws IOException {
        File file = new File(journal.getFileName());
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String entryLine = "";
        ArrayList<Entry> entryList = new ArrayList<>();
        while ((line = br.readLine()) != null){
            if (line.equals("[END]")){
                entryList.add(parseEntry(entryLine));
                entryLine = "";
            }
            else{
                entryLine += line;
            }
        }
        return entryList;
    }

    public static Entry parseEntry(String entryLine){
        String[] entryInfo = entryLine.split("\\|");
        if (entryInfo.length < 2){return null;}
        Entry entry = new Entry(entryInfo[0], entryInfo[1]);
        return entry;
    }
}
