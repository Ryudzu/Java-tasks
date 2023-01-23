import java.util.Arrays;

public class Version {

    private String[] version_arr;

    public Version (String version) {
        SetVersion(version);
        System.out.println(GetVersion());
    }

    public void SetVersion (String version) {
        this.version_arr = version.split("([^.[0-9]]\\s+)|_|\\s|([^.[0-9]]+$)");
    }

    public String GetVersion () {
        return "Список версий ПО: " + Arrays.toString(version_arr);
    }

    // Метод класса Version, в который передается объект интерфейса Comparable, с помощью этого объекта можно обратится к абстрактному методу
    // difference и передать в него две строки (версии), которые после чего сравниваются уже в lambda выражении.

    public void ver_difference(Comparable v) {
        v.difference("115.1.1", "115.10.1");
    }

    public static void main(String[] args) {

        // Создаем объект на основе класса Version и передаем в его конструктор строку из набора версий согласно заданию.
        // В самом конструкторе будут вызываться сеттер и геттер.

        Version vers = new Version("115.1.1 115.10.1 115.10.2");

        // Для удобства вместо анонимного класса было использовано lambda выражение, поскольку интерфейс Comparable обладает лишь одним абстрактным методом

        vers.ver_difference((String fv, String sv) -> {
            String[] fv_arr = fv.split("\\.");
            String[] sv_arr = sv.split("\\.");

            for (int i = 0; i < 3; i++) {
                if (Integer.parseInt(sv_arr[i]) > Integer.parseInt(fv_arr[i])) {
                    System.out.println("Версия " + String.join(".", sv_arr) + " больше, чем версия " + String.join(".", fv_arr));
                    break;
                } else if (Integer.parseInt(sv_arr[i]) < Integer.parseInt(fv_arr[i])) {
                    System.out.println("Версия " + String.join(".", fv_arr) + " больше, чем версия " + String.join(".", sv_arr));
                    break;
                } else if (i == 2)
                    System.out.println("Версии одинаковы");
            }
        });
    }
}

// Создание интерфейса, обладающий единственным абстрактным методом, который будет опеределять какая версия является больше (или меньше, или равны)

interface Comparable {
    void difference(String fv, String sv);
}
