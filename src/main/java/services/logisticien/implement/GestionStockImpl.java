package services.logisticien.implement;

import java.util.List;

import jakarta.ejb.Stateless;

import org.hibernate.Session;

import dao.GenericDAO;
import models.Stock;
import services.logisticien.remote.IGestionStock;
import utils.Connexion;

@Stateless
public class GestionStockImpl implements IGestionStock {

    private final GenericDAO<Stock> stockDAO;

    public GestionStockImpl() {
        this.stockDAO = new GenericDAO<>(Stock.class);
    }

    @Override
    public void addStock(Stock stock) {
        stockDAO.add(stock);
    }

    @Override
    public void updateStock(Stock stock) {
        stockDAO.update(stock);
    }

    @Override
    public void deleteStock(int stockId) {
        Stock stock = stockDAO.getById(stockId);
        if (stock != null) {
            stockDAO.delete(stock);
        }
    }

    @Override
    public Stock getStockById(int stockId) {
        return stockDAO.getById(stockId);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockDAO.listAll();
    }
}
