import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by george on 20.07.17.
 */
public class DictionaryFactory {

    private Map<Character,ArrayList<String>> dictionary;
    private final Comparator<String> comparator;

    public DictionaryFactory() {

        this.comparator = (String a, String b) ->{
            if (a.length()!=b.length()) {
                return b.length() - a.length();
            }
            else {
                return a.compareTo(b);}
            };
        this.dictionary= new TreeMap<Character, ArrayList<String>>();
        }



    public Map<Character,ArrayList<String>> getDictionary(String s){

        Character firstChar;
        ArrayList<String> values;
        this.dictionary.clear();

        // get array of words from input string
        if (s.equals("")) return this.dictionary;
        String[] array = s.split(" ");

        // get a map of the words,
        // words are sorted according to comparator
        for (String word:array){
            firstChar = word.charAt(0);
            values = new ArrayList<>();
            if (this.dictionary.containsKey(firstChar)) {
                values = dictionary.get(firstChar);
            }
            values.add(word);
            Collections.sort(values,comparator);
            dictionary.put(firstChar,values);
        }
        // filter off small entries
        return dictionary.entrySet().stream()
                .filter(el->el.getValue().size()>1)
                .collect(Collectors
                        .toMap(e -> e.getKey(),e -> e.getValue()));
    }


}


