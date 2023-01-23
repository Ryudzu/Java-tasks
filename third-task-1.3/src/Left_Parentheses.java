import java.util.*;

public class Left_Parentheses {

    public static void main(String[] args) {

        // Создаем два стека. В стеке numbers будут храниться числовые значения, а в operators математические операторы.
        // В качесте помощника в генерации числового выражения с недостающими левыми скобками будет выступать очередь - generator.

        Stack<Character> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        Queue<Character> generator = new LinkedList<>();

        String initial_expression = "1*2)*3-4)*5*6)+7-8))))";
        String final_expression = "";
        int digits = 0;
        int pairs = 0;

        // С помощью цикла подсчитываем количество цифр в строке-выражении и с помощью них можно узнать количество пар чисел
        // Например, (1+2)*(3-4) это 2 пары.

        for (int i = 0; i < initial_expression.length(); i++) {
            if (Character.isDigit(initial_expression.charAt(i))) {
                digits++;
                if (digits % 2 == 0)
                    pairs++;
            }
        }

        // Так как последнюю пару не нужно окутывать лишней левой скобкой, то значение pairs нужно уменьшить на единицу,
        // чтобы на выходе сгенерировать числовое выражение корректно. Причем после прохождения каждой пары это значение
        // нужно уменьшать вплоть до нуля.

        --pairs;

        // С помощью цикла снова проходимся по строке-выражении и в нем необходимо выполнить основной функционал программы.

        for (int i = 0; i < initial_expression.length(); i++) {

            // Если символ строки является числовым, то помещаем этот символ в стек с числами.

            if (Character.isDigit(initial_expression.charAt(i)))
                numbers.push(initial_expression.charAt(i));

            // Если же символ строки является оператором '+', '-', '*' или '-', то помещаем этот символ в стек с символами.

            else if (initial_expression.charAt(i) == '+' || initial_expression.charAt(i) == '-' || initial_expression.charAt(i) == '*' || initial_expression.charAt(i) == '/')
                operators.push(initial_expression.charAt(i));

            // Если же символом строки является правая скобка (')'), то уже в этом случае идет взаимодействовие со стеками.

            else if (initial_expression.charAt(i) == ')') {

                // Если стек с операторами и числами не является пустыми, то заходим во внутрь условной конструкции
                // и выполняется присвоение переменным с типом данных char операторам и чисел последнего вошедшего элемента
                // из соответствующего стека (метод pop()). При этом сам элемент удаляется из стека.

                if (!operators.isEmpty() && !numbers.isEmpty()) {
                        char op = operators.pop();
                        char number = numbers.pop();

                        // Если стек с операторами еще не пустой и количество пар не достигло нуля, то выполняется отдельная
                        // функция mul_divide, в которую заложен алгоритм, который заполняет очередь по установленной последовательности.
                        // Данная функция предназначена для тех случаев, когда между парами стоит оператор либо '*', либо '/'.

                        if (!operators.isEmpty() && pairs != 0) {
                            mul_divide(generator, operators, numbers, op, number);
                            pairs--;
                        }

                        // Если стек с операторами пуст и количество пар не достигло нуля, то выполняется отдельная
                        // функция sum_sub, в которую заложен алгоритм, который заполняет очередь по установленной последовательности.
                        // Данная функция предназначена для тех случаев, когда между числами стоит оператор '*', '/', '+' или '-', при
                        // условии, что перед этой парой не стоит оператор '*' или '/'.

                        else if (operators.isEmpty() && pairs != 0) {
                            sum_sub(generator, numbers, op, number);
                            pairs--;
                        }

                        // Если стек с операторами еще не пустой и количество пар достигло нуля, то выполняется отдельная функция
                        // last_exception, в которую заложен алгоритм, который заполняет очередь по установленной последовательности.
                        // Данная функция предназначена для единственного случая, когда осталась последняя пара, перед которой не нужно
                        // ставить лишнюю скобку влево ('(').

                        else if (!operators.isEmpty() && pairs == 0)
                            last_exception(generator, operators, numbers, op, number);


                // Когда оба стека стали пустыми, то последним шагом является дописание оставшихся в конце выражения изначальных
                // правых скобок.

                } else
                    generator.offer(')');
            }
        }

        // После выполнения данного цикла необходимо перебрать все элементы, ранее добавленные в очередь, в цикле
        // foreach и соединить со строкой final_expression.

        for (Character element : generator)
            final_expression = final_expression.concat(Character.toString(element));

        // Результат выполнения программы.

        System.out.println("Исходное выражение без правых скобок: " + initial_expression);
        System.out.println("Выражение с правыми скобками: " + final_expression);
    }

    public static void mul_divide (Queue<Character> generator, Stack<Character> operators, Stack<Character> numbers, char op, char number) {
        generator.offer(operators.pop());
        generator.offer('(');
        generator.offer('(');
        generator.offer(numbers.pop());
        generator.offer(op);
        generator.offer(number);
        generator.offer(')');
    }

    public static void sum_sub (Queue<Character> generator, Stack<Character> numbers, char op, char number) {
        generator.offer('(');
        generator.offer('(');
        generator.offer(numbers.pop());
        generator.offer(op);
        generator.offer(number);
        generator.offer(')');
    }

    public static void last_exception (Queue<Character> generator, Stack<Character> operators, Stack<Character> numbers, char op, char number) {
        generator.offer(operators.pop());
        generator.offer('(');
        generator.offer(numbers.pop());
        generator.offer(op);
        generator.offer(number);
        generator.offer(')');
    }
}