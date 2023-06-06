import java.util.*;
import java.util.stream.Collectors;

public class Mixing {

    public static String mix(String s1, String s2) {

        StringBuilder sb = new StringBuilder();

        String string1 = letterStatistics(s1, "1");
        String string2 = letterStatistics(s2, "2");

        String[] st1 = string1.split("/");
        String[] st2 = string2.split("/");
        System.out.println("st1: "+ Arrays.toString(st1));
        System.out.println("st2: "+ Arrays.toString(st2));



        String result = resultString(st1, st2);

        //return sb.append(string1).append(string2).toString();
        return result;
    }

    public static String letterStatistics(String word, String n){

        word = leftOnlyLetters(word);
        List<Character> lettersInAWord = new ArrayList<>();

        int totalNumberOfLetters = 0;
        Map<Character, Integer> letterStatistics = new TreeMap<>();
        char[] lettersOfWord = word.toCharArray();
        for (char letter : lettersOfWord) {//char array
            totalNumberOfLetters++;
            if(letterStatistics.containsKey(letter)) {
                Integer count = letterStatistics.get(letter);
                count++;
                letterStatistics.put(letter, count);
            } else {
                letterStatistics.put(letter, 1);
            }

        }

        System.out.println("totalNumberOfLetters: " + totalNumberOfLetters);

        StringBuilder stringBuilder = new StringBuilder();

        Set<Map.Entry<Character, Integer>> entrySet = letterStatistics.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " --> " + entry.getValue() + " db");
            if(entry.getValue() > 1) {
                stringBuilder.append(n).append(":").append(String.valueOf(entry.getKey()).repeat(entry.getValue())).append("/");
            }
        }

        List<Map.Entry<Character, Integer>> collect = letterStatistics.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toList());

        letterStatistics.forEach((key, value) -> System.out.println("letter: "+ key + ", quantity: " + value));

        for(int i = 0; i < collect.size(); i++){
            lettersInAWord.add(collect.get(i).getKey());
        }

        System.out.println("lettersList: " + lettersInAWord);
        System.out.println("builder"+ n + ": " + stringBuilder);

        return stringBuilder.toString();
    }

    public static int letterInAWord(String word, Character n){
        int num = 0;
        word = leftOnlyLetters(word);
        List<Character> lettersInAWord = new ArrayList<>();

        int totalNumberOfLetters = 0;
        Map<Character, Integer> letterStatistics = new TreeMap<>();
        char[] lettersOfWord = word.toCharArray();
        for (char letter : lettersOfWord) {//char array
            totalNumberOfLetters++;
            if(letterStatistics.containsKey(letter)) {
                Integer count = letterStatistics.get(letter);
                count++;
                letterStatistics.put(letter, count);
            } else {
                letterStatistics.put(letter, 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = letterStatistics.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            //System.out.println(entry.getKey() + " --> " + entry.getValue() + " db");
            if(entry.getKey().equals(n)) {
                num = entry.getValue();
            }
        }


        return num;
    }

    public static boolean checkIfLoverCase(char c){
        return String.valueOf(c).equals(String.valueOf(c).toLowerCase());
    }

    public static String leftOnlyLetters(String text){
        text = text.replaceAll(" ", "");
        String[] temp = text.split("");
        //return Arrays.stream(temp).filter(a->a.equals(a.toLowerCase())).filter(a -> Character.isLetter(a.chars())).collect(Collectors.joining());
        return text.chars().filter(a-> a == Character.toLowerCase(a)).filter(Character::isLetter).collect(StringBuilder::new, StringBuilder::appendCodePoint,
                StringBuilder::append).toString();
    }

    public static String resultString(String[] s1, String[] s2) {

        List<String> listS1 = new ArrayList<String>(List.of(s1));
        List<String> listS2 = new ArrayList<String>(List.of(s1));

        Set<String> resultSet = new TreeSet<>();
        Iterator<String> S1iterator = listS1.iterator();
        Iterator<String> S2iterator = listS2.iterator();
        Iterator<String> iterator = resultSet.iterator();
        StringBuilder sb = new StringBuilder();
        System.out.println("math max: "+Math.max(s1.length, s2.length));
        for (int i = 0; i < Math.max(s1.length, s2.length); i++) {
            System.out.println("s1i: "+i +": "+s1[i]);
            for (int j = 0; j < Math.min(s1.length, s2.length); j++) {
                System.out.println("s2j: "+j +": "+s2[j]);
                if(hasSameCharacter(s1[i], s2[j])) {
                    if (s1[i].length() > s2[j].length()) {
                        resultSet.add(s1[i]);
                        resultSet.remove(s2[j]); //nem jó még benne sincs
                        sb.append(s1[i]);
                        System.out.println("set1: "+resultSet);
                        //break;
                    } else if (s1[i].length() < s2[j].length()){
                        sb.append(s2[j]);
                        resultSet.add(s2[j]);
                        resultSet.remove(s1[i]);
                        System.out.println("set2: "+resultSet);
                        //break;
                    } else if(s1[i].length() == s2[j].length()){
                        sb.append(s1[i]);
                        //resultSet.add(s1[i]);
                        resultSet.add(s2[j]);
                        System.out.println("set3: "+resultSet);
                        //break;
                    }
                    //break;
                } /*else {
                    sb.append(s1[i]);
                    sb.append(s2[j]);
                    resultSet.add(s1[i]);
                    resultSet.add(s2[j]);
                }*/


            }

        }
        System.out.println("set: "+resultSet);

        return sb.toString();
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
}
