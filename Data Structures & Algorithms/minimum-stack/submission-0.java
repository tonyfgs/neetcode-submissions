class MinStack {

    private Stack<int[]> stack;
    public MinStack() {
        super();
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty() || getMin() > val) {
            stack.push(new int[]{val, val});
        }
        else  {
            
            stack.push(new int[]{val, getMin()});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];    
    }
    
    public int getMin() {
        return  stack.peek()[1];
    }
}
