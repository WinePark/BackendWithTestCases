package com.cybage.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybage.model.Wine;
import com.cybage.service.WineService;

@Controller
@RequestMapping("/api/v1")
public class WineController {
   @Autowired
   private WineService wineService;
   
   @PostMapping("/save")
   public ResponseEntity<Wine> createWine(@RequestBody Wine wine)
   {
	   return new ResponseEntity<Wine>(wineService.createWine(wine),HttpStatus.CREATED);
   }
   @GetMapping("/")
   public ResponseEntity<List<Wine>> getAllWine()
   {
       return new ResponseEntity<List<Wine>>(wineService.getAllWine(),HttpStatus.OK);
   }
   @GetMapping("/{id}")
   public ResponseEntity<Wine> getWineById(@PathVariable int id)
   {
	   return new ResponseEntity<Wine>(wineService.getWineById(id),HttpStatus.OK);
   }
   @GetMapping("/delete/{id}")
   public ResponseEntity<String> deleteWine(@PathVariable int id)
   {
	   wineService.deleteWine(id);
	   return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
   }
   @PostMapping("/update/{id}")
   public ResponseEntity<Wine> updateWine(@PathVariable int id,@RequestBody Wine wine)
   {
	   return new ResponseEntity<Wine>(wineService.updateWine(id, wine),HttpStatus.OK);
   }
}
