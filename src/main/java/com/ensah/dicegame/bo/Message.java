package com.ensah.dicegame.bo;

public class Message {
    private String msg;
    private MessageTypes type;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MessageTypes getType() {
        return type;
    }

    public void setType(MessageTypes type) {
        this.type = type;
    }

    public Message(String msg, MessageTypes type) {
        this.msg = msg;
        this.type = type;
    }

    @Override
    public String toString() {
        return msg;
    }
}
