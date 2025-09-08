package com.example.notifications;

/**
 * Concrete decorator that adds WhatsApp sending logic.
 */
public class WhatsAppDecorator extends NotifierDecorator {
    private final String userId;

    public WhatsAppDecorator(Notifier wrapped, String userId) {
        super(wrapped);
        this.userId = userId;
    }

    @Override
    public void notify(String text) {
        // Simulate sending a WhatsApp message
        System.out.println("[WhatsApp -> " + userId + "]: " + text);
        super.notify(text);
    }
}
