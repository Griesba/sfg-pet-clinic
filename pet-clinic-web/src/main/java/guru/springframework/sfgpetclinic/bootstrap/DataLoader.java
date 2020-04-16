package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMapImpl;
import guru.springframework.sfgpetclinic.services.map.VetServiceMapImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMapImpl ownerService;
    private final VetServiceMapImpl vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerServiceMapImpl ownerService, VetServiceMapImpl vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType petTypeDog = new PetType();
        petTypeDog.setName("Dog");
        petTypeService.save(petTypeDog);

        PetType petTypeCat = new PetType();
        petTypeCat.setName("cat");
        petTypeService.save(petTypeCat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Owner owner = new Owner();
        owner.setFirstName("Lino");
        owner.setLastName("Ventura");
        owner.setAddress("123 big Lenine");
        owner.setCity("NewYork");
        owner.setTelephone("245435");

        Pet mikePet = new Pet();
        mikePet.setName("roco");
        mikePet.setPetType(petTypeCat);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setOwner(owner);
        owner.getPets().add(mikePet);

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Cedric");
        owner2.setLastName("Helba");
        owner2.setTelephone("6235235");
        owner2.setCity("Miamy");
        owner2.setAddress("123 bitbucket");

        Pet cedricPet = new Pet();
        cedricPet.setName("just cat");
        cedricPet.setOwner(owner2);
        cedricPet.setBirthDate(LocalDate.now());
        cedricPet.setPetType(petTypeDog);
        owner2.getPets().add(cedricPet);
        ownerService.save(owner2);

        System.out.println("loading owners size" + ownerService.findAll().size());

        Vet vet = new Vet();
        vet.setFirstName("Paul");
        vet.setLastName("Robert");
        vet.getSpecialties().add(savedDentistry);
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mel");
        vet2.setLastName("Gibson");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("loading vets");
    }
}
