package com.generic.test;

import com.generic.list.MyList;
import org.junit.Assert;
import org.junit.Test;

public class MyListTest {

    @Test
    public void addMethodWithUniqueValues() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        Assert.assertEquals("[ 1, 2, 3, 4, 5, 6 ]", list.toString());
    }

    @Test
    public void addMethodWithDuplicates() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(3);
        Assert.assertEquals(4, list.size());
    }

    @Test
    public void indexOfWithErrorValue() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Assert.assertEquals(-1, list.indexOf(5));
    }

    @Test
    public void indexOfWithProperValue() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Assert.assertEquals(2, list.indexOf(3));
    }

    @Test
    public void isEmptyWithEmptyList() {
        MyList<Integer> list = new MyList<>();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void isEmptyWithNonEmptyList() {
        MyList<Integer> list = new MyList<>();
        list.add(3);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void removeWithErrorValue() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(5);
        Assert.assertEquals(3, list.size());
    }

    @Test
    public void removeWithProperValue() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        Assert.assertEquals("[ 1, 3 ]", list.toString());
    }

    @Test
    public void searchWithErrorValue() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertFalse(list.search(5));
    }

    @Test
    public void searchWithProperValue() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertTrue(list.search(2));
    }

    @Test
    public void appendWithSingleValue() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.append(4);
        Assert.assertEquals("[ 1, 2, 3, 4 ]", list.toString());
    }

    @Test
    public void appendWithMultipleValues() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.append(4,3,5,6);
        Assert.assertEquals("[ 1, 2, 3, 4, 5, 6 ]", list.toString());
    }

    @Test
    public void insertAtWithErrorValues() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        try {
            list.insertAt(3, 5);
        }catch (Exception e){
            Assert.assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    public void insertAtWithProperValues() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.insertAt(1, 4);
        Assert.assertEquals("[ 1, 4, 2, 3 ]", list.toString());
    }

    @Test
    public void popWithoutPosition() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer result = list.pop();
        Assert.assertEquals("[ 1, 2, 3, 4 ]", list.toString());
        Assert.assertEquals(5, result.intValue());
    }

    @Test
    public void popWithErrorPosition() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        try {
            list.pop(5);
        }catch (Exception e){
            Assert.assertEquals(ArrayIndexOutOfBoundsException.class, e.getClass());
        }
    }

    @Test
    public void popWithProperPosition() {
        MyList<Integer> list = new MyList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer result = list.pop(3);
        Assert.assertEquals("[ 1, 2, 3, 5 ]", list.toString());
        Assert.assertEquals(4, result.intValue());
    }
}
