import java.util.Arrays;
import java.util.Scanner;

public class Domain {

    public static void main(String[] args) {

        // Создание системы ввода с клавиатуры и вызов созданной функции compareTo согласно заданию.

        Scanner input = new Scanner(System.in);

        System.out.print("Введите список доменов: ");
        String dom = input.nextLine();

        compareTo(dom);
    }

    public static void compareTo(String dom) {

        // Создание массива с доменами, где разделителем на элементы выступает регулярное выражение, способное разделять строку не только по пробелам.

        String[] dom_arr = dom.split("[^.[a-zA-Z]]\\s+|_|\\s|\\.\\s+|\\.$|[^.[a-zA-Z]]+$");
        System.out.println("Cписок доменов из стандартного ввода: " + Arrays.toString(dom_arr));

        // Создание массива, куда будут записываться домены с обратным именем.

        String[] dom_arr_reversed = new String[dom_arr.length];
        int i = 0;

        // Перебор каждого домена из dom_arr и разбиение его по точкам, и соответственно запись его элементов во временный массив.
        // После чего идет сортировка первого и последнего элемента пузырьковым методом, и запись этого обратного домена через точку с помощью
        // String.join() в массив доменов с обратным именем dom_arr_reversed.

        for (String domain : dom_arr) {
            String[] dom_arr_domain_temp = domain.split("\\.");

            String temp = dom_arr_domain_temp[0];
            dom_arr_domain_temp[0] = dom_arr_domain_temp[dom_arr_domain_temp.length - 1];
            dom_arr_domain_temp[dom_arr_domain_temp.length - 1] = temp;

            dom_arr_reversed[i] = String.join(".", dom_arr_domain_temp);
            i++;
        }

        // Результат выполнения программы.

        System.out.println("Упорядоченный список обратных доменов: " + Arrays.toString(dom_arr_reversed));
    }
}
