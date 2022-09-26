package by.it_academy.jd2.mk_jd2_92_22.core.entity;


public class ProductBuilder {

    private int id;
    private String name;
    private int price;
    private int discount;
    private String description;

    private ProductBuilder() {
    }

    public static ProductBuilder create() {
        return new ProductBuilder();
    }

    public ProductBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(int price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Product build() {
        return new Product(name, price, discount, description);
    }
}
