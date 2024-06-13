package me.ogali.genovore.registries;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Registry<K, V> {

    protected final Map<K, V> registry = new HashMap<>();

    public void register(K key, V value) {
        registry.put(key, value);
    }

    public void unregister(K key) {
        registry.remove(key);
    }

    public Optional<V> get(K key) {
        return Optional.ofNullable(registry.get(key));
    }

}
