package by.it_academy.jd2.Mk_JD2_103_23.vote.core.dto;

public class PairData<K, V> {
    private K key;
    private V value;

    public PairData() {
    }

    public PairData(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PairData{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
