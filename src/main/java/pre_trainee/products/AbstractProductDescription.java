package pre_trainee.products;

import pre_trainee.model.PriceModel;

public abstract class AbstractProductDescription implements Comparable<AbstractProductDescription> {
    private String price;
    private String productName;
    private PriceModel priceModel = null;

    public AbstractProductDescription() {
        productName = "NAME";
        price = "$1200";
    }
    public AbstractProductDescription(String productName, String price) {
        this();
        this.productName = productName;
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public abstract String toString();

    public int compareTo(AbstractProductDescription abstractProductDescription) {
        priceModel = new PriceModel(price);
        return (this.priceModel.getValue().compareTo(new PriceModel(abstractProductDescription.getPrice()).getValue()));
    }
}
