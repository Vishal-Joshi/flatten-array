package com.intercom.test.flattenarray;

import java.util.ArrayList;
import java.util.List;

public class FlattenArrayApplication {
    //[[1,2,[3]],4] → [1,2,3,4]

    public Integer[] flattenArray(Object[] inputArray) {
        List<Integer> flattenedIntegerList = new ArrayList<Integer>();
        for (Object element : inputArray) {
            if (element instanceof Integer[]) {
                Integer[] elementArray = (Integer[]) element;
                for (Integer currentElement : elementArray) {
                    flattenedIntegerList.add(currentElement);
                }
            } else if (element instanceof Integer) {
                flattenedIntegerList.add((Integer) element);
            }
        }
        return flattenedIntegerList.toArray(new Integer[flattenedIntegerList.size()]);

    }
}
