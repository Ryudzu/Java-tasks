package domain;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Domain {

    private static final Logger logger = Logger.getLogger(Domain.class.getName());
    public static void main(String[] args) {

        // Создание системы ввода с клавиатуры и вызов созданной функции compareTo согласно заданию.

        Scanner input = new Scanner(System.in);

        logger.log(Level.INFO, () -> "Введите список доменов: ");
        String dom = input.nextLine();

        // Результат выполнения программы.

        compareTo(dom);
    }

    public static void compareTo(String dom) {

        // Создание массива с доменами, где разделителем на элементы выступает регулярное выражение, способное разделять строку не только по пробелам.

        String[] domArr = dom.split("([^.[a-zA-Z]]\\s+)|(_)|(\\s)|(\\.\\s+)|(\\.$|[^.[a-zA-Z]]+$)");
        logger.log(Level.INFO, "Cписок доменов из стандартного ввода: {0}", Arrays.toString(domArr));

        // Создание массива, куда будут записываться домены с обратным именем.

        String[] domArrReversed = new String[domArr.length];

        // Перебор каждого домена из domArr и разбиение его по точкам, и соответственно запись его элементов во временный массив.
        // После чего идет сортировка первого и последнего элемента пузырьковым способом, который прописан в методе swap(), и запись
        // этого обратного домена через точку с помощью String.join() в массив доменов с обратным именем domArrReversed.

        int i = 0;
        for (String domain : domArr) {
            String[] domArrDomainTemp = domain.split("\\.");

            int left = 0;
            int right = domArrDomainTemp.length - 1;

            swap(domArrDomainTemp, left, right);

            domArrReversed[i] = String.join(".", domArrDomainTemp);
            i++;
        }

        logger.log(Level.INFO, "Упорядоченный список обратных доменов: {0}", Arrays.toString(domArrReversed));
    }

    public static void swap(String[] domArrDomainTemp, int left, int right) {
        while (left <= right) {
            String temp = domArrDomainTemp[left];
            domArrDomainTemp[left] = domArrDomainTemp[right];
            domArrDomainTemp[right] = temp;
            left++;
            right--;
        }
    }
}
