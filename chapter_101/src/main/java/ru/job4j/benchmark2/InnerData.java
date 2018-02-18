package ru.job4j.benchmark2;

import java.util.HashMap;

/**
 * Class ru.job4j.benchmark2.
 *
 * @author edzabarov
 * @since 18.02.2018
 */
public class InnerData {

    public boolean cheсkData(String data1, String data2) {
        if(data1.length() != data2.length()) return false;
        HashMap<Character, MyInteger> numCharData1 = readWord(data1);
        HashMap<Character, MyInteger> numCharData2 = readWord(data2);
        boolean result = true;
        for (Character key : numCharData1.keySet()) {
            if (!numCharData1.get(key).equals(numCharData2.get(key))) {
                result = false;
                break;
            }
        }
        return result;
    }

    private HashMap<Character, MyInteger> readWord(String value) {
        HashMap<Character, MyInteger> result = new HashMap<>();
        for (int i = 0; i < value.length(); i++) {
            char currentChar = value.charAt(i);
            MyInteger numChar = result.get(currentChar);
            if (numChar == null) {
                result.put(currentChar, new MyInteger(1));
            } else {
                numChar.iterate();
            }
        }
        return result;
    }
}
