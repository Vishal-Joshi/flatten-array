package com.intercom.test.flattenarray;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class FlattenArrayApplicationTest {

    @Test
    public void testShouldFlattenArrayOfOneIntegerArray() {
        //given
        FlattenArrayApplication flattenArrayApplication = new FlattenArrayApplication();
        //[1,[2,3]]
        Object[] inputArray = new Object[]{
                1,
                new Integer[]{2, 3}
        };
        Integer[] expectedArray = new Integer[]{1, 2, 3};
        List<Integer> flattenedArray = new ArrayList<Integer>();

        //when
        flattenArrayApplication.flattenArray(inputArray, flattenedArray);

        //then
        assertThat(flattenedArray.toArray(new Integer[flattenedArray.size()]), is(equalTo(expectedArray)));
    }

    @Test
    public void testShouldFlattenArrayOfMultipleArrayOfArrays() {
        //given
        FlattenArrayApplication flattenArrayApplication = new FlattenArrayApplication();
        //[1,[2,3],[[4],[[5,6],7],[8,9]]]
        Object[] inputArray = new Object[]{
                1,
                new Object[]{2, 3},
                new Object[]
                        {
                                new Object[]{4},
                                new Object[]{
                                        new Object[]{5, 6},
                                        7
                                },
                                new Object[]{8, 9}
                        }};
        Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> flattenedArray = new ArrayList<Integer>();

        //when
        flattenArrayApplication.flattenArray(inputArray, flattenedArray);

        //then
        assertThat(flattenedArray.toArray(new Integer[flattenedArray.size()]), is(equalTo(expectedArray)));
    }
}