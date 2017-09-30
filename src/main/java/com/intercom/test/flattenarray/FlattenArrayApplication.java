package com.intercom.test.flattenarray;

import java.util.Collections;
import java.util.List;

public class FlattenArrayApplication {
    public void flattenArray(Object[] inputArray, List<Integer> flattenedIntegerList) {

        if (inputArray instanceof Integer[]) {
            Integer[] elementArray = (Integer[]) inputArray;
            Collections.addAll(flattenedIntegerList, elementArray);
            return;
        }

        for (Object element : inputArray) {
            if (element instanceof Object[]) {
                flattenArray((Object[]) element, flattenedIntegerList);
            } else if (element instanceof Integer) {
                flattenedIntegerList.add((Integer) element);
            }
        }

    }
}
