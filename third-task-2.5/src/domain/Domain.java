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

        compareTo(dom);
    }

    public static void compareTo(String dom) {

        // Создание массива с доменами, где разделителем на элементы выступает регулярное выражение, способное разделять строку не только по пробелам.

        String[] domArr = dom.split("[^.[a-zA-Z]]\\s+|_|\\s|\\.\\s+|\\.$|[^.[a-zA-Z]]+$");
        logger.log(Level.INFO, "Cписок доменов из стандартного ввода: {0}", Arrays.toString(domArr));

        // Создание массива, куда будут записываться домены с обратным именем.

        String[] domArrReversed = new String[domArr.length];
        int i = 0;

        // Перебор каждого домена из dom_arr и разбиение его по точкам, и соответственно запись его элементов во временный массив.
        // После чего идет сортировка первого и последнего элемента пузырьковым методом, и запись этого обратного домена через точку с помощью
        // String.join() в массив доменов с обратным именем dom_arr_reversed.

        for (String domain : domArr) {
            String[] domArrDomainTemp = domain.split("\\.");

            String temp = domArrDomainTemp[0];
            domArrDomainTemp[0] = domArrDomainTemp[domArrDomainTemp.length - 1];
            domArrDomainTemp[domArrDomainTemp.length - 1] = temp;

            domArrReversed[i] = String.join(".", domArrDomainTemp);
            i++;
        }

        // Результат выполнения программы.

        logger.log(Level.INFO, "Упорядоченный список обратных доменов: {0}", Arrays.toString(domArrReversed));
    }
}
