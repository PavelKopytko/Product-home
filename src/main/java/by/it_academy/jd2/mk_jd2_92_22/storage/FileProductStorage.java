package by.it_academy.jd2.mk_jd2_92_22.storage;

import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;
import by.it_academy.jd2.mk_jd2_92_22.storage.api.IProductStorage;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FileProductStorage implements IProductStorage {

    private final AtomicInteger counter =new AtomicInteger(0);

    private final String pathToFile;
    private final ObjectMapper mapper = new ObjectMapper();

    public FileProductStorage() {
        String home = System.getenv("CATALINA_HOME");
        if (home == null || home.isBlank()) {
            throw new IllegalStateException("Отсутствует переменная окружения");
        }
        this.pathToFile = home + File.separator + "conf" + File.separator + "products.txt";

    }

    public FileProductStorage(String pathToDir) {
        File f = new File(pathToDir);
        if (!f.isDirectory()) {
            throw new IllegalArgumentException("Требуется предать путь к папке");
        }
        if (!f.canWrite()) {
            throw new IllegalArgumentException("Нет доступа на запись в папку");
        }
        this.pathToFile = f.getAbsolutePath() + File.separator + "products.txt";
    }

    @Override
    public List<Product> get() {
        List<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = mapper.readValue(line, Product.class);
                products.add(product);
            }
            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product get(int id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = mapper.readValue(line, Product.class);
                if (id == product.getId()) {
                    return product;
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Product product) {
        product.setId(counter.incrementAndGet());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile,true))) {
            writer.write(mapper.writeValueAsString(product));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
