package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String userId;

    public WhatsAppDecorator(Notifier wrapped, String userId) {
        super(wrapped);
        this.userId = userId;
    }

    @Override
    public void notify(String text) {
        System.out.println("[WhatsApp -> " + userId + "]: " + text);
        super.notify(text);
    }
}
