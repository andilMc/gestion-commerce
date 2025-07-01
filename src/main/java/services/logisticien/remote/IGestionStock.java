package services.logisticien.remote;

import java.util.List;

import jakarta.ejb.Remote;

import models.Stock;

@Remote
public interface IGestionStock {
    public void addStock(Stock stock);
    public void updateStock(Stock stock);
    public void deleteStock(int stockId);
    public Stock getStockById(int stockId);
    public List<Stock> getAllStocks();
}
