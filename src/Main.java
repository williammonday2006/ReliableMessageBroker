public class Main {
    public static void main(String[] args) {
        QueueInterface<Message> queue = new LinkedQueue<>();

        try {
            queue.enqueue(new Message("001", "First message"));
            queue.enqueue(new Message("002", "Second message"));
            queue.enqueue(new Message("003", "Third message"));

            System.out.println("Dequeuing messages:");

            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }
        } catch (QueueOverflowException | QueueUnderflowException e) {
            System.out.println("Queue error: " + e.getMessage());
        }
    }
}