package tn.esprit.spring.kaddem.UnitTest.services;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Option;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.EtudiantServiceImpl;
 class EtudiantServiceImplTest {

    @InjectMocks
    private EtudiantServiceImpl etudiantService;

    @Mock
    private EtudiantRepository etudiantRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
     void ajouterEtudiantTest(){
        Etudiant newEtudiant=new Etudiant(1,"Makdouli","Nour", Option.SIM);
        when(etudiantRepository.save(newEtudiant)).thenReturn(newEtudiant);
        Etudiant result =etudiantService.addEtudiant(newEtudiant);
        assertThat(result).isNotNull();
        assertThat(result).isNotNull();
        assertThat(result.getIdEtudiant()).isNotNull();
        assertThat(result.getNomE()).isEqualTo("Makdouli");
        verify(etudiantRepository,times(1)).save(newEtudiant);

    }

    @Test
     void getAllstudentsTest(){
        List <Etudiant> etudiantList = new ArrayList<>();
        etudiantList.add(new  Etudiant(1,"Makdouli","Nour", Option.SIM));
        etudiantList.add(new  Etudiant(2,"Ouni","Yoldez", Option.GAMIX));
        Mockito.when(etudiantRepository.findAll()).thenReturn(etudiantList);
        List<Etudiant> result =etudiantService.retrieveAllEtudiants();
        System.out.println("......................."+result);
        assertThat(result).isNotNull();
        assertThat(result.get(0).getIdEtudiant()).isEqualTo(1);
        assertThat(result.get(0).getNomE()).isEqualTo("Makdouli");
        assertThat(result.get(1).getIdEtudiant()).isEqualTo(2);
        assertThat(result.get(1).getNomE()).isEqualTo("Ouni");
        verify(etudiantRepository, times(1)).findAll();


    }

    @Test

     void getStudentTest(){
        Integer etudiantIdToRetrieve = 1;
       Etudiant expectedEtudiant = new Etudiant(etudiantIdToRetrieve,"Makdouli","Nour", Option.SIM);
        when(etudiantRepository.findById(etudiantIdToRetrieve)).thenReturn(Optional.of(expectedEtudiant));
        Etudiant result = etudiantService.retrieveEtudiant(etudiantIdToRetrieve);
        verify(etudiantRepository, times(1)).findById(etudiantIdToRetrieve);
        assertEquals(expectedEtudiant, result);
    }

    
    @Test
    public void deleteStudentTest() {
        int StudentId = 1;
        Etudiant std = new  Etudiant(1,"Makdouli","Nour", Option.SIM);
        when(etudiantRepository.findById(StudentId)).thenReturn(Optional.of(std));
       etudiantService.removeEtudiant(StudentId);
        verify(etudiantRepository, times(1)).delete(std);
    }
    @Test
    void UpdateStudentTest() {
        Etudiant etudiant= new  Etudiant("Ouni","Yoldez", Option.GAMIX);
        etudiant.setPrenomE("mourad");
        when(etudiantRepository.findById( etudiant.getIdEtudiant())).thenReturn(Optional.of( etudiant));
        when(etudiantRepository.save( etudiant)).thenReturn( etudiant);

        Etudiant updatedOp= etudiantService.updateEtudiant(etudiant);

        Assertions.assertNotNull(updatedOp);
        assertEquals("Yoldez", etudiant.getPrenomE());
    }


}
