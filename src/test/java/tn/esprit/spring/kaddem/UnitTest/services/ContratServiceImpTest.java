package tn.esprit.spring.kaddem.UnitTest.services;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.services.IContratService;

import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContratServiceImpTest {

    @Autowired
    IContratService contratService;

    @Autowired
    private ContratRepository contratRepository;

    @Test
    @Order(1)
    public void retrieveAllContrats(){
        List<Contrat> listcontrat=contratService.retrieveAllContrats();
        Assertions.assertEquals(0,listcontrat.size());
    }

    @Test
    @Order(2)
    public void testUpdateContrat() {
        // Create a Contrat instance for testing
        Contrat ce = new Contrat();
        ce.setDateDebutContrat(new Date());
        ce.setDateFinContrat(new Date(125, 1, 10));
        ce.setSpecialite(Specialite.CLOUD);
        ce.setArchive(true);
        ce.setMontantContrat(11);
        // Call the method under test
        Contrat updatedContrat = contratService.updateContrat(ce);

        // Retrieve the Contrat from the database
        Contrat retrievedContrat = contratRepository.findById(updatedContrat.getIdContrat()).orElse(null);

        // Assert that the retrieved Contrat is the same as the one returned by the service
        Assertions.assertEquals(updatedContrat, retrievedContrat);
    }
}
