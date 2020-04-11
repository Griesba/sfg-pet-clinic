package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.OwnerServiceMap;
import guru.springframework.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerServiceMap ownerService;
    private final VetServiceMap vetService;

    public DataLoader(OwnerServiceMap ownerService, VetServiceMap vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Lino");
        owner.setLastName("Ventura");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner.setId(2L);
        owner.setFirstName("Cedric");
        owner.setLastName("Helba");
        ownerService.save(owner2);

        System.out.println("loading owners size" + ownerService.findAll().size());

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Paul");
        vet.setLastName("Robert");
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet.setId(2L);
        vet.setFirstName("Mel");
        vet.setLastName("Gibson");
        vetService.save(vet2);
        System.out.println("loading vets");
    }
}
