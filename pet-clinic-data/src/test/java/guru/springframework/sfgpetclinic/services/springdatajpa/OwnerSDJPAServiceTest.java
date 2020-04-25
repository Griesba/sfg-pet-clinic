package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJPAServiceTest {
    public static final String SMITH = "smith";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJPAService ownerSDJPAService;
    private Owner ownerReturned;

    @BeforeEach
    void setUp() {
        ownerReturned = Owner.builder().id(1L).lastName(SMITH).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(ownerReturned);
        Owner smith = ownerSDJPAService.findByLastName(SMITH);

        assertEquals(SMITH, smith.getLastName());

        verify(ownerRepository.findByLastName(any()));
    }

    @Test
    void findAll() {

        when(ownerRepository.findAll()).thenReturn(Collections.EMPTY_SET);

        Set<Owner> owners = ownerSDJPAService.findAll();

        assertEquals(owners.size(), 0);

        verify(ownerRepository).findAll();

    }

    @Test
    void findById() {

        when(ownerRepository.findById(any())).thenReturn(Optional.ofNullable(ownerReturned));
        Owner smith = ownerSDJPAService.findById(ownerReturned.getId());
        assertNotNull(smith);
        assertEquals(smith.getId(), ownerReturned.getId());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(ownerReturned);
        Owner owner = ownerSDJPAService.save(ownerReturned);

        assertEquals(owner.getId(), ownerReturned.getId());

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJPAService.delete(ownerReturned);

        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
    }
}