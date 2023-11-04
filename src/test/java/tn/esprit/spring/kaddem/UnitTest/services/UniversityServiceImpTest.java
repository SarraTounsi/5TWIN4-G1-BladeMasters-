package tn.esprit.spring.kaddem.UnitTest.services;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import tn.esprit.spring.kaddem.entities.Universite;
import tn.esprit.spring.kaddem.repositories.UniversiteRepository;
import tn.esprit.spring.kaddem.services.UniversiteServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UniversityServiceImpTest {


    @InjectMocks
    private UniversiteServiceImpl universiteService;
    @Mock
    private UniversiteRepository universiteRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void addUniversiteTest() {

        Universite universite = new Universite();
        when(universiteRepository.findById(eq(universite.getIdUniv()))).thenReturn(Optional.of(universite));
        Universite newUniver = new Universite(1,"esprit");
        when(universiteRepository.save(eq(newUniver))).thenReturn(newUniver);
        Universite result = universiteService.addUniversite(newUniver);
        assertThat(result).isNotNull();
        assertThat(result).isNotNull();
        assertThat(result.getIdUniv()).isNotNull();
        assertThat(result.getNomUniv()).isEqualTo("esprit");
        verify(universiteRepository, times(1)).save(eq(newUniver));
    }

    @Test
    public void retrieveAllUniversiteTest() {
        List<Universite> universiteList = new ArrayList<>();
        universiteList.add(new Universite(1,"esprit"));
        universiteList.add(new Universite(2,"iset"));
        when(universiteRepository.findAll()).thenReturn(universiteList);
        List<Universite> universiteResult = universiteService.retrieveAllUniversites();
        System.out.println("######## UNIVERSETIES ############# = "+universiteResult.isEmpty());
        assertThat(universiteResult).isNotNull();
        assertThat(universiteResult.get(0).getIdUniv()).isEqualTo(1);
        assertThat(universiteResult.get(0).getNomUniv()).isEqualTo("esprit");
        assertThat(universiteResult.get(1).getIdUniv()).isEqualTo(2);
        assertThat(universiteResult.get(1).getNomUniv()).isEqualTo("iset");
        verify(universiteRepository, times(1)).findAll();
    }

//    @Test
//    public void deleteUniversiteTest() {
////        Integer UniversiteId = 1;
//        Universite expectedUniversite = new Universite(
//                1,
//                "esprit");
//        doNothing().when(universiteRepository).deleteById(expectedUniversite.getIdUniv());
//        System.out.println("ddd"+expectedUniversite.getIdUniv());
//        universiteService.deleteUniversite(expectedUniversite.getIdUniv());
//        verify(universiteRepository, times(1)).deleteById(expectedUniversite.getIdUniv());
//    }

    @Test
    public void retrieveUniversiteTest() {
        Integer UniversiteId = 1;
        Universite expectedUniversite = new Universite(
                UniversiteId,
                "esprit");
        when(universiteRepository.findById(UniversiteId)).thenReturn(Optional.of(expectedUniversite));
        Universite universiteResult = universiteService.retrieveUniversite(UniversiteId);
        verify(universiteRepository, times(1)).findById(UniversiteId);
        assertEquals(expectedUniversite, universiteResult);
    }
}