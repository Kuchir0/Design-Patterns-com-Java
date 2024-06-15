package notification;

public class WithDeliveryTimeNotification extends NotificationDecorator {
    public WithDeliveryTimeNotification(Notification wrappedNotification) {
        super(wrappedNotification);
    }

    @Override
    public void notifyCustomer() {
        super.notifyCustomer();
        System.out.println(" - Tempo estimado de entrega: 45 minutos.");
    }
}

