package by.it_academy.jd2.mk_jd2_92_22.storage;

import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.core.entity.ProductBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FileProductStorageTest {

    @Test
    public void save() {
        FileProductStorage storage = new FileProductStorage(System.getProperty("java.io.tmpdir"));
        Product product = ProductBuilder
                .create()
                .setName("Milk")
                .setPrice(5)
                .build();
        storage.save(product);

        Assertions.assertNotNull(product.getId());

        storage.get(product.getId());
        Product byId = storage.get(product.getId());

        Assertions.assertEquals("Milk", byId.getName());
        Assertions.assertEquals(5, byId.getPrice());

    }

    @Test
    public void get() {
        FileProductStorage storage = new FileProductStorage(System.getProperty("java.io.tmpdir"));

        List<Product> beforeSave = storage.get();

        Product product = ProductBuilder
                .create()
                .setName("Milk")
                .setPrice(5)
                .build();
        storage.save(product);

        Assertions.assertNotNull(product.getId());

        storage.get(product.getId());
        List<Product> afterSave = storage.get();

        Assertions.assertEquals(beforeSave.size() + 1, afterSave.size());

    }
}
