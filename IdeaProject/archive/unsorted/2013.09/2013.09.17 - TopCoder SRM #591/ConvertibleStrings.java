package coding;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ConvertibleStrings {
   TreeMap<Character,Character> tm= new TreeMap<Character, Character>();
    public int leastRemovals(String A, String B) {
        int min=1000;
       List<String> kk= getPermutation("ABCDEFGHI");//ABCDEFGHI
        for (String s : kk) {
           int rem=0;
            for (int i = 0; i < A.length() ; i++) {
               if(B.charAt(i)!=s.charAt((int)A.charAt(i)-(int)'A'))rem++;
            }
            if(rem<min)min=rem;
        }

        return min;
    }



    public static List<String> getPermutation(String input) {

        List<String> collection = null;

        if (input.length() == 1) {
            collection = new ArrayList<String>();
            collection.add(input);
            return collection;
        } else {
            collection = getPermutation(input.substring(1));
            Character first = input.charAt(0);
            List<String> result = new ArrayList<String>();
            for (String str : collection) {
                for (int i = 0; i < str.length(); i++) {
                    String item = str.substring(0, i) + first
                            + str.substring(i);
                    result.add(item);
                }
                String item = str.concat(first.toString());
                result.add(item);
            }
            return result;
        }

    }

    /**
     * @param args
     */
    //Ex    public static void main(String[] args) {
    //        System.out.println(getPermutation("abc"));
    //        System.out.println(getPermutation("abc").get(1));
    //   }

}
