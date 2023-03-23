package entities.services;

import java.util.ArrayList;
import java.util.List;

public class PrintService {

    private List<Object> printList = new ArrayList<>();
    public void addValue(Object value) {
        printList.add(value);
    }

    public Object first(int position) {
        if(printList.isEmpty()) throw new IllegalStateException("Empty list");

        return printList.get(position);
    }

    public void print() {
        if (!printList.isEmpty()) {
            System.out.println(printList.get(0));
        }
        for (int i = 0; i < printList.size(); i++) {
            System.out.println(printList.get(i));
        }
    }


}
