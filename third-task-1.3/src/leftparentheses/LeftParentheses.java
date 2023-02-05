package leftparentheses;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeftParentheses {

    private static final Logger logger = Logger.getLogger(LeftParentheses.class.getName());

    public static void main(String[] args) {

        // Создание двух стеков. В стеке numbers будут храниться числовые значения, а в operators математические операторы.
        // В качесте помощника в генерации числового выражения с недостающими левыми скобками будет выступать очередь - generator.

        Deque<Character> numbers = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        Queue<Character> generator = new LinkedList<>();
        Scanner input = new Scanner(System.in);

        logger.log(Level.INFO, "Введите числовое выражение без левых скобок: ");
        String initialExpression = input.nextLine();
        String finalExpression = "";

        // С помощью метода pairsCount идет подсчет количества цифр в строке-выражении и с помощью них можно узнать количество пар чисел.
        // Например, (1+2)*(3-4) это 2 пары. Так как последнюю пару не нужно окутывать лишней левой скобкой, то значение pairsAmount нужно
        // уменьшить на единицу, чтобы на выходе сгенерировать числовое выражение корректно. Причем после прохождения каждой пары это
        // значение нужно уменьшать вплоть до нуля.

        int pairsAmount = pairsCount(initialExpression) - 1;

        // С помощью цикла снова проходимся по строке-выражении и в нем необходимо выполнить основной функционал программы.

        for (int i = 0; i < initialExpression.length(); i++) {

            // Если символ строки является числовым, то этот символ помещается в стек с числами.

            if (Character.isDigit(initialExpression.charAt(i)))
                numbers.push(initialExpression.charAt(i));

            // Если же символ строки является оператором '+', '/', '*' или '-', то идет вызов метода isOperator для удостоверения в этом.

            else if (isOperator(initialExpression.charAt(i)))
                operators.push(initialExpression.charAt(i));

            // Если же символом строки является правая скобка (')'), то уже в этом случае идет взаимодействовие со стеками.

            else if (initialExpression.charAt(i) == ')') {

                // Если стек с операторами и числами не является пустыми, то заходим во внутрь условной конструкции
                // и выполняется присвоение переменным с типом данных char операторам и чисел последнего вошедшего элемента
                // из соответствующего стека (метод pop()). При этом сам элемент удаляется из стека.

                if (areStacksEmpty(operators, numbers)) {
                        char op = operators.pop();
                        char number = numbers.pop();

                        // Если стек с операторами еще не пустой и количество пар не достигло нуля, то выполняется отдельная
                        // функция mulDivide, в которую заложен алгоритм, который заполняет очередь по установленной последовательности.
                        // Данная функция предназначена для тех случаев, когда между парами стоит оператор либо '*', либо '/'.

                        if (isMulDivideMethod(operators, pairsAmount)) {
                            mulDivide(generator, operators, numbers, op, number);
                            pairsAmount--;
                        }

                        // Если стек с операторами пуст и количество пар не достигло нуля, то выполняется отдельная
                        // функция sumSub, в которую заложен алгоритм, который заполняет очередь по установленной последовательности.
                        // Данная функция предназначена для тех случаев, когда между числами стоит оператор '*', '/', '+' или '-', при
                        // условии, что перед этой парой не стоит оператор '*' или '/'.

                        else if (isSumSubMethod(operators, pairsAmount)) {
                            sumSub(generator, numbers, op, number);
                            pairsAmount--;
                        }

                        // Если стек с операторами еще не пустой и количество пар достигло нуля, то выполняется отдельная функция
                        // lastException, в которую заложен алгоритм, который заполняет очередь по установленной последовательности.
                        // Данная функция предназначена для единственного случая, когда осталась последняя пара, перед которой не нужно
                        // ставить лишнюю скобку влево ('(').

                        else if (isLastException(operators, pairsAmount))
                            lastException(generator, operators, numbers, op, number);

                        continue;
                }

                // Когда оба стека стали пустыми, то последним шагом является дописание оставшихся в конце выражения изначальных правых скобок.

                generator.offer(')');
            }
        }

        // После выполнения данного цикла необходимо перебрать все элементы, ранее добавленные в очередь, в цикле foreach и соединить со
        // строкой finalExpression.

        for (Character element : generator)
            finalExpression = finalExpression.concat(Character.toString(element));

        // Результат выполнения программы.

        logger.log(Level.INFO, () -> "Исходное выражение без правых скобок: " + initialExpression);
        logger.log(Level.INFO, "Выражение с правыми скобками: {0}", finalExpression);
    }

    public static boolean isOperator(char initialExpression) {
        return initialExpression == '+' || initialExpression == '-' || initialExpression == '/' || initialExpression == '*';
    }

    public static int pairsCount(String initialExpression) {
        int digits = 0;
        int pairs = 0;

        for (int i = 0; i < initialExpression.length(); i++) {
            if (Character.isDigit(initialExpression.charAt(i))) {
                digits++;
                if (digits % 2 == 0)
                    pairs++;
            }
        }
        return pairs;
    }

    public static boolean areStacksEmpty(Deque<Character> operators, Deque<Character> numbers) {
        return !operators.isEmpty() && !numbers.isEmpty();
    }

    public static boolean isMulDivideMethod(Deque<Character> operators, int pairsAmount) {
        return !operators.isEmpty() && pairsAmount != 0;
    }

    public static boolean isSumSubMethod(Deque<Character> operators, int pairsAmount) {
        return operators.isEmpty() && pairsAmount != 0;
    }

    public static boolean isLastException(Deque<Character> operators, int pairsAmount) {
        return !operators.isEmpty() && pairsAmount == 0;
    }

    public static void mulDivide(Queue<Character> generator, Deque<Character> operators, Deque<Character> numbers, char op, char number) {
        generator.offer(operators.pop());
        generator.offer('(');
        generator.offer('(');
        generator.offer(numbers.pop());
        generator.offer(op);
        generator.offer(number);
        generator.offer(')');
    }

    public static void sumSub(Queue<Character> generator, Deque<Character> numbers, char op, char number) {
        generator.offer('(');
        generator.offer('(');
        generator.offer(numbers.pop());
        generator.offer(op);
        generator.offer(number);
        generator.offer(')');
    }

    public static void lastException(Queue<Character> generator, Deque<Character> operators, Deque<Character> numbers, char op, char number) {
        generator.offer(operators.pop());
        generator.offer('(');
        generator.offer(numbers.pop());
        generator.offer(op);
        generator.offer(number);
        generator.offer(')');
    }
}