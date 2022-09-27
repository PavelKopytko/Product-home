package by.it_academy.jd2.mk_jd2_92_22.storage;

import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.core.entity.ProductBuilder;
import by.it_academy.jd2.mk_jd2_92_22.storage.api.IProductStorage;

import java.util.ArrayList;
import java.util.List;

public class ProductStorage implements IProductStorage {

    //private static ProductStorage instance = new ProductStorage();

    public List<Product> data = new ArrayList<>();
    private int id = 0;

    public ProductStorage() {
        /*this.data.add(ProductBuilder.create()
                .setId(1)
                .setName("Monitor")
                .setPrice(50)
                .setDiscount(5)
                .build());

        this.data.add(ProductBuilder.create()
                .setId(2)
                .setName("Keyboard")
                .setPrice(10)
                .setDiscount(2)
                .build());

        this.data.add(ProductBuilder.create()
                .setId(3)
                .setName("Mouse")
                .setPrice(5)
                .setDiscount(1)
                .setDescription("with tail ))")
                .build());

        this.data.add(ProductBuilder.create()
                .setId(4)
                .setName("Laptop")
                .setPrice(1000)
                .setDiscount(50)
                .setDescription("grey")
                .build());*/

    }

    @Override
    public List<Product> get() {
        return this.data;
    }

    @Override
    public Product get(int id) {
        return this.data.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void save(Product product) {
        product.setId(++id);
        //product.setId(this.data.size());
        this.data.add(product);
    }

    //public static ProductStorage getInstance() {
    //    return instance;
    //}
}
