import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class PangramTest {

    Pangram p;

    @Before
    public void setUp(){
        p = new Pangram();
    }

    @Test
    public void test_single_letter() {
        assertTrue(p.isPangram("a"));
    }
    @Test
    public void test_word_positive() {
        assertTrue(p.isPangram("paramarap"));
    }
    @Test
    public void test_word_negative() {
        assertFalse(p.isPangram("panmagister"));
    }
    @Test
    public void test_list_positive() {
        String[] words = {"kajak","terpret","pomop","cukopokuc"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        Boolean[] flags = {true,true,true,true};
        ArrayList<Boolean> expected = new ArrayList<Boolean>(Arrays.asList(flags));
        assertEquals(expected,p.isPangram(list));
    }
    @Test
    public void test_list_negative() {
        String[] words = {"kaasdf","teasdfrpret","pomasdop","cukoasdfpokuc"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        Boolean[] flags = {false,false,false,false};
        ArrayList<Boolean> expected = new ArrayList<Boolean>(Arrays.asList(flags));
        assertEquals(expected,p.isPangram(list));
    }

    @Test
    public void test_list_mixed() {
        String[] words = {"kajak","terpret","pasdfomop","cukoadsfpokuc"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        Boolean[] flags = {true,true,false,false};
        ArrayList<Boolean> expected = new ArrayList<Boolean>(Arrays.asList(flags));
        assertEquals(expected,p.isPangram(list));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_exception_empty(){
        try {
            assertEquals(false, p.isPangram(""));
        }
        catch(IllegalArgumentException e){
            assertEquals("Napis nie moze byc pusty",e.getMessage());
            throw e;
        }
        }
    @Test(expected = IllegalArgumentException.class)
    public void test_exception_null(){
        try {
            assertEquals(false, p.isPangram((String)null));
        }
        catch(IllegalArgumentException e){
            assertEquals("Napis nie moze byc nullem",e.getMessage());
            throw e;
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void test_list_exception_empty() {
        String[] words = {"kajak","","pomop","cukopokuc"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        Boolean[] flags = {true,true,true,true};
        ArrayList<Boolean> expected = new ArrayList<Boolean>(Arrays.asList(flags));
        try {
            assertEquals(expected,p.isPangram(list));        }
        catch(IllegalArgumentException e){
            assertEquals("Napis nie moze byc pusty",e.getMessage());
            throw e;
        }

    }
    @Test(expected = IllegalArgumentException.class)
    public void test_list_exception_null() {
        String[] words = {"kaasdf","teasdfrpret",null,"cukoasdfpokuc"};
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
        Boolean[] flags = {false,false,false,false};
        ArrayList<Boolean> expected = new ArrayList<Boolean>(Arrays.asList(flags));
        try {
            assertEquals(expected,p.isPangram(list));        }
        catch(IllegalArgumentException e){
            assertEquals("Napis nie moze byc nullem",e.getMessage());
            throw e;
        }
    }
/*
    @Test
    public void test_fizz_method(){
        assertEquals("Fizz",temp.print(3));
        assertEquals("Fizz",temp.print(9));
    }

    @Test
    public void test_buzz_method(){
        assertEquals("Buzz",temp.print(5));
        assertEquals("Buzz",temp.print(20));
    }


    }*/
}
