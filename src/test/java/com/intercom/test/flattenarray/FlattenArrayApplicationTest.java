package com.intercom.test.flattenarray;

import com.intercom.test.exception.InvalidInputException;
import org.junit.Test;

public class FlattenArrayApplicationTest {

    @Test(expected = InvalidInputException.class)
    public void testShouldRaiseAnExceptionIfInputArrayIsNotArray(){
        //given
        FlattenArrayApplication flattenArrayApplication = new FlattenArrayApplication();
        Object inputArray = new Object();

        //when
        flattenArrayApplication.flattenArray(inputArray);
    }
}