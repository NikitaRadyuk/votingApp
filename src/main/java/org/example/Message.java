package org.example;

import java.time.LocalDateTime;

public class Message {
    String text;
    LocalDateTime time;

    public Message(String text) {
        this.text = text;
        time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Сообщение \"" + text + '\'' +
                "\" было написано: " + time;
    }
}
