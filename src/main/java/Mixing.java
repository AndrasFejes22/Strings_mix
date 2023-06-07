import java.util.*;
import java.util.stream.Collectors;

public class Mixing {

    public static String mix(String s1, String s2) {

        List<String> result = new ArrayList<>();

        s1 =leftOnlyLetters(s1);
        s2 =leftOnlyLetters(s2);


        char[] charS1 = s1.toCharArray();
        char[] charS2 = s2.toCharArray();

        Arrays.sort(charS1);
        Arrays.sort(charS2);


        System.out.println(charS1);
        Set<Character> charSet1 = convertArrayToSet(charS1);
        Set<Character> charSet2 = convertArrayToSet(charS2);

        charSet1.addAll(charSet2);


        //System.out.println(charS1);
        System.out.println(charSet1);

        for (Character character: charSet1){
            if(letterInAWord(s1, character) >1 || letterInAWord(s2, character) >1) {
                if (letterInAWord(s1, character) > letterInAWord(s2, character)) {
                    result.add("1:".concat(String.valueOf(character).repeat(letterInAWord(s1, character))));
                } else if (letterInAWord(s1, character) < letterInAWord(s2, character)) {
                    result.add("2:".concat(String.valueOf(character).repeat(letterInAWord(s2, character))));
                } else if (letterInAWord(s1, character) == letterInAWord(s2, character)) {
                    result.add("=:".concat(String.valueOf(character).repeat(letterInAWord(s1, character))));
                }
            }
        }

        //System.out.println("SB: "+stringBuilder);
        result.sort(myComparator);
        System.out.println("result: "+result);
        String joined = String.join("/", result);
        System.out.println("joined: "+joined);

        return joined;
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

    public static Set<Character> convertArrayToSet(char[] array) {
        Set<Character> set = new HashSet<>();
        for (char t : array) {
            set.add(t);
        }
        return set;
    }

    public static Comparator<String> myComparator = (String o1, String o2) -> {
        if(o1.length() == o2.length()) {
            return o1.compareTo(o2);
        }
        return Integer.compare(o2.length(),o1.length());
    };
}
