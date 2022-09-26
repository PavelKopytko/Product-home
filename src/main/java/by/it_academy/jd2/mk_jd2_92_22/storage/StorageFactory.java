package by.it_academy.jd2.mk_jd2_92_22.storage;

import by.it_academy.jd2.mk_jd2_92_22.storage.api.IStorageFactory;

public class StorageFactory implements IStorageFactory {

    private static final IStorageFactory instance = new StorageFactory();

    private IStorageFactory productStorage;

    public StorageFactory(){
        //this.productStorage = new ProductStorage();
    }
}
