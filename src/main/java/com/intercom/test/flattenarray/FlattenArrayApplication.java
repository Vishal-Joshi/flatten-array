package com.intercom.test.flattenarray;

import com.intercom.test.exception.InvalidInputException;

public class FlattenArrayApplication {
    //[[1,2,[3]],4] → [1,2,3,4]

    public Integer[] flattenArray(Object inputArray){
        if(inputArray instanceof int[]){
            return null;
        }
        throw new InvalidInputException();
    }
}
