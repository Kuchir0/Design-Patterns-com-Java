package notification;

public class EmailNotification extends Notification {
    @Override
    public void notifyCustomer() {
        System.out.println("Enviando notificação por Email...");
    }
}
