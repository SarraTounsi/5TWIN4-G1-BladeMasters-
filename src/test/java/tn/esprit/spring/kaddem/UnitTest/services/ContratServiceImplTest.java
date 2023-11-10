package tn.esprit.spring.kaddem.UnitTest.services;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Etudiant;

import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;
import java.util.Arrays;


import java.util.List;


import java.util.Optional;
import static org.mockito.Mockito.*;

public class ContratServiceImplTest  {

    @InjectMocks
    private ContratServiceImpl contratService;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EtudiantRepository etudiantRepository;

    // Initialize mocks
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddContrat() {
        // Given
        Etudiant etudiant = new Etudiant();
        Contrat contratToAdd = new Contrat();
        contratToAdd.setEtudiant(etudiant);

        // Use the real save method of etudiantRepository
        doAnswer(invocation -> {
            Etudiant etudiantArgument = invocation.getArgument(0);
            // You can add some assertions or print statements to debug
            // For example: assertThat(etudiantArgument).isNotNull();
            return etudiantArgument;
        }).when(etudiantRepository).save(any(Etudiant.class));

        when(contratRepository.save(eq(contratToAdd))).thenReturn(contratToAdd);

        // When
        contratService.addContrat(contratToAdd);

        // Verify that the contratRepository save method is being called
        verify(contratRepository, times(1)).save(eq(contratToAdd));
    }


    
    @Test
    public void testRetrieveContrat() {
        // Given
        Integer contratId = 1;
        Contrat expectedContrat = new Contrat();
        expectedContrat.setIdContrat(contratId);

        when(contratRepository.findById(contratId)).thenReturn(Optional.of(expectedContrat));

        // When
        Contrat retrievedContrat = contratService.retrieveContrat(contratId);

        // Then
        assertThat(retrievedContrat).isNotNull();
        assertThat(retrievedContrat.getIdContrat()).isEqualTo(contratId);

        // Verify that the repository's findById method was called
        verify(contratRepository, times(1)).findById(contratId);
    }
    
    @Test
    public void testRetrieveAllContrats() {
        // Given
        Contrat contrat1 = new Contrat();
        Contrat contrat2 = new Contrat();
        List<Contrat> contratList = Arrays.asList(contrat1, contrat2);

        when(contratRepository.findAll()).thenReturn(contratList);

        // When
        List<Contrat> retrievedContrats = contratService.retrieveAllContrats();

        // Then
        assertThat(retrievedContrats).isNotNull();
        assertThat(retrievedContrats).hasSize(2); // Assuming two contrats are returned

        // Verify that the repository's findAll method was called
        verify(contratRepository, times(1)).findAll();
    }
    
    
}
