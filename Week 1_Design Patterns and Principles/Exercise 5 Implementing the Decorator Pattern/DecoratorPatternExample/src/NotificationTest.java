import notification.*;

public class NotificationTest {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();

        // Add SMS functionality to EmailNotifier
        notifier = new SMSNotifierDecorator(notifier);

        // Add Slack functionality to the SMS and EmailNotifier
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Hello, this is a test message.");
    }
}