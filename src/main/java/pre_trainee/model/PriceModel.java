package pre_trainee.model;

public class PriceModel {
    private String type;
    private String value;

    public PriceModel(String priceLine) {
        this.type = "";
        this.value = "";
        for (int i = 0; i < priceLine.length(); i++) {
            while(i < priceLine.length()) {
                if (priceLine.charAt(i) == '.' || Character.isDigit(priceLine.charAt(i))) {
                    setValue(value += priceLine.charAt(i++));
                } else setType(type += priceLine.charAt(i++));
            }
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + type;
    }

    public static void main(String[] args) {
        System.out.print(new PriceModel("$128.2"));
    }
}
