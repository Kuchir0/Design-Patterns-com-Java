package main;

import notification.HighPriorityNotification;
import notification.Notification;
import notification.NotificationFactory;
import notification.WithDeliveryTimeNotification;
import observer.Customer;
import order.Order;
import singleton.OrderManager;

public class Main {
    public static void main(String[] args) {
        /* Singleton */
        OrderManager orderManager = OrderManager.getInstance();

        /* Observer */
        Order order1 = new Order();
        Order order2 = new Order();
        Customer customer1 = new Customer("Cliente 1");
        Customer customer2 = new Customer("Cliente 2");

        order1.addObserver(customer1);
        order1.addObserver(customer2);

        order2.addObserver(customer1);

        /* Adicionar pedidos */
        int orderId1 = orderManager.addOrder(order1);
        int orderId2 = orderManager.addOrder(order2);

        /* Factory Method */
        Notification emailNotification = NotificationFactory.createNotification("EMAIL");
        Notification smsNotification = NotificationFactory.createNotification("SMS");

        /* Decorator */
        Notification highPriorityEmail = new HighPriorityNotification(emailNotification);
        Notification deliveryTimeSMS = new WithDeliveryTimeNotification(smsNotification);

        /* Simulação de mudança de status do pedido */
        orderManager.updateOrderStatus(orderId1, "Pedido recebido");
        highPriorityEmail.notifyCustomer();
        deliveryTimeSMS.notifyCustomer();

        orderManager.updateOrderStatus(orderId1, "Pedido despachado");

        /* Listar pedidos */
        orderManager.listOrders();

        /* Remover pedido */
        orderManager.removeOrder(orderId2);

        /* Listar pedidos após remoção */
        orderManager.listOrders();
    }
}
