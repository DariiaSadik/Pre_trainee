package pre_trainee.products;

import pre_trainee.model.PriceModel;

import java.util.Map;

public class ComputerDescription extends AbstractProductDescription {
    private Map<String, String> characteristics;
    private boolean isThere;
    private PriceModel priceModel = null;
    static private int count;
    static private double cost = 0;

    static private String type = "";

    public ComputerDescription() {
        super();
        this.characteristics.put("characteristic_1", "1");
        count++;
        cost += 1;
        this.isThere = ((count != 0));
    }

    public ComputerDescription(String productName, String price, Map<String, String> characteristics) {
        super(productName, price);
        this.characteristics = characteristics;
        count++;
        priceModel = new PriceModel(price);
        cost += Double.parseDouble(priceModel.getValue());
        type = priceModel.getType();
        this.isThere = ((count == 0) ? false : true);
    }

    public Map<String, String> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(Map<String, String> characteristics) {
        this.characteristics = characteristics;
    }

    public boolean isThere() {
        return isThere;
    }

    public void setIsThere(boolean isThere) {
        this.isThere = isThere;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ComputerDescription.count = count;
    }

    public static double getCost() {
        return cost;
    }

    public static void setCost(double cost) {
        ComputerDescription.cost = cost;
    }

    static public String avgCost() {
        return String.format("%.2f", (cost / count)) + type;
    }

    @Override
    public String toString() {
        return "\n________________________________________________________________\n" +
                "The store contains information about computer " + getProductName() +
                ". Price = " + getPrice() + "; \n" +
                "Characteristics: \n" + "____________________________\n" +
                productInformation(characteristics);
    }

    public String productInformation(Map<String, String> characteristics) {
        String characteristic = "";
        for (Map.Entry entry : characteristics.entrySet()) {
            characteristic += (entry.getKey() + " | " + entry.getValue() + "\n");
        }
        return characteristic;
    }
}


//    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("1", "1");
//        map.put("2", "1");
//        map.put("3", "1");
//        map.put("4", "1");
//        map.put("5", "1");
//        ComputerDescription computerDescription = new ComputerDescription("", "$121.3", map);
//        Map<String, String> map1 = new HashMap<String, String>();
//        map.put("1", "1");
//        map.put("2", "1");
//        map.put("3", "1");
//        map.put("4", "1");
//        map.put("5", "1");
//        ComputerDescription computerDescription1 = new ComputerDescription("", "$12221.3", map1);
//        System.out.println(avgCost());
//        System.out.println(computerDescription.getPrice());
//        System.out.println(getCount());
//        System.out.println(getCost());
//    }
//}

