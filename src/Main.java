public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();

        broker.enqueue(new Message("001", "First message", 90));
        broker.enqueue(new Message("002", "Second message", 50));
        broker.enqueue(new Message("003", "Third message", 20));
        broker.enqueue(new Message("004", "Fourth message", 75));

        System.out.println("Processing batch:");
        broker.processBatch();
    }
}