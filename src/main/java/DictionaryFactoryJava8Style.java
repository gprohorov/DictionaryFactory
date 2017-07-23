import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by george on 20.07.17.
 */
public class DictionaryFactoryJava8Style {

    // A comparator to arrange words in specific order
    private final  Comparator<String> comparator
         = (String a, String b) ->{
                if (a.length()!=b.length()) {
                    return b.length() - a.length();
                }
                else { return a.compareTo(b);}
            };

/*
*  Three streams to provide result:
*    1. To get an array of words from the input stream
*       and groupby them into map<Char, List<words>>
*    2. Filter off the small ones (value.length >1)
     3. Sort values in specific order
*
* */
    public Map<Character,List<String>> getDictionary(String s){

           return Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(word->word.charAt(0)))
               .entrySet().stream()
               .filter(el->el.getValue().size()>1)
               .collect(Collectors
               .toMap(e -> e.getKey(),
                    e -> new ArrayList<String>(e.getValue()
                       .stream().sorted(comparator)
                       .collect(Collectors.toList()))));
    }
}


