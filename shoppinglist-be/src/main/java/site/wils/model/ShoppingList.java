package site.wils.model;

/**
 * Created by antoine on 21/04/18.
 */
public class ShoppingList {
    private String category;
    private String type;
    private String brand;
    private String product;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoppingList that = (ShoppingList) o;

        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        return product != null ? product.equals(that.product) : that.product == null;
    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShoppingList{" +
                "category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}