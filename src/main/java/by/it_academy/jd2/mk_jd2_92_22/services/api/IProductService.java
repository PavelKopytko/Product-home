package by.it_academy.jd2.mk_jd2_92_22.services.api;

import by.it_academy.jd2.mk_jd2_92_22.core.ProductCreateDTO;
import by.it_academy.jd2.mk_jd2_92_22.core.entity.Product;

public interface IProductService extends IEssenceService<Product> {

    void save(ProductCreateDTO p);
}
