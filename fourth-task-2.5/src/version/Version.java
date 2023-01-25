package version;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Version {

    private static final Logger logger = Logger.getLogger(Version.class.getName());

    private String[] version_arr;

    public Version (String version) {
        setVersion(version);

        logger.log(Level.INFO, () -> getVersion());
    }

    public void setVersion (String version) {
        this.version_arr = version.split("([^.\\d]\\s+)|(_)|(\\s)|([^.\\d]+$)");
    }

    public String getVersion () {
        return "Список версий ПО: " + Arrays.toString(version_arr);
    }

    // Метод класса version.Version, в который передается объект интерфейса Comparable, с помощью этого объекта можно обратится к абстрактному методу
    // difference и передать в него две строки (версии), которые после чего сравниваются уже в lambda выражении.

    public void verDifference(Comparable v) {
        v.difference("115.1.1", "115.10.1");
    }

    public static void main(String[] args) {

        // Создаем объект на основе класса Version и передаем в его конструктор строку из набора версий согласно заданию.
        // В самом конструкторе будут вызываться сеттер и геттер.

        Version vers = new Version("115.1.1 115.10.1 115.10.2");

        // Для удобства вместо анонимного класса было использовано lambda выражение, поскольку интерфейс Comparable обладает лишь одним абстрактным методом

        vers.verDifference((String fv, String sv) -> {
            String[] fvArr = fv.split("\\.");
            String[] svArr = sv.split("\\.");

            for (int i = 0; i < 3; i++) {
                if (Integer.parseInt(svArr[i]) > Integer.parseInt(fvArr[i])) {
                    logger.log(Level.INFO, () -> "Версия " + String.join(".", svArr) + " больше, чем версия " + String.join(".", fvArr));
                    break;
                }

                if (Integer.parseInt(svArr[i]) < Integer.parseInt(fvArr[i])) {
                    logger.log(Level.INFO, () -> "Версия " + String.join(".", fvArr) + " больше, чем версия " + String.join(".", svArr));
                    break;
                }

                if (i == 2)
                    logger.log(Level.INFO, () -> "Версии одинаковы.");
            }
        });
    }
}

// Создание интерфейса, обладающий единственным абстрактным методом, который будет опеределять какая версия является больше (или меньше, или равны)

interface Comparable {
    void difference(String fv, String sv);
}
