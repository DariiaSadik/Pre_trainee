package pre_trainee.container;

import pre_trainee.products.AbstractProductDescription;

import java.util.*;

public class ContainerProducts {
    private List<AbstractProductDescription> store = new ArrayList<AbstractProductDescription>();

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

    public String information(List<AbstractProductDescription> store) {
        String information = "";
        for (AbstractProductDescription elem : store) {
            information += (elem + "  ");
        }
        return information;
    }
}

