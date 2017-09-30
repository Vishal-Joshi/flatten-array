package com.intercom.test.flattenarray;

import com.intercom.test.exception.InvalidInputException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class FlatteningServiceTest {

    @Test
    public void testShouldFlattenArrayOfOneIntegerArray() {
        //given
        FlatteningService flatteningService = new FlatteningService();
        //[1,[2,3]]
        Object[] inputArray = new Object[]{
                1,
                new Integer[]{2, 3}
        };
        Integer[] expectedArray = new Integer[]{1, 2, 3};
        List<Integer> flattenedOutput = new ArrayList<Integer>();

        //when
        flatteningService.flattenArray(inputArray, flattenedOutput);

        //then
        assertThat(flattenedOutput.toArray(new Integer[flattenedOutput.size()]), is(equalTo(expectedArray)));
    }

    @Test
    public void testShouldFlattenArrayOfMultipleArrayOfArrays() {
        //given
        FlatteningService flatteningService = new FlatteningService();
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
        List<Integer> flattenedOutput = new ArrayList<Integer>();

        //when
        flatteningService.flattenArray(inputArray, flattenedOutput);

        //then
        assertThat(flattenedOutput.toArray(new Integer[flattenedOutput.size()]), is(equalTo(expectedArray)));
    }

    @Test(expected = InvalidInputException.class)
    public void testShouldVerifyThatExceptionIsRaisedIfInputArrayIsNull() {
        //given
        FlatteningService flatteningService = new FlatteningService();
        Object[] inputArray = null;
        List<Integer> flattenedOutput = new ArrayList<Integer>();

        //when
        flatteningService.flattenArray(inputArray, flattenedOutput);
    }

    @Test(expected = InvalidInputException.class)
    public void testShouldVerifyThatExceptionIsRaisedIfFlattenedOutputProvidedIsNull() {
        //given
        FlatteningService flatteningService = new FlatteningService();
        Object[] inputArray = new Object[1];
        List<Integer> flattenedOutput = null;

        //when
        flatteningService.flattenArray(inputArray, flattenedOutput);
    }

    @Test(expected = InvalidInputException.class)
    public void testShouldVerifyThatExceptionIsRaisedIfFlattenedOutputIsPrePopulated() {
        //given
        FlatteningService flatteningService = new FlatteningService();
        Object[] inputArray = new Object[1];
        List<Integer> flattenedOutput = new ArrayList<Integer>();
        flattenedOutput.add(1);

        //when
        flatteningService.flattenArray(inputArray, flattenedOutput);
    }

}