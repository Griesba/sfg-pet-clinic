package guru.springframework.sfgpetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService <T, ID> {
    private Map<ID, T> map = new HashMap<>();

    void deleteById(ID id) {
        map.remove(id);
    }

    T findById(ID id) {
        return map.get(id);
    }

    void  delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }


    T save(ID id, T object) {
        map.put(id, object);
        return map.get(id);
    }

    protected Set<T> findAll() {
        return new HashSet<>(map.values());
    }
}
