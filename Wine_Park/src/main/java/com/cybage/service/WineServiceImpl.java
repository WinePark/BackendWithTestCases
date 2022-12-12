package com.cybage.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cybage.model.Wine;
import com.cybage.repository.WineRepository;

@Service
public class WineServiceImpl implements WineService {
    
	@Autowired
	private WineRepository wineRepo;
    
	@Override
	public Wine createWine(Wine wine) {
		return wineRepo.save(wine);
	}

	@Override
	public List<Wine> getAllWine() {
		return wineRepo.findAll();
	}

	@Override
	public Wine getWineById(int id) {
		return wineRepo.findById(id).get();
	}

	@Override
	public void deleteWine(int id) {
      Wine wine = wineRepo.findById(id).get();
      if(wine != null)
      {
    	  wineRepo.delete(wine);
      }
	}

	@Override
	public Wine updateWine(int id, Wine wine) {
	   Wine oldWine = wineRepo.findById(id).get();
	   if(oldWine != null)
	      {
		   wine.setId(id);
		   return wineRepo.save(wine);
	      }
		return null;
	}

}
