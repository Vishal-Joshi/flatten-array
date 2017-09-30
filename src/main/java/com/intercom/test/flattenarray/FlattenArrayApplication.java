package com.intercom.test.flattenarray;

import com.intercom.test.exception.InvalidInputException;

import java.util.List;

public class FlattenArrayApplication {
    public void flattenArray(Object[] inputArray, List<Integer> flattenedOutput) {

        if (inputArray == null) {
            throw new InvalidInputException("Input array should not be null!");
        }
        if (flattenedOutput == null) {
            throw new InvalidInputException("flattenedOutput cannot be null as it has hold elements");
        }
        if (!flattenedOutput.isEmpty()) {
            throw new InvalidInputException("flattenedOutput cannot have pre-filled elements");
        }
        flattenArrayRecursive(inputArray, flattenedOutput);

    }

    private void flattenArrayRecursive(Object[] inputArray, List<Integer> flattenedIntegerList) {
        if (ifAllIntegers(inputArray)) {
            for (Object integerElement : inputArray) {
                flattenedIntegerList.add((Integer) integerElement);
            }
            return;
        }

        for (Object element : inputArray) {
            if (element instanceof Object[]) {
                flattenArrayRecursive((Object[]) element, flattenedIntegerList);
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
