package com.generic.test;

import com.generic.list.CsvFileManipulator;
import com.generic.list.MyList;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CsvFileManipulatorTest {
    private static final String INTEGER_LIST_SAMPLE = "./integer-list-sample.csv";
    private static final String DOUBLE_LIST_SAMPLE = "./double-list-sample.csv";
    private static final String STRING_LIST_SAMPLE = "./string-list-sample.csv";
    private static final String CHARACTER_LIST_SAMPLE = "./character-list-sample.csv";

    @Test
    public void fileManipulatorWithInteger() {
        CsvFileManipulator<Integer> manipulator = new CsvFileManipulator<>(Integer.class);
        try{
            manipulator.manipulateFile(INTEGER_LIST_SAMPLE, 11);
            MyList<Integer> updatedFile = manipulator.readFileToMyList(INTEGER_LIST_SAMPLE);
            int result = updatedFile.indexOf(11);
            Assert.assertEquals(updatedFile.size() - 1, result);
        }catch (Exception e) {
            Assert.assertEquals(NumberFormatException.class, e.getClass());
        }
    }

    @Test
    public void fileManipulatorWithDouble() {
        CsvFileManipulator<Double> manipulator = new CsvFileManipulator<>(Double.class);
        try{
            manipulator.manipulateFile(DOUBLE_LIST_SAMPLE, 11.11);
            MyList<Double> updatedFile = manipulator.readFileToMyList(DOUBLE_LIST_SAMPLE);
            int result = updatedFile.indexOf(11.11);
            Assert.assertEquals(updatedFile.size() - 1, result);
        }catch (Exception e) {
            Assert.assertEquals(NumberFormatException.class, e.getClass());
        }
    }

    @Test
    public void fileManipulatorWithCharacter() throws IOException, CsvValidationException {
        CsvFileManipulator<Character> manipulator = new CsvFileManipulator<>(Character.class);
        manipulator.manipulateFile(CHARACTER_LIST_SAMPLE, 'k');
        MyList<Character> updatedFile = manipulator.readFileToMyList(CHARACTER_LIST_SAMPLE);
        int result = updatedFile.indexOf('k');
        Assert.assertEquals(updatedFile.size()-1, result);
    }

    @Test
    public void fileManipulatorWithString() throws IOException, CsvValidationException {
        CsvFileManipulator<String> manipulator = new CsvFileManipulator<>(String.class);
        manipulator.manipulateFile(STRING_LIST_SAMPLE, "kkk");
        MyList<String> updatedFile = manipulator.readFileToMyList(STRING_LIST_SAMPLE);
        int result = updatedFile.indexOf("kkk");
        Assert.assertEquals(updatedFile.size()-1, result);
    }
}
