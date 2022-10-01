package by.it_academy.jd2.mk_jd2_92_22.storage.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetEnvironmentVariable;

public class StorageFactoryTest {


    @Test
    @SetEnvironmentVariable(key = "CATALINA_HOME", value = "C://")
    public void priductStorageSingleton(){
        IStorageFactory instsnce1 = StorageFactory.getInstance();
        IStorageFactory instsnce2 = StorageFactory.getInstance();

        Assertions.assertEquals(instsnce1, instsnce2);
    }
}
