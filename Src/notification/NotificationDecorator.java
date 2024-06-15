package notification;

public abstract class NotificationDecorator extends Notification {
    protected Notification wrappedNotification;

    public NotificationDecorator(Notification wrappedNotification) {
        this.wrappedNotification = wrappedNotification;
    }

    @Override
    public void notifyCustomer() {
        wrappedNotification.notifyCustomer();
    }
}
