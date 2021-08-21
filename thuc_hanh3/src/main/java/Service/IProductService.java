package Service;

import model.Product;

import java.util.List;
import java.util.Properties;

public interface IProductService {
    List<Product> finall();
    void save(Product product);
    Product finbyid(int id);
    void update(int id,Product product);
    void delete(int id);
}
