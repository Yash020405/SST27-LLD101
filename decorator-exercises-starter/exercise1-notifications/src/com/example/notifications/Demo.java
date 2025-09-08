package com.example.notifications;

/**
 * Starter demo that uses only the existing Email notifier.
 * TODOs guide you to add decorators and compose them.
 */
public class Demo {
    public static void main(String[] args) {
        Notifier base = new EmailNotifier("user@example.com");

        // Baseline behavior (already works)
        base.notify("Baseline email only.");

        // === Decorator Compositions ===
        Notifier emailAndSms = new SmsDecorator(base, "+91-99999-11111");
        emailAndSms.notify("Email + SMS notification.");

        Notifier emailAndWhatsApp = new WhatsAppDecorator(base, "user_wa");
        emailAndWhatsApp.notify("Email + WhatsApp notification.");

        Notifier emailAndSlack = new SlackDecorator(base, "deployments");
        emailAndSlack.notify("Email + Slack notification.");

        Notifier fullCombo = new SlackDecorator(
                new WhatsAppDecorator(new SmsDecorator(base, "+91-99999-11111"), "user_wa"), "deployments");
        fullCombo.notify("Email + SMS + WhatsApp + Slack notification.");
    }
}
