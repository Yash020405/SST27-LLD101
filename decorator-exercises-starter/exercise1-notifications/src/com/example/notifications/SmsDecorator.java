package com.example.notifications;

/**
 * Concrete decorator that adds SMS sending logic.
 */
public class SmsDecorator extends NotifierDecorator {
    private final String phoneNumber;

    public SmsDecorator(Notifier wrapped, String phoneNumber) {
        super(wrapped);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String text) {
        // Simulate sending an SMS
        System.out.println("[SMS -> " + phoneNumber + "]: " + text);
        super.notify(text);
    }
}
