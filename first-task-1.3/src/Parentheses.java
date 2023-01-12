import java.util.*;

public class Parentheses {

    public static void main(String[] args) {
        // Создаем пустой стек и систему ввода с клавиатуры
        Stack<Character> stack = new Stack<>();
        Scanner input = new Scanner(System.in);

        System.out.print("Введите строку из скобок: ");
        String parentheses = input.nextLine();

        // Запускаем цикл для прохода по всем элементам строки
        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(' || parentheses.charAt(i) == '[' || parentheses.charAt(i) == '{') {
                // Если скобка "смотрит" вправо, то добавляем ее в стэк
                stack.push(parentheses.charAt(i));
            }
            else if (parentheses.charAt(i) == ')' || parentheses.charAt(i) == ']' || parentheses.charAt(i) == '}') {
                try {
                    // Если скобка "смотрит" влево, то удаляем существующую в стеке скобку, которая смотрит "вправо" из самого стека
                    stack.pop();
                } catch (java.util.EmptyStackException e) {
                    // Если скобка, которая "смотрит" влево стоит в начале строки, то программа завершается с выводом False
                    System.out.println("False");
                    System.exit(0);
                }
            }
        }
        // Если стек по итогу пустой, значит скобки сбалансированны верно и результат True, иначе False
        if (stack.isEmpty())
            System.out.println("True");
        else
            System.out.println("False");
    }
}
