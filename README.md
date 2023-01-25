# Java-tasks
### Первая задача из раздела 1.3 ###

1) Задача 1.3.4: Напишите клиент стека Parentheses, который читает поток символов из стандартного ввода и использует стек для определения правильности балансировки
скобок. Например, программа должна вывести true для  [()]{}{[()()]()} и false для [(]).
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/first-task-1.3/src
3) Время выполнения "план-факт": план - 1 час; факт - 23 минуты.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afirst-task-1.3%2Fsrc%2FParentheses.java

### Вторая задача из раздела 1.3 ###

1) Задача 1.3.7: Добавьте в класс Stack метод peek(), который возвращает элемент, занесенный в стек последним (без выталкивания).
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/second-task-1.3/src
3) Время выполнения "план-факт": план - 30 минут; факт - 15 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Asecond-task-1.3%2Fsrc%2FStack_peek.java

### Третья задача из раздела 1.3 ###

1) Задача 1.3.9: Напишите программу, которая принимает из стандартного ввода выражение без левых скобок и выводит эквивалентное инфиксное выражение со вставленными
недостающими скобками. Например, для входных данных 1+2)\*3-4)\*5-6))) программа должна вывести ((1+2)\*((3-4)\*(5-6))).
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/third-task-1.3/src
3) Время выполнения "план-факт": план - 5 часов; факт - 3 часа и 45 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Athird-task-1.3%2Fsrc%2FLeft_Parentheses.java

### Четвертая задача из раздела 1.3 ###

1) Задача 1.3.37: Задача Иосифа. Эта задача известна из глубокой древности. N человекам нужно было выбрать одного и для этого они встали в круг (позиции с номерами
от 0 до N-1) и считали по кругу, удаляя каждого M-человека, пока не остался один. Легенда гласит, что Иосиф Флавий вычислил то место, которое остается последним.
Напишите клиент Josephus для класса Queue, который принимает из командной строки числа N и M и выводит порядок, в котором выбывают люди.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/fourth-task-1.3/src
3) Время выполнения "план-факт": план - 2 часа; факт - 1 час и 20 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afourth-task-1.3%2Fsrc%2FJosephus.java

____

### Первая задача из раздела 2.5 ###

1) Задача 2.5.2: Напишите программу, которая принимает из стандартного ввода список слов и выводит все составные слова, состоящие из двух слов. Например, если в списке
имеются слова "пар", "ковка" и "парковка", то "парковка" - составное слово.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/first-task-2.5/src
3) Время выполнения "план-факт": план - 1 час; факт - 1 час и 15 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afirst-task-2.5%2Fsrc%2FCompound.java

### Вторая задача из раздела 2.5 ###

1) Задача 2.5.4: Реализуйте метод String[] dedup (String[] a), который возвращает объекты из a[] в упорядоченном виде, без повторяющихся элементов.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/second-task-2.5/src
3) Время выполнения "план-факт": план - 40 минут; факт - 30 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Asecond-task-2.5%2Fsrc%2FDedup_Method.java

### Третья задача из раздела 2.5 ###

1) Задача 2.5.14: Сортировка доменных имен. Напишите тип данных Domain, представляющий доменные имена и содержащий метод compareTo(), который реализует естественный
для доменных имен порядок обратных имен. Например, для домена cs.princeton.edu обратным именем будет edu.princeton.cs. Напишите клиент, который читает имена доменов
из стандартного ввода и выводит упорядоченный список обратных доменных имен.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/third-task-2.5/src
3) Время выполнения "план-факт": план - 2 часа; факт - 1 час и 45 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Athird-task-2.5%2Fsrc%2FDomain.java

### Четвертая задача из раздела 2.5 ###

1) Задача 2.5.10: Создайте тип данных Version, который представляет номер версии ПО, вроде 115.1.1, 115.10.1, 115.10.2. Реализуйте для него интерфейс Comparable, так,
чтобы версия 115.1.1 была меньше, чем 115.10.1.
2) Ссылка на директорию с заданием: https://github.com/Ryudzu/Java-tasks/tree/main/fourth-task-2.5/src
3) Время выполнения "план-факт": план - 30 минут; факт - 15 минут.
4) Ссылка на sonarcloud: https://sonarcloud.io/code?id=Ryudzu_Java-tasks&selected=Ryudzu_Java-tasks%3Afourth-task-2.5%2Fsrc%2FVersion.java

____
