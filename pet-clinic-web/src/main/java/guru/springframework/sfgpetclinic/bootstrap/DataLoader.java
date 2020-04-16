package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.PetTypeService;
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

    public DataLoader(OwnerServiceMapImpl ownerService, VetServiceMapImpl vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType petType = new PetType();
        petType.setName("Dog");

        PetType petTypeCat = new PetType();
        petTypeCat.setName("cat");


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
        cedricPet.setPetType(petTypeCat);
        owner2.getPets().add(cedricPet);
        ownerService.save(owner2);

        System.out.println("loading owners size" + ownerService.findAll().size());

        Vet vet = new Vet();
        vet.setFirstName("Paul");
        vet.setLastName("Robert");
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mel");
        vet2.setLastName("Gibson");
        vetService.save(vet2);
        System.out.println("loading vets");
    }
}
