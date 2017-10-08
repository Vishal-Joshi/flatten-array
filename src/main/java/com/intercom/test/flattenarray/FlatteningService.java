package com.intercom.test.flattenarray;

import com.intercom.test.exception.InvalidInputException;

import java.util.List;

/**
 * This service takes an input array which may comprise of
 * many nested arrays to finally compose the flattened output.
 *
 * @author Vishal Joshi
 */
public class FlatteningService {

    /**
     * This method should be used to flatten the array composed
     * of multiple nested uni-dimensional arrays
     * @param inputArray array to flatten
     * @param flattenedOutput output array as list.
     */
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

    /**
     * Check if array composes of integers only and no nested arrays
     * @param arrayToCheckForIntegers array to validate
     * @return true, if all integers; else,false
     */
    private boolean ifAllIntegers(Object[] arrayToCheckForIntegers) {
        boolean isInteger = true;
        for (Object element : arrayToCheckForIntegers) {
            isInteger = isInteger && (element instanceof Integer);
        }
        return isInteger;
    }
}
