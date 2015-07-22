package pre_trainee.products;

import pre_trainee.model.PriceModel;

public class BookDescription extends AbstractProductDescription {
    private String author;
    private String genre;
    private int countPage;
    private PriceModel priceModel = null;
    static private int count = 0;
    static private double cost = 0;

    static private String type = "";

    public BookDescription() {
        super();
        this.author = "author";
        this.genre = "genre";
        this.countPage = 200;
        count = 1;
        cost += 11;
    }

    public BookDescription(String productName, String price, String author, String genre, int countPage) {
        super(productName, price);
        this.author = author;
        this.genre = genre;
        this.countPage = countPage;
        count++;
        priceModel = new PriceModel(price);
        cost += Double.parseDouble(priceModel.getValue());
        type = priceModel.getType();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCountPage() {
        return countPage;
    }

    public void setCountPage(int countPage) {
        this.countPage = countPage;
    }

    public PriceModel getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(PriceModel priceModel) {
        this.priceModel = priceModel;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        BookDescription.count = count;
    }

    public static double getCost() {
        return cost;
    }

    public static void setCost(double cost) {
        BookDescription.cost = cost;
    }

    static public String avgCost() {
        return String.format("%.2f", (cost / count)) + type;
    }

    @Override
    public String toString() {
        return "\n________________________________________________________________\n" +
                "The store contains information about book " + getProductName() +
                ". Price = " + getPrice() + "; \n" + "author: " + author + "\n" +
                "genre: " + genre + "\n" + "countPage - " + countPage;
    }
}
//
//    public static void main(String[] args) {
//        BookDescription bookDescription = new BookDescription("1", "$33", "1", "1", 111);
//        BookDescription bookDescription2 = new BookDescription("1", "$33", "1", "1", 111);
//        BookDescription bookDescription3 = new BookDescription("1", "$33", "1", "1", 111);
//        BookDescription bookDescription4 = new BookDescription("1", "$33", "1", "1", 111);
//        BookDescription bookDescription5 = new BookDescription("1", "$33", "1", "1", 111);
//        System.out.println(avgCost());
//        System.out.println(getCost());
//        System.out.println(getCount());
//    }
//}
