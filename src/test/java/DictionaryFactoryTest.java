import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

/**
 * Created by george on 20.07.17.
 */
public class DictionaryFactoryTest {
    private String s1= "xyz zxy abc bcd abd aa";
    private String s2= "zzz zxz zzzz xx aaa aab bbb bc xxx xyz axaxa a";
    private DictionaryFactory factory = new DictionaryFactory();
    @Test
    public void whenOnlyLetterA_hasMoreThanOneWordThanSizeIsOne(){
       Map<Character,ArrayList<String>> dictionary
               = factory.getDictionary(s1);
       // Map size =1
         Assert.assertEquals(1, factory.getDictionary(s1).size());
        // The only key must be 'a'
         Assert.assertTrue(factory.getDictionary(s1).keySet()
                 .contains('a'));
         // The  key  'a' has a value list with three words
         Assert.assertEquals(3, factory.getDictionary(s1)
                .get('a').size());
        // The  first is "abc"
         Assert.assertEquals("abc", factory.getDictionary(s1)
                .get('a').get(0));
         // The  second is "abd". It has the same length => aplphab order
         Assert.assertEquals("abd", factory.getDictionary(s1)
                .get('a').get(1));
        // The  third is "aa" because it is shorter
         Assert.assertEquals("aa", factory.getDictionary(s1)
                .get('a').get(2));
    }
    @Test
    public void whenFewLettersHasMoreThanOneWordThanAlphabeticOrder(){
        Map<Character,ArrayList<String>> dictionary
                = factory.getDictionary(s2);

        // Must be 4 keys : a, b, x, z
        Assert.assertEquals(4, dictionary.entrySet().size());

        // in alphabetic order
        Character[] keyArray = {'a','b','x','z'};
        Assert.assertArrayEquals(keyArray,dictionary.keySet().toArray());
    }

}