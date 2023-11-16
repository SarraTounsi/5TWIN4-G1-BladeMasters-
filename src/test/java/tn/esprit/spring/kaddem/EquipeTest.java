package tn.esprit.spring.kaddem;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;



public class EquipeTest {

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Mock
    private EquipeRepository equipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void addEquipeTest() {

        Equipe newEquipe = new Equipe(1,"Junior Team", Niveau.JUNIOR );
        when(equipeRepository.save(eq(newEquipe))).thenReturn(newEquipe);
        Equipe result = equipeService.addEquipe(newEquipe );
        assertThat(result).isNotNull();
        assertThat(result).isNotNull();
        assertThat(result.getIdEquipe()).isNotNull();
        assertThat(result.getNomEquipe()).isEqualTo("Junior Team");
        verify(equipeRepository, times(1)).save(eq(newEquipe));
    }
    @Test
    public void retrieveAllEquipeTest() {
        List<Equipe> equipeList = new ArrayList<>();
        equipeList.add(new Equipe(1,"Junior Team", Niveau.JUNIOR ));
        equipeList.add(new Equipe(2,"Junior Team", Niveau.JUNIOR ));
        Mockito.when(equipeRepository.findAll()).thenReturn(equipeList);
        List<Equipe> result = equipeService.retrieveAllEquipes();
        System.out.println("............................."+result);
        assertThat(result).isNotNull();
        assertThat(result.get(0).getIdEquipe()).isEqualTo(1);
        assertThat(result.get(0).getNomEquipe()).isEqualTo("Junior Team");
        assertThat(result.get(1).getIdEquipe()).isEqualTo(2);
        assertThat(result.get(1).getNomEquipe()).isEqualTo("Junior Team");
        verify(equipeRepository, times(1)).findAll();
    }
    @Test
    void UpdateEquipeTest() {
        Equipe EquipeToUpdate = new Equipe();
        EquipeToUpdate.setIdEquipe(1);
        EquipeToUpdate.setNomEquipe("Junior Team");
        EquipeToUpdate.setNiveau(Niveau.JUNIOR);
        when(equipeRepository.findById(EquipeToUpdate.getIdEquipe())).thenReturn(Optional.of(EquipeToUpdate));
        when(equipeRepository.save(EquipeToUpdate)).thenReturn(EquipeToUpdate);

        Equipe updatedEquipe = equipeService.updateEquipe(EquipeToUpdate);

        assertNotNull(updatedEquipe);
        assertEquals("Junior Team", updatedEquipe.getNomEquipe());
    }



    @Test
    public void deleteProductTest() {
        int equipeIdToDelete = 1;
        Equipe equipe = new Equipe(equipeIdToDelete, "Junior Team", Niveau.JUNIOR );
        when(equipeRepository.findById(equipeIdToDelete)).thenReturn(Optional.of(equipe));
        equipeService.deleteEquipe(equipeIdToDelete);
        verify(equipeRepository, times(1)).delete(equipe);
    }
    @Test
    public void retrieveProductTest() {
        int equipeIdToRetrieve = 1;
        Equipe expectedEquipe = new Equipe(equipeIdToRetrieve, "Junior Team", Niveau.JUNIOR);
        when(equipeRepository.findById(equipeIdToRetrieve)).thenReturn(Optional.of(expectedEquipe));
        Equipe result = equipeService.retrieveEquipe(equipeIdToRetrieve);
        verify(equipeRepository, times(1)).findById(equipeIdToRetrieve);
        assertEquals(expectedEquipe, result);
    }




}
