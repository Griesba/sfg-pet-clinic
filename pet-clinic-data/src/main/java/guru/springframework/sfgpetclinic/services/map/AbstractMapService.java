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
        Long id = generateId();
        object.setId(id);
        map.put(id, object);
        return object;
    }

    protected Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    private Long generateId(){
        try {
            return Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e) {
            return  1L;
        }
    }
}
