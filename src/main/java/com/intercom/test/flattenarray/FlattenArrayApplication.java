package com.intercom.test.flattenarray;

import java.util.List;

public class FlattenArrayApplication {
    public void flattenArray(Object[] inputArray, List<Integer> flattenedIntegerList) {

        if (ifAllIntegers(inputArray)) {
            for (Object integerElement : inputArray) {
                flattenedIntegerList.add((Integer) integerElement);
            }
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

    private boolean ifAllIntegers(Object[] arrayToCheckForIntegers) {
        boolean isInteger = true;
        for (Object element : arrayToCheckForIntegers) {
            isInteger = isInteger && (element instanceof Integer);
        }
        return isInteger;
    }
}
