import java.util.*;

public class Main {

    public static void main(String[] args) {

        String str1 = "bb";
        String str2 = "b";

        System.out.println("contains? "+str1.contains(str2));

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // remove if item is "A"
        list.removeIf("A"::equals);

        System.out.println("LIST: "+list);

        //Mixing.letterStatistics("A aaaa bb c");

        String s1 = "my&friend&Paul has heavy hats! &";
        String s2 = "my friend John has many many friends &";

        //System.out.println(Mixing.mix(s1, s2));

        //String[] s3 = {"aa", "bb", "h", "c"};
        String[] s3 = {"aa", "bb", "h", "cc"};
        //String[] s4 = {"aaa", "b", "hh", "cc", "ww"};
        String[] s4 = {"aaa", "b", "hh"};

        System.out.println(resultString(s3, s4));

        //remove(Arrays.asList(s3));

        /*
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("i: "+i);
                System.out.println("j: "+j);
            }
        }

        String str = "Java";
        str = str.substring(2);
        System.out.println(str);
        */

        //System.out.println(Arrays.toString("df:ui/op".split("[?:?/]")));
    }

    public static List<String> resultString(String[] s1, String[] s2) {

        List<String> resultList = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();

        List<String> listS1 = arrayToList(s1);
        List<String> listS2 = arrayToList(s2);
        System.out.println("listS1_e: "+listS1);
        System.out.println("listS2_e: "+listS2);

        Iterator<String> it1 = listS1.iterator();
        Iterator<String> it2 = listS2.iterator();


        /*
        for (int i = 0; i < listS1.size(); i++) {
            for (int j = 0; j < listS2.size(); j++) {
                System.out.println("listS1.size(): "+listS1.size());
                System.out.println("listS2.size(): "+listS2.size());
                if (hasSameCharacter(listS1.get(i), listS2.get(j))) {
                    if (listS1.get(i).length() > listS2.get(j).length()) {
                        resultList.add(listS1.get(i));
                        listS1.remove(listS1.get(i));
                        listS2.remove(listS2.get(j));
                        //i--;
                        //j--;
                        System.out.println("listS1_k: "+listS1);
                        System.out.println("listS2_k: "+listS2);
                    } else {
                        resultList.add(listS2.get(j));
                        listS2.remove(listS2.get(j));
                        listS1.remove(listS1.get(i));
                        //j--;
                        //i--;
                        System.out.println("listS1_k: "+listS1);
                        System.out.println("listS2_k: "+listS2);
                    }
                } else {

                }
            }


        }

        for (String e : listS1) {
            //for (String r : listS1) {
            System.out.println(e);
            System.out.println(listS2);
            System.out.println("----------");
                resultList.add(listS2.contains(e) ? "yes" : "no");
            //}
        }
        */
        for (String e : listS2) {
            //for (String r : listS1) {
            System.out.println(e);
            System.out.println(listS1);
            System.out.println("----------");
            resultList.add(listS1.contains(e) ? "yes" : "no");
            //}
        }

        System.out.println("listS1: "+listS1);
        System.out.println("listS2: "+listS2);
        System.out.println("resultList: "+resultList);

        return resultList;

    }

    public static boolean hasSameCharacter(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j) && Character.isLetter(s1.charAt(i)) && Character.isLetter(s2.charAt(i))){
                    return true;
                }
            }
        }
        return false;
    }

    public static void remove(List<String> list){
        // throws java.util.ConcurrentModificationException
        list.removeIf("aa"::equals);

        System.out.println(list);
    }

    public static List<String> arrayToList(String[] s){
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            resultList.add(s[i]);
        }
        return resultList;
    }

    public static boolean check(List<String> s1, List<String> s2){
        for (int k = 0; k < s1.size(); k++) {
            for (int m = 0; m < s2.size(); m++) {
                if (!hasSameCharacter(s1.get(k), s2.get(m))) {
                    return false;
                }
            }
        }
        return true;
    }
}
