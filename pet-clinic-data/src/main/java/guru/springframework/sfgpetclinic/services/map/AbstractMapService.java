package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService <T extends BaseEntity, ID extends Long> {
    private Map<Long, T> map = new HashMap<>();

    void deleteById(ID id) {
        map.remove(id);
    }

    T findById(ID id) {
        return map.get(id);
    }

    void  delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    T save(T object) {
        if (object == null) {
            throw new RuntimeException("object cannot be null");
        }
        return map.put(generateId(), object);
    }

    protected Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    private Long generateId(){
        Long nextId;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;

    }
}
