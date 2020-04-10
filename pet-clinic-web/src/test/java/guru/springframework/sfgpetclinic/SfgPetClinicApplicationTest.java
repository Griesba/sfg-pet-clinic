package guru.springframework.sfgpetclinic;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest (classes = SfgPetClinicApplication.class)
public class SfgPetClinicApplicationTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void tes123 () {
        assertTrue(true);
    }
}