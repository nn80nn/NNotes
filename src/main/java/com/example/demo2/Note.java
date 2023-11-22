package com.example.demo2;


public class Note {
    @JSONField(name = "NAME")
    private String name;

    @JSONField(name = "NTEXT")
    private String ntext;

    @JSONField(name = "DATE OF NOTE")
    private String dateOfNote;

    public Note(String name, String ntext, String dateOfNote) {
        super();
        this.name = name;
        this.ntext= ntext;
        this.dateOfNote = dateOfNote;
}}

