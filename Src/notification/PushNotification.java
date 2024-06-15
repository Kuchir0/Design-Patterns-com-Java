package notification;

public class PushNotification extends Notification {
    @Override
    public void notifyCustomer() {
        System.out.println("Enviando notificação Push...");
    }
}
