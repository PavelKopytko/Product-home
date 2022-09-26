package by.it_academy.jd2.mk_jd2_92_22.core.entity;

import java.util.Objects;

public class Product {

    private int id;
    private final String name;
    private final int price;
    private final int discount;
    private final String description;

    public Product(String name, int price, int discount, String description) {
        //this.id = id++;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && price == product.price && discount == product.discount && Objects.equals(name, product.name) && Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, discount, description);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}
