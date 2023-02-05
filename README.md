# Java-tasks
### Первая задача из раздела 1.3 ###

1) Задача 1.3.4: Напишите клиент стека Parentheses, который читает поток символов из стандартного ввода и использует стек для определения правильности балансировки
скобок. Например, программа должна вывести true для  [()]{}{[()()]()} и false для [(]).
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/first-task-1.3/src/parentheses
3) Время выполнения "план-факт": план - 1 час; факт - 23 минуты.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afirst-task-1.3%2Fsrc%2FParentheses.java

### Вторая задача из раздела 1.3 ###

1) Задача 1.3.7: Добавьте в класс Stack метод peek(), который возвращает элемент, занесенный в стек последним (без выталкивания).
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/second-task-1.3/src/stackpeek
3) Время выполнения "план-факт": план - 30 минут; факт - 15 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Asecond-task-1.3%2Fsrc%2FStack_peek.java

### Третья задача из раздела 1.3 ###

1) Задача 1.3.9: Напишите программу, которая принимает из стандартного ввода выражение без левых скобок и выводит эквивалентное инфиксное выражение со вставленными
недостающими скобками. Например, для входных данных 1+2)\*3-4)\*5-6))) программа должна вывести ((1+2)\*((3-4)\*(5-6))).
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/third-task-1.3/src/leftparentheses
3) Время выполнения "план-факт": план - 5 часов; факт - 3 часа и 45 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Athird-task-1.3%2Fsrc%2FLeft_Parentheses.java

### Четвертая задача из раздела 1.3 ###

1) Задача 1.3.37: Задача Иосифа. Эта задача известна из глубокой древности. N человекам нужно было выбрать одного и для этого они встали в круг (позиции с номерами
от 0 до N-1) и считали по кругу, удаляя каждого M-человека, пока не остался один. Легенда гласит, что Иосиф Флавий вычислил то место, которое остается последним.
Напишите клиент Josephus для класса Queue, который принимает из командной строки числа N и M и выводит порядок, в котором выбывают люди.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/fourth-task-1.3/src/josephus
3) Время выполнения "план-факт": план - 2 часа; факт - 1 час и 20 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afourth-task-1.3%2Fsrc%2FJosephus.java

____

### Первая задача из раздела 2.5 ###

1) Задача 2.5.2: Напишите программу, которая принимает из стандартного ввода список слов и выводит все составные слова, состоящие из двух слов. Например, если в списке
имеются слова "пар", "ковка" и "парковка", то "парковка" - составное слово.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/first-task-2.5/src/compound
3) Время выполнения "план-факт": план - 1 час; факт - 1 час и 15 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afirst-task-2.5%2Fsrc%2FCompound.java

### Вторая задача из раздела 2.5 ###

1) Задача 2.5.4: Реализуйте метод String[] dedup (String[] a), который возвращает объекты из a[] в упорядоченном виде, без повторяющихся элементов.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/second-task-2.5/src/dedupmethod
3) Время выполнения "план-факт": план - 40 минут; факт - 30 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Asecond-task-2.5%2Fsrc%2FDedup_Method.java

### Третья задача из раздела 2.5 ###

1) Задача 2.5.14: Сортировка доменных имен. Напишите тип данных Domain, представляющий доменные имена и содержащий метод compareTo(), который реализует естественный
для доменных имен порядок обратных имен. Например, для домена cs.princeton.edu обратным именем будет edu.princeton.cs. Напишите клиент, который читает имена доменов
из стандартного ввода и выводит упорядоченный список обратных доменных имен.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/third-task-2.5/src/domain
3) Время выполнения "план-факт": план - 2 часа; факт - 1 час и 45 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Athird-task-2.5%2Fsrc%2FDomain.java

### Четвертая задача из раздела 2.5 ###

1) Задача 2.5.10: Создайте тип данных Version, который представляет номер версии ПО, вроде 115.1.1, 115.10.1, 115.10.2. Реализуйте для него интерфейс Comparable, так,
чтобы версия 115.1.1 была меньше, чем 115.10.1.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/fourth-task-2.5/src/version
3) Время выполнения "план-факт": план - 30 минут; факт - 15 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afourth-task-2.5%2Fsrc%2FVersion.java

____

### Первая задача из раздела 3.2 ###

1) Задача 3.2.6: Добавьте в класс BST метод height() для вычисления высоты дерева. Разработайте две реализации: рекурсивный метод и метод наподобие size(), для работы
которого нужно дополнительное поле в каждом узле дерева (требующего линейного объема памяти и константного времени на запрос).
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/first-task-3.2/src/heightmethods
3) Время выполнения "план-факт": план - 4 часа; факт - 4 часа и 20 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afirst-task-3.2%2Fsrc%2Fheightmethods%2FHeightMethods.java

### Вторая задача из раздела 3.2 ###

