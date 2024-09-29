package KI.Kulyk.Lab6;

import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * Клас MyDictionary реалізує параметризований словник на основі хеш-таблиці.
 *
 * @param <K> Тип ключа.
 * @param <V> Тип значення, яке повинно бути порівнюваним (implements Comparable).
 */
public class MyDictionary<K, V extends Comparable<V>> {

    private final int tableSize; // Розмір хеш-таблиці
    private int size; // Кількість елементів у словнику
    private final LinkedList<Pair<K, V>>[] table; // Масив списків для зберігання пар ключ-значення

    /**
     * Внутрішній клас для представлення пари ключ-значення.
     */
    private class Pair<K, V> {
        public K key;   // Ключ пари
        public V value; // Значення пари

        /**
         * Конструктор для ініціалізації пари.
         *
         * @param key   Ключ.
         * @param value Значення.
         */
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Конструктор за замовчуванням. Ініціалізує хеш-таблицю з розміром 16.
     */
    public MyDictionary() {
        tableSize = 16;
        table = new LinkedList[tableSize];

        // Ініціалізація списків для кожної ячейки таблиці
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * Конструктор, що дозволяє задати розмір хеш-таблиці.
     *
     * @param _size Розмір хеш-таблиці.
     */
    public MyDictionary(int _size) {
        tableSize = _size;
        table = new LinkedList[tableSize];

        // Ініціалізація списків для кожної ячейки таблиці
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    /**
     * Обчислює хеш-код для ключа та повертає індекс в хеш-таблиці.
     *
     * @param key Ключ для хешування.
     * @return Індекс в хеш-таблиці.
     */
    private int hash(K key) {
        return Math.abs(key.hashCode() % tableSize);
    }

    /**
     * Додає нову пару ключ-значення в словник. Якщо ключ вже існує, то його значення оновлюється.
     *
     * @param key   Ключ.
     * @param value Значення.
     */
    public void add(K key, V value) {
        int index = hash(key); // Обчислення індексу за хешем
        for (Pair<K, V> pair : table[index]) {
            if (pair.key.equals(key)) { // Якщо ключ вже існує, оновлюємо значення
                pair.value = value;
                return;
            }
        }

        table[index].add(new Pair<K, V>(key, value)); // Додаємо нову пару ключ-значення
        size++; // Збільшуємо розмір словника
    }

    /**
     * Повертає значення для відповідного ключа. Якщо ключ не знайдено, генерується виняток NoSuchElementException.
     *
     * @param key Ключ для пошуку.
     * @return Значення, яке відповідає ключу.
     * @throws NoSuchElementException якщо ключ не знайдено.
     */
    public V get(K key) {
        int index = hash(key); // Обчислення індексу за хешем

        for (Pair<K, V> pair : table[index]) {
            if (pair.key.equals(key)) { // Якщо ключ знайдено, повертаємо значення
                return pair.value;
            }
        }

        throw new NoSuchElementException(); // Якщо ключ не знайдено, генеруємо виняток
    }

    /**
     * Видаляє пару ключ-значення зі словника. Якщо ключ не знайдено, видалення не відбувається.
     *
     * @param key Ключ, який потрібно видалити.
     */
    public void remove(K key) {
        int index = hash(key); // Обчислення індексу за хешем

        for (Pair<K, V> pair : table[index]) {
            if (pair.key.equals(key)) { // Якщо ключ знайдено, видаляємо пару
                table[index].remove(pair);
                size--; // Зменшуємо розмір словника
                return;
            }
        }
    }

    /**
     * Знаходить максимальне значення серед усіх пар у словнику.
     *
     * @return Максимальне значення.
     * @throws NoSuchElementException якщо словник порожній.
     */
    public V getMax() {
        if (size == 0) {
            throw new NoSuchElementException("Словник порожній");
        }

        V max = null; // Початково максимальне значення не визначене
        for (int i = 0; i < tableSize; i++) {
            for (Pair<K, V> pair : table[i]) {
                if (max == null || pair.value.compareTo(max) > 0) { // Знаходимо максимальне значення
                    max = pair.value;
                }
            }
        }

        return max;
    }

}
