package com.filipePires.API_EmailSender.dto;


import lombok.*;


public class EmailDTO {

    private String owner;
    private String fromWho;
    private String toWho;
    private String title;
    private String message;

    public EmailDTO(){}

    public EmailDTO(String owner, String fromWho, String toWho, String title, String message) {
        this.owner = owner;
        this.fromWho = fromWho;
        this.toWho = toWho;
        this.title = title;
        this.message = message;
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getFromWho() {
        return fromWho;
    }

    public void setFromWho(String fromWho) {
        this.fromWho = fromWho;
    }

    public String getToWho() {
        return toWho;
    }

    public void setToWho(String toWho) {
        this.toWho = toWho;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
