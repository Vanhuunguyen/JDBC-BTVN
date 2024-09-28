package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private Category cat_id;

    public Product() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public Product(int id, String name, double price, int cat_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cat_id = cat_id;
    }



    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", cat_id=" + cat_id +
                '}';
    }
}
