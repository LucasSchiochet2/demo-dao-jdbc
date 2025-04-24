package model.dao;

import model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void insert(Seller department);
    void update(Seller department);
    void deleteById(int id);
    Seller getById(int id);
    List<Seller> getAll();
}
