package by.it_academy.jd2.mk_jd2_92_22.services;

import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.services.api.IProductService;
import by.it_academy.jd2.mk_jd2_92_22.storage.ProductStorage;
import by.it_academy.jd2.mk_jd2_92_22.storage.api.IProductStorage;

import java.util.List;

public class ProductService implements IProductService {

    private static final ProductService instance = new ProductService();

    private final IProductStorage storage;

    private ProductService() {
        this.storage = ProductStorage.getInstance();
    }

    @Override
    public List<Product> get() {
        return this.storage.get();
    }

    @Override
    public Product get(int id) {
        return this.storage.get(id);
    }

    @Override
    public void add(Product product) {
        this.validate(product);
        this.storage.add(product);

    }

    @Override
    public void validate(Product item) {
        if (item == null) {
            throw new IllegalStateException("Вы не передали продукт");
        }
        //Product product = this.storage.get(item.getId());
        //if (product != null) {
            //throw new IllegalArgumentException("Id уже используется");
        //}
        if (item.getName() == null || item.getName().isBlank()) {
            throw new IllegalArgumentException("Вы не заполнили название продукта");
        }

        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException("Неверное значение цены");
        }
        if (item.getDiscount() <= 0) {
            throw new IllegalArgumentException("Неверное значение скидки");
        }
    }

    public static ProductService getInstance() {
        return instance;
    }
}
