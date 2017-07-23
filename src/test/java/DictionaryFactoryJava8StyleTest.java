import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by george on 23.07.17.
 */
public class DictionaryFactoryJava8StyleTest {

    DictionaryFactoryJava8Style factory =
            new DictionaryFactoryJava8Style();

    String s = "a xx xdd xyz zxy asdf abc bcd abd aaa ttt ccc aa abe";

    Map<Character,List<String>>  dictionary =
            factory.getDictionary(s);
    // output must be
    // {a=[asdf aaa, abc, abd, abe, aa, a], x=[xdd, xyz, xx]}

    @Test
    public void allTestsInOneInputString()   {
        Assert.assertEquals(2, dictionary.size());

        Set<Character> keySetExpected =
                new TreeSet<Character>(Arrays.asList('a','x'));
        Assert.assertEquals(keySetExpected, dictionary.keySet());

        List<String> listExpected = Arrays.asList("asdf","aaa",
                "abc", "abd", "abe", "aa","a");
        Assert.assertEquals(listExpected, dictionary.get('a'));
    }

}