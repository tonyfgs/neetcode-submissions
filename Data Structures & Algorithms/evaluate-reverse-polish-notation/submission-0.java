class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operator = Set.of("+", "-", "*", "/");
        for(int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if(operator.contains(token)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "+" :
                        stack.push(num1+num2);
                        break;
                    case "-" :
                        stack.push(num2-num1);
                        break;
                    case "*" :
                        stack.push(num1*num2);
                        break;
                    case "/" :
                        stack.push(num2/num1);
                        break;
                }
            }
            else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}
