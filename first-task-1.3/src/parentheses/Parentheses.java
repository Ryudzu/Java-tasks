package parentheses;

import java.util.*;
import java.util.logging.Logger;

public class Parentheses {

    private static final Logger logger = Logger.getLogger(Parentheses.class.getName());
    public static void main(String[] args) {

        // Создание пустого стека и системы ввода с клавиатуры.

        Deque<Character> stack = new ArrayDeque<>();
        Scanner input = new Scanner(System.in);

        // Создание словаря для проверки противоположности скобок по паттерну, пример: [(]) - false; [()] - true.

        Map<Character, Character> opposites = new HashMap<>();
        opposites.put(')', '(');
        opposites.put(']', '[');
        opposites.put('}', '{');

        logger.info("Введите строку из скобок: ");
        String parentheses = input.nextLine();

        // Запуск цикла для прохода по всем элементам строки.

        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(' || parentheses.charAt(i) == '[' || parentheses.charAt(i) == '{') {

                // Если скобка "смотрит" вправо, то идет добавление ее в стэк.

                stack.push(parentheses.charAt(i));
            }
            else if (parentheses.charAt(i) == ')' || parentheses.charAt(i) == ']' || parentheses.charAt(i) == '}') {
                try {

                    // Если последняя скобка, добавленная в стек противоположна по паттерну, то идет удаление ее из стека, иначе результат False.

                    if (stack.peek().equals(opposites.get(parentheses.charAt(i))))
                        stack.pop();

                } catch (Exception e) {

                    // Если скобка, которая "смотрит" влево стоит в начале строки, то программа завершается с выводом False.

                    logger.info("False");
                    System.exit(0);
                }
            }
        }

        // Если стек по итогу пустой, значит скобки сбалансированны верно и результат True, иначе False.

        if (stack.isEmpty())
            logger.info("True");
        else
            logger.info("False");
    }
}
