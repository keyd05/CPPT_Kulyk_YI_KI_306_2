package KI.Kulyk.Lab6;

import java.util.NoSuchElementException;
import java.util.LinkedList;

class MyDictionary<K, V extends Comparable<V>> {

    private final int tableSize;
    private int size;
    private final LinkedList<Pair<K, V>>[] table;

    private class Pair<K, V> {
        public K key;
        public V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyDictionary() {
        tableSize = 16;
        table = new LinkedList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public MyDictionary(int _size) {
        tableSize = _size;
        table = new LinkedList[tableSize];

        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % tableSize);
    }

    public void add(K key, V value) {
        int index = hash(key);
        for (Pair<K, V> pair : table[index]) {
            if (pair.key.equals(key)) {
                pair.value = value;
                return;
            }
        }

        table[index].add(new Pair<K, V>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);

        for (Pair<K, V> pair : table[index])
        {
            if (pair.key.equals(key))
            {
                return pair.value;
            }
        }

        throw new NoSuchElementException();
    }

    public void remove(K key) {
        int index = hash(key);

        for (Pair<K, V> pair : table[index])
        {
            if (pair.key.equals(key))
            {
                table[index].remove(pair);
                size--;
                return;
            }
        }
    }

    public V getMax() {
        if (size == 0) {
            throw new NoSuchElementException("Словник порожній");
        }

        V max = null;
        for (int i = 0; i < tableSize; i++) {
            for (Pair<K, V> pair : table[i]) {
                if(max == null || pair.value.compareTo(max) > 0) {
                    max = pair.value;
                }
            }
        }

        return max;
    }

}