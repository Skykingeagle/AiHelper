package com.example.aihelper;

public class Message {

    public static String sent_by_me = "me";
    public static String sent_by_ai = "bot";

    String message, sendby;

    public Message(String message, String sendby) {
        this.message = message;
        this.sendby = sendby;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendby() {
        return sendby;
    }

    public void setSendby(String sendby) {
        this.sendby = sendby;
    }
}
