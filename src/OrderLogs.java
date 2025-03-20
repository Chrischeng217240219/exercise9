import java.util.ArrayDeque;
import java.util.Scanner;

public class OrderLogs {
    private ArrayDeque<String> orderLogs;

    public OrderLogs() {
        orderLogs = new ArrayDeque<>();
    }

    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    private void mostRecentLogEntry() {
        if(!orderLogs.isEmpty()) {
            System.out.println("Most recent log: " + orderLogs.peek());
        }
    }

    private String getOrderLog() {
        return orderLogs.pop();
    }

    private void removeAllLogEntries() {
        orderLogs.clear();
    }

    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    public void handleLogs() {
        try (Scanner scanner = new Scanner(System.in)) {
            String continueChoice;
            
            do {
                System.out.println("\nChoose what you want to do with order logs:");
                System.out.println("1. Display all logs");
                System.out.println("2. Display most recent log");
                System.out.println("3. Remove a log entry");
                System.out.println("4. Remove all log entries");
                System.out.println("5. Check if log is empty");
                
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch(choice) {
                    case 1:
                        System.out.println("All logs:");
                        orderLogs.forEach(System.out::println);
                        break;
                    case 2:
                        if(orderLogsEmpty()) System.out.println("Log is empty!");
                        else mostRecentLogEntry();
                        break;
                    case 3:
                        if(orderLogsEmpty()) System.out.println("Log is empty!");
                        else System.out.println("Removed: " + getOrderLog());
                        break;
                    case 4:
                        removeAllLogEntries();
                        System.out.println("All logs cleared");
                        break;
                    case 5:
                        System.out.println(orderLogsEmpty() ? 
                            "Log is empty" : "Log contains entries");
                        break;
                }
                
                System.out.println("Continue with logs? (Y/N)");
                continueChoice = scanner.nextLine();
            } while(continueChoice.equalsIgnoreCase("Y"));
        }
    }
}