package com.prac2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws ParseException {
        System.out.println("Task 1");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println();

	    System.out.println("Task 2");
        System.out.println(spiderVsFly("E1", "E4"));
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "B2"));
        System.out.println(spiderVsFly("A4", "C2"));
        System.out.println(spiderVsFly("A4", "E2"));
        System.out.println(spiderVsFly("A1", "G1"));
        System.out.println(spiderVsFly("F2", "H2"));
        System.out.println(spiderVsFly("A1", "H2"));
        System.out.println(spiderVsFly("A1", "G2"));
        System.out.println(spiderVsFly("G4", "H1"));
        System.out.println(spiderVsFly("E1", "D3"));
        System.out.println(spiderVsFly("E1", "C3"));
        System.out.println(spiderVsFly("A2", "H3"));
        System.out.println(spiderVsFly("B2", "D4"));
        System.out.println(spiderVsFly("B4", "F2"));
        System.out.println(spiderVsFly("H3", "D4"));
        System.out.println();

        System.out.println("Task 3");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(1289396387328L));
        System.out.println();

        System.out.println("Task 4");
        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println();

        System.out.println("Task 5");
        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15}));
        System.out.println(longestRun(new int[]{5, 4, 2, 1}));
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));
        System.out.println();

        System.out.println("Task 6");
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));
        System.out.println();

        System.out.println("Task 7");
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(rearrange("the4 t3o man5 Happ1iest of6 no7 birt2hday steel8!"));
        System.out.println(rearrange("is2 Thi1s T4est 3a"));
        System.out.println(rearrange("4of Fo1r pe6ople g3ood th5e the2"));
        System.out.println(rearrange(""));
        System.out.println();

        System.out.println("Task 8");
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));
        System.out.println();

        System.out.println("Task 9");
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println();

        System.out.println("Task 10");
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));
        System.out.println();
    }

    public static boolean sameLetterPattern(String s1, String s2){
        if (s1.length() != s2.length()) {return false;}

        for (int i = 0; i < s1.length() - 1; i++){
            if (((int)s1.charAt(i + 1) - (int)s1.charAt(i)) != ((int)s2.charAt(i + 1) - (int)s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // Task 2

    public static Integer cycle(Integer source){
        if (source > 7) {
            return source - 8;
        } else if (source < 0){
            return  source + 8;
        }
        return source;
    }

    public static ArrayList<Integer> convertCoord(String stringCoord){
        String radialsStr = "ABCDEFGH";
        ArrayList<Integer> result = new ArrayList<>();
        result.add(radialsStr.indexOf(stringCoord.charAt(0)));
        result.add(Character.getNumericValue(stringCoord.charAt(1)));
        return result;
    }

    public static String convertCoord(ArrayList<Integer> coord){
        String radialsStr = "ABCDEFGH";
        return Character.toString(radialsStr.charAt(coord.get(0))) + coord.get(1);
    }

    public static Integer distance(Integer firstPoint, Integer secondPoint){
        for (int i = 0; i <= 7; i++){
            if (cycle(firstPoint + i).equals(secondPoint)) {
                return i;
            } else if (cycle(firstPoint - i).equals(secondPoint)) {
                return i;
            }
        }
        return 0;
    }


    public static String spiderVsFly(String spiderCoord, String flyCoord) {
        ArrayList<Integer> spiderCoordC = convertCoord(spiderCoord);
        ArrayList<Integer> flyCoordC = convertCoord(flyCoord);
        ArrayList<ArrayList<Integer>> path = new ArrayList<ArrayList<Integer>>(){{add(new ArrayList<>(spiderCoordC));}};

        while (!spiderCoordC.equals(flyCoordC)){
            if (distance(spiderCoordC.get(0), flyCoordC.get(0)) >= 3) {
                while (!spiderCoordC.equals(new ArrayList<Integer>(){{add(spiderCoordC.get(0)); add(1);}})) {
                    spiderCoordC.set(1, spiderCoordC.get(1) - 1);
                    path.add(new ArrayList<>(spiderCoordC));
                }
                spiderCoordC.set(0, 0);
                spiderCoordC.set(1, 0);
                path.add(new ArrayList<>(spiderCoordC));
                if (flyCoordC.get(1) == 0){
                    break;
                }
                spiderCoordC.set(0, flyCoordC.get(0));
                spiderCoordC.set(1, 1);
                path.add(new ArrayList<>(spiderCoordC));
            }

            if (flyCoordC.get(1) < spiderCoordC.get(1)){
                spiderCoordC.set(1, spiderCoordC.get(1) - 1);
                path.add(new ArrayList<>(spiderCoordC));
            } else if (flyCoordC.get(1) >= spiderCoordC.get(1) && !flyCoordC.get(0).equals(spiderCoordC.get(0))){
                if (distance(spiderCoordC.get(0) + 1, flyCoordC.get(0)) < distance(spiderCoordC.get(0) - 1, flyCoordC.get(0))){
                    spiderCoordC.set(0, cycle(spiderCoordC.get(0) + 1));
                } else {
                    spiderCoordC.set(0, cycle(spiderCoordC.get(0) - 1));
                }
                path.add(new ArrayList<>(spiderCoordC));
            } else if (flyCoordC.get(1) > spiderCoordC.get(1)){
                spiderCoordC.set(1, spiderCoordC.get(1) + 1);
                path.add(new ArrayList<>(spiderCoordC));
            }
        }

        String result = "";
        for (ArrayList<Integer> coord : path){
            result += convertCoord(coord) + "-";
        }
        result = result.substring(0, result.lastIndexOf("-"));

        return result;
    }

    // Task 2 END

    public static int digitsCount(long number){
        if (number / 10 == 0) {
            return 1;
        } else {
            return 1 + digitsCount(number / 10);
        }
    }

    // Task 4

    public static HashMap<Character, Integer> countChars(String s){
        HashMap<Character, Integer> result = new HashMap<>();
        for (Character ch : s.toCharArray()){
            if (!result.containsKey(ch)){
                result.put(ch, 1);
            } else {
                result.put(ch, result.get(ch) + 1);
            }
        }
        return result;
    }

    public static int totalPoints(String[] words, String answer){
        HashMap<Character, Integer> wordCharsCount;
        HashMap<Character, Integer> answerCharsCount = countChars(answer);

        int result = 0;

        boolean checkWord;
        for (String word: words){
            checkWord = true;
            wordCharsCount = countChars(word);
            for (Map.Entry<Character, Integer> entry : wordCharsCount.entrySet()){
                if (!answerCharsCount.containsKey(entry.getKey()) || entry.getValue() > answerCharsCount.get(entry.getKey())){
                    checkWord = false;
                    break;
                }
            }
            if (checkWord){
                switch (word.length())  {
                    case 3:
                        result += 1;
                        break;
                    case 4:
                        result += 2;
                        break;
                    case 5:
                        result += 3;
                        break;
                    case 6:
                        result += 54;
                        break;
                    default:
                        break;
                }
            }
        }
        return result;
    }

    // Task 4 END

    public static int longestRun(int[] numbers){
        int result = 1;
        int tempRes = 1;
        int lastDiff = numbers[1] - numbers[0];
        if (lastDiff == 1 || lastDiff == -1) {
            tempRes += 1;
        }
        int currentDiff;
        for (int i = 2; i < numbers.length; i++){
            currentDiff = numbers[i] - numbers[i - 1];
            if (Math.abs(currentDiff) != 1){
                if (tempRes > result){
                    result = tempRes;
                }
                tempRes = 1;
            }

            if (currentDiff == lastDiff && Math.abs(currentDiff) == 1){
                tempRes += 1;
            } else if (currentDiff != lastDiff && Math.abs(currentDiff) == 1){
                tempRes = 2;
            }

            lastDiff = currentDiff;
            if (tempRes > result){
                result = tempRes;
            }
        }
        return result;
    }

    public static String takeDownAverage(String[] marks){
        int sum = 0;
        for (String mark: marks){
            mark = mark.replace("%", "");
            sum += Integer.parseInt(mark);
        }
        double average = (double) sum / marks.length;
        return Math.round(average - (marks.length + 1) * 5) + "%";
    }

    public static String rearrange(String text){
        Pattern pattern = Pattern.compile("(\\d)");

        Matcher matcher;
        int number;
        String[] words = text.trim().split(" ");
        if (text.trim().equals("")) {
            return "";
        }
        String[] resWords = new String[words.length];
        for (String word: words){
            matcher = pattern.matcher(word);
            if (matcher.find()){
                number = Integer.parseInt(matcher.group(0));
                resWords[number - 1] = word.replace(Integer.toString(number), "");
            }
        }
        return String.join(" ", resWords);
    }

    public static Integer max(ArrayList<Integer> numbers){
        int value = numbers.get(0);
        for (int number: numbers){
            if (number > value){
                value = number;
            }
        }
        return value;
    }

    public static ArrayList<Integer> intToArrayInt(int number){
        String s = Integer.toString(number);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            result.add(Character.getNumericValue(s.charAt(i)));
        }
        return result;
    }

    public static int maxPossible(int n1, int n2){
        ArrayList<Integer> a1 = intToArrayInt(n1);
        ArrayList<Integer> a2 = intToArrayInt(n2);
        String result = "";

        for (int i = 0; i < a1.size(); i++){
            if (a2.size() > 0 && max(a2) > a1.get(i)){
                a1.set(i, max(a2));
                a2.remove(max(a2));
            }
            result += a1.get(i).toString();
        }
        return Integer.parseInt(result);
    }

    public static String timeDifference(String cityA, String date, String cityB) throws ParseException {
        HashMap<String, Double> cities = new HashMap<String, Double>(){{
            put("Los Angeles", -8.0);
            put("New York", -5.0);
            put("Caracas", -4.5);
            put("Buenos Aires", -3.0);
            put("London", 0.0);
            put("Rome", 1.0);
            put("Moscow", 3.0);
            put("Tehran", 3.5);
            put("New Delhi", 5.5);
            put("Beijing", 8.0);
            put("Canberra", 10.0);
        }};

        SimpleDateFormat parser = new SimpleDateFormat("MMMM dd, yyyy HH:mm", Locale.US);
        Date newDate = parser.parse(date);
        long ts = (long) ((cities.get(cityB) - cities.get(cityA)) * 60 * 60 * 1000);
        newDate.setTime(newDate.getTime() + ts);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-d HH:mm");
        return formatter.format(newDate);
    }

    public static boolean isNew(int n){
        ArrayList<Integer> a = intToArrayInt(n);
        for (int i = 0; i < a.size(); i++){
            for (int j = i + 1; j < a.size(); j++){
                if (a.get(j) < a.get(i) && (i > 0 && a.get(j) != 0)){
                    return false;
                }
            }
        }
        return true;
    }
}
