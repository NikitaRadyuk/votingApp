package org.example;

public class Counter {
    String name;
    int count;

    public Counter(String name) {
        this.name = name;
        count = 1;
    }

    @Override
    public String toString() {
        return "За'" + name +
                "' проголосовало: " + count;
    }
}

