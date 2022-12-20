package com.cybage.service;
import java.util.List;
import com.cybage.model.Wine;

public interface WineService {
  public Wine createWine(Wine wine);
  public List<Wine> getAllWine();
  public Wine getWineById(int id);
  public void deleteWine(int id);
  public Wine updateWine(int id, Wine wine);
}
