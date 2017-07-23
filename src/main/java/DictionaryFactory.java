import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by george on 20.07.17.
 */
public class DictionaryFactory {
   // private String str;
    private Map<Character,ArrayList<String>> dictionary;
    private final Comparator<String> comparator;

    public DictionaryFactory() {
        //this.str = str;
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
        if (s.equals("")) return this.dictionary;
        String[] array = s.split(" ");

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
/*        System.out.println(dictionary.toString());
        System.out.println("-------------");*/
        Map<Character,List<String>> map = new TreeMap<>();
           map =     Arrays.stream(s.split("n"))
                .collect(Collectors.groupingBy(word->word.charAt(0)))
               .entrySet().stream()
                .filter(el->el.getValue().size()>1)
                 //  .map(el->el.)
                .collect(Collectors
                .toMap(e -> e.getKey(),e -> e.getValue()))
                ;
        return dictionary.entrySet().stream()
                .filter(el->el.getValue().size()>1)
                .collect(Collectors
                        .toMap(e -> e.getKey(),e -> e.getValue()));
    }


}


