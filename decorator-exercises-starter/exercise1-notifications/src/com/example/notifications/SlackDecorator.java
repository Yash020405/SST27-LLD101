package com.example.notifications;

/**
 * Concrete decorator that adds Slack sending logic.
 */
public class SlackDecorator extends NotifierDecorator {
    private final String channel;

    public SlackDecorator(Notifier wrapped, String channel) {
        super(wrapped);
        this.channel = channel;
    }

    @Override
    public void notify(String text) {
        // Simulate sending a Slack message
        System.out.println("[Slack -> " + channel + "]: " + text);
        super.notify(text);
    }
}
