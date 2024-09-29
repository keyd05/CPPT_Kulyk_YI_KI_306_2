package KI.Kulyk.Lab6;

/**
 * Клас Driver містить точку входу в програму і демонструє роботу словника MyDictionary.
 */
public class Driver {

    /**
     * Метод main є точкою входу в програму.
     *
     * @param args аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        // Створюємо новий екземпляр словника з ключем типу Integer та значенням типу String
        MyDictionary<Integer, String> dict = new MyDictionary<>();

        // Додаємо кілька пар ключ-значення до словника
        dict.add(24, "3");
        dict.add(22, "2");
        dict.add(26, "1AAA");

        // Виводимо максимальне значення, що зберігається у словнику
        System.out.println(dict.get(26));
        System.out.println(dict.getMax());
    }
}
