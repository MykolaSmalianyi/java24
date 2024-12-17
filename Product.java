/**
 * Клас для демонстрації валідації полів продукту.
 */
public class Product {
    @NotNull
    private String productName;

    @MaxValue(1000)
    private int price;

    /**
     * Конструктор для ініціалізації полів продукту.
     *
     * @param productName назва продукту.
     * @param price       ціна продукту.
     */
    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }
}
