package com.example.demo2;


public class Note {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNtext() {
        return ntext;
    }

    public void setNtext(String ntext) {
        this.ntext = ntext;
    }

    public String getDateOfNote() {
        return dateOfNote;
    }

    public void setDateOfNote(String dateOfNote) {
        this.dateOfNote = dateOfNote;
    }

    //@JSONField(name = "name")
    private String name;

    //@JSONField(name = "ntext")
    private String ntext;

    //@JSONField(name = "dateOfNote")
    private String dateOfNote;

    private Note(){}

    public Note(String name, String ntext, String dateOfNote) {
        this.name = name;
        this.ntext= ntext;
        this.dateOfNote = dateOfNote;
}}

