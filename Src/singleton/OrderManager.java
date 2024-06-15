package singleton;

import java.util.HashMap;
import java.util.Map;
import order.Order;

public class OrderManager {
    private static OrderManager instance;
    private Map<Integer, Order> orders;
    private int nextOrderId;

    private OrderManager() {
        orders = new HashMap<>();
        nextOrderId = 1;
    }

    public static synchronized OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    /* Adicionar um novo pedido */
    public int addOrder(Order order) {
        int orderId = nextOrderId++;
        orders.put(orderId, order);
        System.out.println("Pedido " + orderId + " adicionado.");
        return orderId;
    }

    /* Remover um pedido */
    public void removeOrder(int orderId) {
        if (orders.containsKey(orderId)) {
            orders.remove(orderId);
            System.out.println("Pedido " + orderId + " removido.");
        } else {
            System.out.println("Pedido " + orderId + " não encontrado.");
        }
    }

    /* Atualizar o status de um pedido */
    public void updateOrderStatus(int orderId, String status) {
        Order order = orders.get(orderId);
        if (order != null) {
            order.setStatus(status);
            System.out.println("Pedido " + orderId + " atualizado para o status: " + status);
        } else {
            System.out.println("Pedido " + orderId + " não encontrado.");
        }
    }

    /*  Listar todos os pedidos */
    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("Nenhum pedido encontrado.");
        } else {
            for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
                System.out.println("Pedido ID: " + entry.getKey() + ", Status: " + entry.getValue().getStatus());
            }
        }
    }
}
