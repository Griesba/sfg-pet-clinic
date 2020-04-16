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
        if (object.getId() == null) {
            object.setId(getNextId());
        }
        map.put(object.getId(), object);
        return object;
    }

    protected Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    private Long getNextId(){
        try {
            return Collections.max(map.keySet()) + 1;
        }catch (NoSuchElementException e) {
            return  1L;
        }
    }
}
