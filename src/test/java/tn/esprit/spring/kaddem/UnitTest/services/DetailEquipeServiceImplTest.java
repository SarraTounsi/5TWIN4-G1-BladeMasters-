package tn.esprit.spring.kaddem.UnitTest.services;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;
import tn.esprit.spring.kaddem.entities.DetailEquipe; // Import DetailEquipe class
import tn.esprit.spring.kaddem.repositories.DetailEquipeRepository; // Import DetailEquipeRepository
import tn.esprit.spring.kaddem.services.DetailEquipeServiceImpl; // Import DetailEquipeServiceImpl

public class DetailEquipeServiceImplTest {

    @InjectMocks
    private DetailEquipeServiceImpl detailEquipeService;

    @Mock
    private DetailEquipeRepository detailEquipeRepository; // Change the repository to DetailEquipeRepository

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addDetailEquipeTest() {
        DetailEquipe newDetailEquipe = new DetailEquipe(1, 123, "Sample Thematique");
        when(detailEquipeRepository.save(eq(newDetailEquipe))).thenReturn(newDetailEquipe);
        DetailEquipe result = detailEquipeService.addDetailEquipe(newDetailEquipe);
        assertThat(result).isNotNull();
        assertThat(result.getIdDetailEquipe()).isNotNull();
        assertThat(result.getSalle()).isEqualTo(123);
        assertThat(result.getThematique()).isEqualTo("Sample Thematique");
        verify(detailEquipeRepository, times(1)).save(eq(newDetailEquipe));
    }

    @Test
    public void getAllDetailEquipesTest() {
        List<DetailEquipe> detailEquipeList = new ArrayList<>();
        detailEquipeList.add(new DetailEquipe(1, 123, "Sample Thematique"));
        detailEquipeList.add(new DetailEquipe(2, 456, "Another Thematique"));
        Mockito.when(detailEquipeRepository.findAll()).thenReturn(detailEquipeList);
        List<DetailEquipe> result = detailEquipeService.retrieveAllDetailEquipes();
        assertThat(result).isNotNull();
        assertThat(result.get(0).getIdDetailEquipe()).isEqualTo(1);
        assertThat(result.get(0).getSalle()).isEqualTo(123);
        assertThat(result.get(0).getThematique()).isEqualTo("Sample Thematique");
        assertThat(result.get(1).getIdDetailEquipe()).isEqualTo(2);
        assertThat(result.get(1).getSalle()).isEqualTo(456);
        assertThat(result.get(1).getThematique()).isEqualTo("Another Thematique");
        verify(detailEquipeRepository, times(1)).findAll();
    }

    @Test
    public void getDetailEquipeTest() {
        Integer detailEquipeIdToRetrieve = 1;
        DetailEquipe expectedDetailEquipe = new DetailEquipe(detailEquipeIdToRetrieve, 123, "Sample Thematique");
        when(detailEquipeRepository.findById(detailEquipeIdToRetrieve)).thenReturn(Optional.of(expectedDetailEquipe));
        DetailEquipe result = detailEquipeService.retrieveDetailEquipe(detailEquipeIdToRetrieve);
        verify(detailEquipeRepository, times(1)).findById(detailEquipeIdToRetrieve);
        assertEquals(expectedDetailEquipe, result);
    }
    @Test
    public void deleteDetailEquipeTest() {
        Integer detailEquipeIdToDelete = 1;
        doNothing().when(detailEquipeRepository).deleteById(detailEquipeIdToDelete);
        detailEquipeService.removeDetailEquipe(detailEquipeIdToDelete);
        verify(detailEquipeRepository, times(1)).deleteById(detailEquipeIdToDelete);
    }

    @Test
    public void updateDetailEquipeTest() {
        Integer detailEquipeIdToUpdate = 1;
        DetailEquipe existingDetailEquipe = new DetailEquipe(detailEquipeIdToUpdate, 123, "Sample Thematique");
        DetailEquipe updatedDetailEquipe = new DetailEquipe(detailEquipeIdToUpdate, 456, "Updated Thematique");

        when(detailEquipeRepository.findById(detailEquipeIdToUpdate)).thenReturn(Optional.of(existingDetailEquipe));
        when(detailEquipeRepository.save(eq(updatedDetailEquipe))).thenReturn(updatedDetailEquipe);

        DetailEquipe result = detailEquipeService.updateDetailEquipe(updatedDetailEquipe);

        assertThat(result).isNotNull();
        assertThat(result.getIdDetailEquipe()).isEqualTo(detailEquipeIdToUpdate);
        assertThat(result.getSalle()).isEqualTo(456);
        assertThat(result.getThematique()).isEqualTo("Updated Thematique");

        verify(detailEquipeRepository, times(1)).findById(detailEquipeIdToUpdate);
        verify(detailEquipeRepository, times(1)).save(eq(updatedDetailEquipe));
    }


}

