package pre_trainee.container;

import pre_trainee.model.PriceModel;
import pre_trainee.products.AbstractProductDescription;
import pre_trainee.products.BookDescription;
import pre_trainee.products.ComputerDescription;

import java.util.*;

public class ContainerProducts {
    private List<AbstractProductDescription> store =  new ArrayList<AbstractProductDescription>();

    public void addNewProducts(AbstractProductDescription abstractProductDescription) {
        store.add(abstractProductDescription);
    }

    public int count() {
        return store.size();
    }

    public AbstractProductDescription getProduct(int index) {
        return store.get(index);
    }

    public void sortedStore() {
        Collections.sort(store, new Comparator<AbstractProductDescription>() {
            public int compare(AbstractProductDescription o1, AbstractProductDescription o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
    }

    @Override
    public String toString() {
        return "--------------------------- Container --------------------------" + information(store);
    }

    public String information(List<AbstractProductDescription> store ) {
        String information = "";
        for(AbstractProductDescription elem : store){
            information += (elem + "  ");
        }
        return information;
    }
    public static void main(String[] args) {
        ContainerProducts containerProducts = new ContainerProducts();
        BookDescription bookDescription = new BookDescription("1", "$9", "1", "1", 111);
        BookDescription bookDescription2 = new BookDescription("1", "$8", "1", "1", 111);
        BookDescription bookDescription3 = new BookDescription("1", "$6", "1", "1", 111);
        BookDescription bookDescription4 = new BookDescription("1", "$3", "1", "1", 111);
        BookDescription bookDescription5 = new BookDescription("1", "$1", "1", "1", 111);

        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("11", "1");
        map1.put("21", "1");
        map1.put("13", "1");
        map1.put("41", "1");
        map1.put("15", "1");

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");

        ComputerDescription computerDescription = new ComputerDescription("", "$3", map);
        ComputerDescription computerDescription1 = new ComputerDescription("", "$2", map1);

        containerProducts.addNewProducts(bookDescription);
        containerProducts.addNewProducts(bookDescription2);
        containerProducts.addNewProducts(bookDescription3);
        containerProducts.addNewProducts(bookDescription4);
        containerProducts.addNewProducts(bookDescription5);
        containerProducts.addNewProducts(computerDescription1);
        containerProducts.addNewProducts(computerDescription);


        System.out.println(containerProducts);
        System.out.println("-------------------------------------------------------------------");
        containerProducts.sortedStore();
        System.out.println(containerProducts);


        System.out.println("-------------------------------------------------------------------");
        System.out.println(containerProducts.count());
        System.out.println(containerProducts.getProduct(5));
    }
}
