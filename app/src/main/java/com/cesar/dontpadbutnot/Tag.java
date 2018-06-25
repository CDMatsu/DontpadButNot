package com.cesar.dontpadbutnot;

import com.google.firebase.database.Exclude;

public class Tag {
    private String chave;
    private String tag;
    private String text;

    public Tag(){

    }

    public Tag(String chave, String tag, String text) {
        this.chave = chave;
        this.tag = tag;
        this.text = text;
    }

    @Exclude
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
