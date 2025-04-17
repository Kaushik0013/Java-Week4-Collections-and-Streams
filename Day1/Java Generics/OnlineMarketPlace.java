import java.util.ArrayList;
import java.util.List;

interface Category {
    String getCategoryName();
}

enum BookCategory implements Category {
    FICTION, NON_FICTION, SCIENCE;

    public String getCategoryName() {
        return this.name();
    }
}

enum ClothingCategory implements Category {
    MEN, WOMEN, KIDS;

    public String getCategoryName() {
        return this.name();
    }
}

enum GadgetCategory implements Category {
    MOBILE, LAPTOP, ACCESSORY;

    public String getCategoryName() {
        return this.name();
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return name + " | $" + price + " | Category: " + category.getCategoryName();
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountedPrice = product.getPrice() - (product.getPrice() * percentage / 100.0);
        product.setPrice(Math.round(discountedPrice * 100.0) / 100.0);
    }
}

class ProductCatalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product<? extends Category> product : products) {
            System.out.println(product);
        }
    }
}

public class OnlineMarketPlace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Atomic Habits", 15.99, BookCategory.NON_FICTION);
        Product<ClothingCategory> shirt = new Product<>("Graphic T-Shirt", 25.00, ClothingCategory.MEN);
        Product<GadgetCategory> phone = new Product<>("Smartphone X", 699.99, GadgetCategory.MOBILE);

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 15);
        DiscountUtil.applyDiscount(phone, 5);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        catalog.displayProducts();
    }
}
