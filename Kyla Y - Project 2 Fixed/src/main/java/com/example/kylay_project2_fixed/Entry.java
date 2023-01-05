package com.example.kylay_project2_fixed;

public class Entry {
    private String entryTitle;
    private String entry;
    private static int entryNum = 1;

    //Constructor --------------------------
    Entry(){
        this.entryTitle = "Journal entry #" + String.valueOf(entryNum);
        this.entry = "";
        entryNum++;
    }
    Entry(String entryTitle, String entry){
        this.entryTitle = entryTitle;
        this.entry = entry;
        entryNum++;
    }

    //Getters & Setters ---------------------
    public void setEntryTitle(String entryTitle){this.entryTitle = entryTitle;}
    public String getEntryTitle(){return this.entryTitle;}

    public void setEntry(String entry){this.entry = entry;}
    public String getEntry(){return this.entry;}

    //toString method -----------------------
    public String toString(){return this.entryTitle;}
    private String allToString(){return this.entryTitle + " - " + this.entry;}

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Entry)) return false;

        Entry other = (Entry) o;
        if (this.allToString().equals(other.allToString())){
            return true;
        } else{
            return false;
        }
    }
}
