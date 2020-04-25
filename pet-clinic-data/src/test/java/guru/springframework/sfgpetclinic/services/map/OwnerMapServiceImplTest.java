package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerMapServiceImplTest {

    OwnerMapServiceImpl ownerMapService;
    private Long ownerId = 1L;

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapServiceImpl(new PetTypeMapServiceImpl(), new PetMapServiceImpl());
        ownerMapService.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(owners.size(), 1);
    }

    @Test
    void deleteById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    public void saveExistingId() {
        Owner owner = Owner.builder().id(3L).build();
        Owner savedOwner = ownerMapService.save(owner);
        assertEquals(3L, savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

}