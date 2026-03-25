import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> mainQueue;
    private Queue<Integer> tempQueue;
    
    public MyStack() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        // Push to temp queue
        tempQueue.offer(x);
        
        // Move all elements from main queue to temp queue
        while (!mainQueue.isEmpty()) {
            tempQueue.offer(mainQueue.poll());
        }
        
        // Swap references so mainQueue always contains elements in stack order
        Queue<Integer> swap = mainQueue;
        mainQueue = tempQueue;
        tempQueue = swap;
    }
    
    public int pop() {
        return mainQueue.poll();
    }
    
    public int top() {
        return mainQueue.peek();
    }
    
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}