1) Задача 3.2.32: Сертификация. Напишите метод isBST(), который принимает в качестве аргумента узел Node и возвращает true, если указанный узел является корнем дерева бинарного поиска, и false в противном случае.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/second-task-3.2/src/certification
3) Время выполнения "план-факт": план - 5 часов; факт - 3 часа и 50 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Asecond-task-3.2%2Fsrc%2Fcertification%2FCertification.java

### Третья задача из раздела 3.2 ###

1) Задача 3.2.25: Идеальная балансировка. Напишите программу, которая вставляет набор ключей в первоначальное пустое ДБП так, что полученное дерево эквивалентно бинарному поиску - т.е. последовательность сравнений, выполняемых при поиске любого ключа в ДБП, совпадает с последовательностью сравнений, выполняемых при бинарном
поиске в том же наборе ключей.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/third-task-3.2/src/perfectbalance
3) Время выполнения "план-факт": план - 3 часа; факт - 2 часа и 5 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Athird-task-3.2%2Fsrc%2Fperfectbalance%2FPerfectBalance.java

### Четвертая задача из раздела 3.2 ###

1) Задача 3.2.13: Приведите нерекурсивные реализации методов get() и put() для класса BST.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/fourth-task-3.2/src/nonrecursivemethods
3) Время выполнения "план-факт": план - 1 час; факт - 40 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afourth-task-3.2%2Fsrc%2Fnonrecursivemethods%2FNonRecursive.java

____

### Задачи из раздела 3.3 временно отсутствуют! ###

____

### Первая задача из раздела 3.4 ###

1) Задача 3.4.1: Вставьте ключи E A S Y Q U T I O N в указанном порядке в первоначально пустую таблицу с M = 5 списками раздельных цепочек. Для преобразования k-й буквы алфавита в индекс таблицы используйте хеш-функцию (11*k)%M.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/first-task-3.4/src/chainingmethod
3) Время выполнения "план-факт": план - 2 часа; факт - 1 час и 55 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afirst-task-3.4%2Fsrc%2Fchainingmethod%2FChainingMethod.java

### Вторая задача из раздела 3.4 ###

1) Задача 3.4.9: Реализуйте энергичный метод delete() для класса SeparateChainingHashST.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/second-task-3.4/src/deletemethod
3) Время выполнения "план-факт": план - 1 час; факт - 50 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Asecond-task-3.4%2Fsrc%2Fdeletemethod%2FSeparateChainingHashST.java

### Третья задача из раздела 3.4 ###

1) Задача 3.4.10: Вставьте ключи E A S Y Q U T I O N в указанном порядке в первоначально пустую таблицу с M = 5 с линейным опробованием. Для преобразования k-й буквы алфавита в индекс таблицы используйте хеш-функцию (11*k)%M. Выполните упражнение еще раз для M = 10.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/third-task-3.4/src/linearprobing
3) Время выполнения "план-факт": план - 2 часа; факт - 2 часа и 10 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Athird-task-3.4%2Fsrc%2Flinearprobing%2FLinearProbing.java

### Четвертая задача из раздела 3.4 ###

1) Задача 3.4.26: Ленивое удаление для линейного опробования. Добавьте в класс LinearProbingHashST метод delete(), удаляющий пару ключ-значение с помощью занесения значения null (но без удаления ключа). Такая пара удаляется из таблицы при изменении ее размера методом resize(). Главная проблема - решить, когда вызвать resize().
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/fourth-task-3.4/src/deletemethod
3) Время выполнения "план-факт": план - 1 час и 30 минут; факт - 1 час.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afourth-task-3.4%2Fsrc%2Fdeletemethod%2FLinearProbingHashST.java

____

### Первая задача из раздела 5.1 ###

1) Задача 5.1.2: Приведите трассировку работы LSD-сортировки для строковых ключей no is th ti fo al go pe to co to th ai of th pa.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/first-task-5.1/src/lsdsorting
3) Время выполнения "план-факт": план - 3 часа; факт - 2 часа и 30 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afirst-task-5.1%2Fsrc%2Flsdsorting%2FLSDsorting.java

### Вторая задача из раздела 5.1 ###

1) Задача 5.1.3: Приведите трассировку работы MSD-сортировки для строковых ключей no is th ti fo al go pe to co to th ai of th pa.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/second-task-5.1/src/msdsorting
3) Время выполнения "план-факт": план - 3 часа; факт - 4 часа и 20 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Asecond-task-5.1%2Fsrc%2Fmsdsorting%2FMSDsorting.java

### Третья задача из раздела 5.1 ###

1) Задача 5.1.19: Случайные автомобильные номера. Напишите статический метод randomPlatesCA, который принимает в качестве аргумента целое значение N и возвращает массив из N значений типа String, которые представляют собой автомобильные номера вроде приведенных в примерах данного раздела (калифорнийские номера).
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/third-task-5.1/src/randomlicenseplates
3) Время выполнения "план-факт": план - 1 час и 30 минут; факт - 1 час.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Athird-task-5.1%2Fsrc%2Frandomlicenseplates%2FRandomLicensePlates.java
