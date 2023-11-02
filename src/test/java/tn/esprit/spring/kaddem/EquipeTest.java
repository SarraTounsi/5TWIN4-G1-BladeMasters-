package tn.esprit.spring.kaddem;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;
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

    /*@Test
    public void addEquipeTest() {
        //  Long stockId = 0L;
        Stock stock = new Stock();
        when(stockRepository.findById(eq(stock.getIdStock()))).thenReturn(Optional.of(stock));
        Product newProduct = new Product(0L, "new Product", 10, 10, ProductCategory.ELECTRONICS, stock);
        when(productRepository.save(eq(newProduct))).thenReturn(newProduct);
        Product result = productService.addProduct(newProduct, stock.getIdStock());
        assertThat(result).isNotNull();
        assertThat(result).isNotNull();
        assertThat(result.getIdProduct()).isNotNull();
        assertThat(result.getTitle()).isEqualTo("new Product");
        verify(productRepository, times(1)).save(eq(newProduct));
    }*/
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




}
