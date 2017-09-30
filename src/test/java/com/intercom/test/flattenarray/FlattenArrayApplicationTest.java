package com.intercom.test.flattenarray;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class FlattenArrayApplicationTest {

    @Test
    public void testShouldFlattenArrayOfOneIntegerArray() {
        //given
        FlattenArrayApplication flattenArrayApplication = new FlattenArrayApplication();
        Object[] inputArray = new Object[]{
                1,
                new Integer[]{2, 3}
        };
        Integer[] expectedArray = new Integer[]{1, 2, 3};

        //when
        Integer[] flattenedArray = flattenArrayApplication.flattenArray(inputArray);

        //then
        assertThat(flattenedArray, is(equalTo(expectedArray)));
    }
}