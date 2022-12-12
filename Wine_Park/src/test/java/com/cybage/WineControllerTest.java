package com.cybage;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cybage.model.Wine;
import com.cybage.repository.WineRepository;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;





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
      }
      
      @Test
      @Order(2)
      public void getAllWines()
      {
            List<Wine> list = winerepo.findAll();
            assertThat(list).size().isGreaterThan(0);
      }
      
      @Test
      @Order(3)
      public void getWineById()
      {
            Wine w = winerepo.findById(2).get();
            assertEquals(1000,w.getQuantity());
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
            //repo.deleteById(14L);
            //assertThat(repo.existsById(14L)).isFalse();
      }
      

      

      
}
