package stackpeek;

import java.util.Scanner;
import java.util.logging.Level;
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
        top += 1;
        arr[top] = data;
    }

    public int peek() {
        try {
            return arr[top];
        } catch (Exception e) {
            logger.log(Level.INFO, () -> "Стек пустой.");
            System.exit(0);
            return 0;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        logger.log(Level.INFO, () -> "Введите размер стека: ");
        int size = input.nextInt();
        StackPeek stack = new StackPeek(size);

        logger.log(Level.INFO, "Выберите, какую операцию хотите произвести\n1. Добавление элементов в стек.\n2. Показать последний элемент.");
        int choice = input.nextInt();

        if (choice == 1) {
            logger.log(Level.INFO, "Введите числа, которые хотите добавить в стек: ");
            for (int i = 0; i < size; i++) {
                int element = input.nextInt();
                stack.push(element);
            }

            logger.log(Level.INFO, "Хотите узнать последний элемент стека?\n1. Да.\n2. Нет ");
            int choiceNext = input.nextInt();
            if (choiceNext == 1)

                //Проверка работоспособности метода peek() класса StackPeek.

                logger.log(Level.INFO, () -> "Последний добавленный элемент в стек - " + stack.peek());

            else if (choiceNext == 2)
                logger.log(Level.INFO, () -> "До свидания!");
            else
                logger.log(Level.INFO, "Такой функции не существует.");

        } else if (choice == 2)
            logger.log(Level.INFO, () -> "Последний добавленный элемент в стек - " + stack.peek());
        else
            logger.log(Level.INFO, "Такой функции не существует.");
    }
}
