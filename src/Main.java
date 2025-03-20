// Main.java
public class Main {
    public static void main(String[] args) {
        HandleOrders handleOrders = new HandleOrders();
        
        // 处理订单
        handleOrders.takeOrder();
        
        // 显示定制披萨
        handleOrders.displayCustomPizzas();
        
        // 处理日志
        handleOrders.handleOrderLogs();
        
        // 处理订单队列
        handleOrders.processOrderQueue();
        
        // 生成最终订单摘要
        handleOrders.createOrderSummary();
        System.out.println(handleOrders);
    }
}