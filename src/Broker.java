import java.util.Random;

public class Broker {
    private QueueInterface<Message> queue;
    private Random random;

    public Broker() {
        queue = new LinkedQueue<>();
        random = new Random();
    }

    public void enqueue(Message message) {
        try {
            queue.enqueue(message);
        } catch (QueueOverflowException e) {
            System.out.println("Could not enqueue message: " + e.getMessage());
        }
    }

    public void processBatch() {
        int batchSize = queue.size();

        for (int i = 0; i < batchSize; i++) {
            try {
                Message message = queue.dequeue();

                if (random.nextInt(100) < message.getSuccessChance()) {
                    System.out.println("SUCCESS: " + message);
                } else {
                    message.incrementRetryCount();
                    queue.enqueue(message);
                    System.out.println("FAILED: " + message);
                }
            } catch (QueueUnderflowException | QueueOverflowException e) {
                System.out.println("Queue error: " + e.getMessage());
            }
        }
    }
}