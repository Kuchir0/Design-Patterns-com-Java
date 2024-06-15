package notification;

public class HighPriorityNotification extends NotificationDecorator {
    public HighPriorityNotification(Notification wrappedNotification) {
        super(wrappedNotification);
    }

    @Override
    public void notifyCustomer() {
        System.out.print("ALTA PRIORIDADE: ");
        super.notifyCustomer();
    }
}

