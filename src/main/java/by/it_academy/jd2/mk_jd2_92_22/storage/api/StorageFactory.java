package by.it_academy.jd2.mk_jd2_92_22.storage.api;

import by.it_academy.jd2.mk_jd2_92_22.storage.MemoryProductStorage;

public class StorageFactory implements IStorageFactory {

    private static final IStorageFactory instance = new StorageFactory();

    private IProductStorage productStorage;

    private StorageFactory() {
        this.productStorage = new MemoryProductStorage();
    }

    @Override
    public IProductStorage getProductStorage() {
        return this.productStorage;
    }

    public static IStorageFactory getInstance(){
        return instance;
    }
}
