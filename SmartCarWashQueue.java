// Class to manage cars in a circular queue for washing station
class WashingQueue {
    private String[] station;
    private int front;
    private int rear;
    private int stationCapacity;

    public WashingQueue(int stationCapacity) {
        this.stationCapacity = stationCapacity;
        this.station = new String[stationCapacity];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % stationCapacity == front;
    }

    public void enqueue(String car) {
        if (isFull()) {
            System.out.println("Car Stations are occupied");
            return;
        }
        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % stationCapacity;
        }
        station[rear] = car;
        System.out.println("Car " + car + " sent for Washing");
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Waiting Hall is Empty");
            return null;
        }
        String dequeuedCar = station[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % stationCapacity;
        }
        return dequeuedCar;
    }
}

// Node class for the linked list
class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

// Call log using linked list
class CallLog {
    private Node front;
    private Node rear;

    public CallLog() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(String car) {
        Node newNode = new Node(car);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Unable to dequeue.");
            return null;
        }
        String dequeuedCar = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedCar;
    }
}
