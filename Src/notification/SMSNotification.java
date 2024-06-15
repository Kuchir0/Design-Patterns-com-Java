package notification;

public class SMSNotification extends Notification {
    @Override
    public void notifyCustomer() {
        System.out.println("Enviando notificação por SMS...");
    }
}

