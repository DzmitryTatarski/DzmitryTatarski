package bubbleSort;

import java.util.*;

public class BubbleSort {

    public List<Number> sort (List<Number> input) {
        if (input == null) {
            throw new NullPointerException();
        }
        boolean isSorted = false;
        List<Number> list = new ArrayList<>(input);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null)
                list.remove(i);
        }
        while (!isSorted){
            isSorted = true;
            Number first;
            Number second;
            for (int i = 1; i < list.size(); i++) {
                first = list.get(i - 1);
                second = list.get(i);
                if (compare(first, second)) {
                    isSorted = false;
                    list.set(i - 1, second);
                    list.set(i, first);
                }
            }
        }
        return list;
    }

    private boolean compare (Number first, Number second){
        return first.doubleValue() > second.doubleValue();
    }

    private boolean isNull (Number number){
        if (number == null)
            throw new NullPointerException();
        return false;
    }
}
