// HandleOrders.java
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HandleOrders {
    private static final double PIZZA_BASE_PRICE = 10.0;
    
    // 新增数据结构
    private ArrayList<CustomPizza> customPizzas = new ArrayList<>();
    private Queue<String> orderQueue = new LinkedList<>();
    private ArrayDeque<String> orderLogsStack = new ArrayDeque<>();
    
    // 原有字段
    private String[] pizzasOrdered = new String[10];
    @SuppressWarnings("unused")
    private String[] pizzaSizesOrdered = new String[10];
    @SuppressWarnings("unused")
    private String[] sideDishesOrdered = new String[20];
    @SuppressWarnings("unused")
    private String[] drinksOrdered = new String[20];
    private double totalOrderPrice = 0.0;
    @SuppressWarnings("unused")
    private int numberOfPizzasOrdered = 0;
    @SuppressWarnings("unused")
    private StringBuilder pizzaOrderSummary = new StringBuilder();
    private Scanner input = new Scanner(System.in);

    public void takeOrder() {
        String orderAnother = "Y";
        @SuppressWarnings("unused")
        int j = 0, m = 0, n = 0, p = 0;

        do {
            // ... 原有披萨选择逻辑保持不变...
            
            // 处理自定义披萨（新增部分）
             int choice = 0;
                        if (choice == 6) {
                double customPizzaPrice = PIZZA_BASE_PRICE;
                StringBuilder customPizzaToppings = new StringBuilder();
                
                int l = 1;
                do {
                    System.out.println("Enter topping #" + l + ". To stop, type 0: ");
                    int toppingChoice = input.nextInt();
                    input.nextLine();
                    
                    if(toppingChoice == 0) break;
                    
                    PizzaToppings selected = PizzaToppings.values()[toppingChoice-1];
                    customPizzaToppings.append(selected.getTopping()).append(", ");
                    customPizzaPrice += selected.getToppingPrice();
                    l++;
                } while(l <= 10);

                // 创建CustomPizza对象并添加到列表
                String toppings = customPizzaToppings.length() > 0 ? 
                    customPizzaToppings.substring(0, customPizzaToppings.length()-2) : "";
                CustomPizza cp = new CustomPizza(toppings, customPizzaPrice);
                customPizzas.add(cp);

                // 添加到订单记录
                pizzasOrdered[j] = "Custom Pizza with " + toppings + ": €" + customPizzaPrice;
                totalOrderPrice += customPizzaPrice;
                numberOfPizzasOrdered++;
                j++;
            }

            // ... 原有披萨尺寸、配菜、饮料选择逻辑保持不变...

            // 添加到订单队列和日志栈（新增部分）
            orderQueue.add("Order #" + (orderQueue.size()+1));
            orderLogsStack.push("New order added - Total: €" + totalOrderPrice);

        } while(orderAnother.equalsIgnoreCase("Y"));
    }

    // 新增自定义披萨显示方法
    public void displayCustomPizzas() {
        System.out.println("\n=== Custom Pizzas ===");
        for(CustomPizza pizza : customPizzas) {
            System.out.println(pizza);
        }
    }

    // 新增日志处理方法
    public void handleOrderLogs() {
        @SuppressWarnings("resource")
        Scanner logScanner = new Scanner(System.in);
        @SuppressWarnings("unused")
        String choice;
        
        do {
            System.out.println("\nOrder Logs Management:");
            System.out.println("1. Display all logs");
            System.out.println("2. Show recent log");
            System.out.println("3. Remove log entry");
            System.out.println("4. Clear all logs");
            System.out.println("5. Check logs status");
            System.out.println("0. Exit");
            
            int option = logScanner.nextInt();
            logScanner.nextLine();
            
            switch(option) {
                case 1:
                    System.out.println("All Order Logs:");
                    orderLogsStack.forEach(System.out::println);
                    break;
                case 2:
                    if(!orderLogsStack.isEmpty()) {
                        System.out.println("Most Recent: " + orderLogsStack.peek());
                    } else {
                        System.out.println("Logs are empty!");
                    }
                    break;
                case 3:
                    if(!orderLogsStack.isEmpty()) {
                        System.out.println("Removed: " + orderLogsStack.pop());
                    } else {
                        System.out.println("Nothing to remove!");
                    }
                    break;
                case 4:
                    orderLogsStack.clear();
                    System.out.println("All logs cleared");
                    break;
                case 5:
                    System.out.println(orderLogsStack.isEmpty() ? 
                        "Logs are empty" : "Logs contain entries");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        } while(true);
    }

    // 新增队列处理方法
    public void processOrderQueue() {
        System.out.println("\n=== Processing Orders ===");
        while(!orderQueue.isEmpty()) {
            String order = orderQueue.poll();
            System.out.println("Processing: " + order);
        }
        System.out.println("All orders processed!");
    }

    // 原有方法保持不变...
    public void createOrderSummary() { /* 原有实现 */ }
    @Override public String toString() {
            return null; /* 原有实现 */ }
}