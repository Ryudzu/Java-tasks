public class Stack_peek {

    private final int[] arr;
    private int top;

    public Stack_peek (int size) {
        this.arr = new int[size];
        this.top = -1;
    }

    public void push(int data) {
        arr[++top] = data;
    }

    public int peek() {
        try {
            return arr[top];
        } catch (Exception e) {
            System.out.println("Стек пустой");
            System.exit(0);
            return 0;
        }
    }

    public static void main(String[] args) {

        Stack_peek stack = new Stack_peek(5);
        stack.push(10);
        stack.push(1);
        stack.push(52);
        stack.push(42);

        //Проверка работоспособности метода peek() класса Stack_peek
        System.out.println(stack.peek());

    }
}
