package josephus;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Josephus {

    private static final Logger logger = Logger.getLogger(Josephus.class.getName());

    public static void main(String[] args) {

        // Создание связного списка positions на основе класса List и очереди killed на основе класса Queue.

        List<Integer> positions = new LinkedList<>();
        Queue<Integer> killed = new LinkedList<>();

        // Создание системы ввода с клавиатуры, где необходимо ввести количество человек и через какое число убивать каждого человека.

        Scanner input = new Scanner(System.in);

        logger.log(Level.INFO, "Введите количество человек: ");
        int humans = input.nextInt();

        logger.log(Level.INFO, "Убивать через каждого: ");
        int k = input.nextInt();

        String dead = "";

        // Добавляем в список позиции от 0 до humans - 1.

        for (int i = 0; i < humans - 1; i++)
            positions.add(i);

        // Формула, позволяющая определить согласно переменной k какого человека нужно убить и вычеркнуть из списка.
        // Все неудачные позиции, добавляются в очередь killed в правильном порядке.

        int pos = 0;
        while (positions.size() != 1) {
            pos = (pos + k - 1) % positions.size();
            killed.offer(positions.get(pos));
            positions.remove(pos);
        }

        // Пока очередь не будет пуста, в переменную dead записываются неудачные позиции.

        while (!killed.isEmpty()){
            if (killed.size() == 1)
                dead = dead.concat(Integer.toString(killed.remove())) + ". ";
            else
                dead = dead.concat(Integer.toString(killed.remove())) + ", ";
        }

        // Вывод всех неудачных позиций и той позиции, в которой находится выживший.

        logger.log(Level.INFO, "Умерли под номерами: {0}", dead);
        logger.log(Level.INFO, "Выжил под номером: {0}", positions.get(0));
    }
}
