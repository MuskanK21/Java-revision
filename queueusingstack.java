class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;
    
    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }
    
    public void push(int x) {
        inputStack.push(x);
    }
    
    public int pop() {
        // If output stack is empty, transfer elements from input stack
        if (outputStack.isEmpty()) {
            transferElements();
        }
        return outputStack.pop();
    }
    
    public int peek() {
        // If output stack is empty, transfer elements from input stack
        if (outputStack.isEmpty()) {
            transferElements();
        }
        return outputStack.peek();
    }
    
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
    
    private void transferElements() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }
}