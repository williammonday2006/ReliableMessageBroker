import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Broker broker = new Broker();

        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("=== Reliable Message Broker ===");
            System.out.println("1. Enqueue Message");
            System.out.println("2. Process Batch");
            System.out.println("3. View and Clear DLQ");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter message ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter payload: ");
                    String payload = scanner.nextLine();

                    System.out.print("Enter success chance (0-100): ");
                    int successChance = Integer.parseInt(scanner.nextLine());

                    if (successChance < 0 || successChance > 100) {
                        System.out.println("Success chance must be between 0 and 100.");
                    } else {
                        broker.enqueue(new Message(id, payload, successChance));
                        System.out.println("Message added.");
                    }
                    break;

                case "2":
                    System.out.println("Processing messages...");
                    broker.processBatch();
                    break;

                case "3":
                    broker.displayAndClearDLQ();
                    break;

                case "4":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }
}