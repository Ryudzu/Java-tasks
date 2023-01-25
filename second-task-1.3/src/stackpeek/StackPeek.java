package stackpeek;

import java.util.logging.Logger;

public class StackPeek {

    private static final Logger logger = Logger.getLogger(StackPeek.class.getName());

    private final int[] arr;
    private int top;

    public StackPeek (int size) {
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
            logger.info("Стек пустой");
            System.exit(0);
            return 0;
        }
    }
    public static void main(String[] args) {

        StackPeek stack = new StackPeek(5);
        stack.push(10);
        stack.push(1);
        stack.push(52);
        stack.push(42);

        //Проверка работоспособности метода peek() класса Stack_peek

        logger.info("Последнее добавленное число в Stack - " + stack.peek());

    }
}
