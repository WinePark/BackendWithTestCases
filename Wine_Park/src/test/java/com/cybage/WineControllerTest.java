package com.cybage;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cybage.model.Wine;
import com.cybage.repository.WineRepository;
import com.cybage.service.WineService;
import com.cybage.service.WineServiceImpl;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;





@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class WineControllerTest 
{
      
      
      @Autowired
      private WineRepository winerepo;
      

      @Test
      @Order(1)
      public void addWineTest()
      {
            Wine wine = new Wine();
            //s.setId(1L);
            wine.setId(2);
            wine.setName("Merlot");
            wine.setQuantity(2);
            wine.setPrice(567.87f);
            wine.setCategory("White");
            winerepo.save(wine);
            assertNotNull(winerepo.findById(2).get());
            
            //Mockito.when(winerepo.save(wine)).thenReturn(wine);
            //assertThat(wine.getId()==2);
            //assertThat(wine!=null);

      }
      
      
      
      private void assertEquals(int id, int qty) {
  		// TODO Auto-generated method stub
  		
  	}
      
      
      
      
      @Test
      @Order(2)
      public void getAllWines()
      {
            List<Wine> list = winerepo.findAll();
            assertThat(list).size().isGreaterThan(0);
            
            //Mockito.when(winerepo.findAll()).thenReturn(list);
            //assertThat(wineService.getAllWine()).isEqualTo(list);

      }
      
      
      
      
      
      
      
      
      @Test
      @Order(3)
      public void getWineById()
      {
            Wine w = winerepo.findById(2).get();
            assertEquals(2, w.getQuantity());
      }
      
      
      
      
      
      
      
      @Test
      @Order(4)
      public void updateWine()
      {
            Wine w1 = winerepo.findById(2).get();
            w1.setPrice(600.00f);
            winerepo.save(w1);
            assertNotEquals(2000.00,winerepo.findById(2).get().getPrice());
      }
      
      
      
      
      
      
      
      
  	
      
      @Test
      @Order(5)
      public void deleteWine()
      {
            //winerepo.deleteById(2);;
            //assertThat(winerepo.existsById(2)).isFalse();
      }
      

      

      
}
