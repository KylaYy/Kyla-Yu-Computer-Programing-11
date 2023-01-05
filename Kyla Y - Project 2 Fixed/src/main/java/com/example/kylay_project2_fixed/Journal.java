package com.example.kylay_project2_fixed;

import java.util.ArrayList;

public class Journal {
    private String title;
    private String authorName;
    private ArrayList<Entry> entries;
    private static int journalNum = 1;

    Journal(){
        title = "Journal " + String.valueOf(journalNum);
        journalNum++;
        authorName = "";
        entries = new ArrayList<>();
    }

    public Journal(String title, String authorName){
        this.title = title;
        this.authorName = authorName;
        this.entries = new ArrayList<>();
    }

    //Getters & Setters ---------
    public void setTitle(String title){this.title = title;}
    public String getTitle(){return this.title;}

    public void setAuthorName(String authorName){this.authorName = authorName;}
    public String getAuthorName(){return this.authorName;}

    public void addEntry(Entry entry){this.entries.add(entry);}
    public ArrayList<Entry> getEntries() {return entries;}
    public void setEntries(ArrayList<Entry> entryList){
        entries = entryList;
    }

    public String getFileName(){return toString().replaceAll(" ", "") + ".txt";}

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Journal)) return false;
        Journal other = (Journal) o;

        if (this.toString().equals(other.toString())){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        return title.length() + authorName.length();
    }

    @Override
    public String toString(){return title + " - " + authorName;}
}
