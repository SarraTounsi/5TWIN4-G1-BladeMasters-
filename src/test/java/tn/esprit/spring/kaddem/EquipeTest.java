package tn.esprit.spring.kaddem;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Niveau;
import tn.esprit.spring.kaddem.repositories.EquipeRepository;
import tn.esprit.spring.kaddem.services.EquipeServiceImpl;


@SpringBootTest
public class EquipeTest {

    @InjectMocks
    private EquipeServiceImpl equipeService;

    @Mock
    private EquipeRepository equipeRepository;


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

//    @Test
//    public void deleteProductTest() {
//        Integer equipeIdToDelete = 1;
//        doNothing().when(equipeRepository).deleteById(equipeIdToDelete);
//        equipeService.deleteEquipe(equipeIdToDelete);
//        verify(equipeRepository, times(1)).deleteById(equipeIdToDelete);
//    }
    @Test
    public void retrieveProductTest() {
        Integer equipeIdToRetrieve = 1;
        Equipe expectedProduct = new Equipe(equipeIdToRetrieve, "Junior Team", Niveau.JUNIOR);
        when(equipeRepository.findById(equipeIdToRetrieve)).thenReturn(Optional.of(expectedProduct));
        Equipe result = equipeService.retrieveEquipe(equipeIdToRetrieve);
        verify(equipeRepository, times(1)).findById(equipeIdToRetrieve);
        assertEquals(expectedProduct, result);
    }




}
