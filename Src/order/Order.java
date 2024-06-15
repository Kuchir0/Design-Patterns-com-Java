package order;

import java.util.ArrayList;
import java.util.List;
import observer.Observer;

public class Order {
    private String status;
    private List<Observer> observers = new ArrayList<>();

    public String getStatus() {
        return status;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(status);
        }
    }
}
