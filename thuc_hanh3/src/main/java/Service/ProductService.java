package Service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private ArrayList<Product> list = new ArrayList<>();

    @Override
    public List<Product> finall() {
        return list;
    }

    @Override
    public void save(Product product) {
        list.add(product);
    }

    @Override
    public Product finbyid(int id) {
        return list.get(id);
    }

    @Override
    public void update(int id, Product product) {
        for (Product i : list) {
            if (i.getId() == id) {
                i = product;
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(id);
                break;
            }
        }
    }
}
