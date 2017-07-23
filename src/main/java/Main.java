import java.util.*;

/**
 * Created by george on 20.07.17.
 */
public class Main {

    public static void main(String[] args) {
        String s = "a xx xdd xyz zxy abc bcd abd aaa ttt ccc aa";
        String s2 = "xyz zxy";
        String s3="";
        DictionaryFactoryJava8Style factory = new DictionaryFactoryJava8Style();

        Map<Character,List<String>> dictionary
                = factory.getDictionary(s);
        System.out.println(dictionary.toString());
        System.out.println(dictionary.keySet());


      //  List<String> list2 = list.sort(comparator);

     //   System.out.println(factory.getDictionary(s).keySet());
      //  System.out.println(factory.getDictionary(s).get('t').size());

       // System.out.println(factory.getDictionary(s2).size());

    }
}
