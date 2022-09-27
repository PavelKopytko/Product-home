package by.it_academy.jd2.mk_jd2_92_22.services.api;

import by.it_academy.jd2.mk_jd2_92_22.services.ProductService;

public class ServiceFactory implements IServiceFactory {

    private static final IServiceFactory instance = new ServiceFactory();

    private IProductService productService;

    private ServiceFactory() {
        this.productService = new ProductService();
    }

    @Override
    public IProductService getProductService() {
        return this.productService;
    }

    public static IServiceFactory getInstance() {
        return instance;
    }
}
