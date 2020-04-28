package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetMapServiceImplTest {

    PetMapServiceImpl petService;

    @BeforeEach
    void setUp() {
        petService = new PetMapServiceImpl();
        petService.save(Pet.builder().id(1l).birthDate(LocalDate.now()).name("Soso").build());
    }

    @Test
    void findAll() {

        Set<Pet> pets = petService.findAll();
        assertEquals(pets.size(), 1);
        assertEquals(pets.iterator().next().getName(), "Soso");
    }

    @Test
    void findById() {
        Pet pet = petService.findById(1l);
        assertNotNull(pet);
        assertEquals(pet.getId(), 1);
    }

    @Test
    void save() {
        Pet savedPed = petService.save(Pet.builder().name("bob").id(2L).build());
        assertNotNull(savedPed);
        assertEquals(savedPed.getId(), 2);
    }

    @Test
    void delete() {
        Pet savedPed = petService.save(Pet.builder().name("bob").id(2L).build());
        petService.delete(savedPed);
        assertNull(petService.findById(2l));
    }

    @Test
    void deleteById() {
        Pet savedPed = petService.save(Pet.builder().name("bob").id(2L).build());
        petService.deleteById(2L);
        assertNull(petService.findById(2l));
    }
}