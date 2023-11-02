package tn.esprit.spring.kaddem; // Update the package name to match your entity's package

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;
import tn.esprit.spring.kaddem.services.IUniversiteService;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootTest
@ContextConfiguration(classes = {universiteServiceImpl.class})
@ExtendWith(MockitoExtension.class)
public class UniversiteTest {

    @InjectMocks
    private UniversiteService universiteService;
    @Mock
    private DepartementRepository departementRepository;
    @Mock
    private UniversiteRepository universiteRepository;

    @Test
    public void createUniversiteTest() {
        Universite newUniversite = new Universite("My University");

        when(universiteRepository.save(eq(newUniversite))).thenReturn(newUniversite);

        Universite result = universiteService.createUniversite(newUniversite);

        assertThat(result).isNotNull();
        assertThat(result.getIdUniv()).isNotNull();
        assertThat(result.getNomUniv()).isEqualTo("My University");
        verify(universiteRepository, times(1)).save(eq(newUniversite));
    }

    @Test
    public void retrieveUniversiteTest() {
        Integer universiteIdToRetrieve = 1;
        Universite expectedUniversite = new Universite(universiteIdToRetrieve, "Sample University");
        when(universiteRepository.findById(universiteIdToRetrieve)).thenReturn(Optional.of(expectedUniversite));

        Universite result = universiteService.retrieveUniversite(universiteIdToRetrieve);

        verify(universiteRepository, times(1)).findById(universiteIdToRetrieve);
        assertEquals(expectedUniversite, result);
    }

    @Test
    public void deleteUniversiteTest() {
        Integer universiteIdToDelete = 5;
        doNothing().when(universiteRepository).deleteById(universiteIdToDelete);
        universiteService.deleteUniversite(universiteIdToDelete);
        verify(universiteRepository, times(1)).deleteById(universiteIdToDelete);
    }

}
