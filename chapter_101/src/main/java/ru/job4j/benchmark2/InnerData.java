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

        HashMap<Character, Integer> numCharData1 = new HashMap<>();
        for (int i = 0; i < data1.length(); i++) {
            numCharData1.merge(data1.charAt(i), 1, (a, b) -> a + b);
        }

        boolean result = true;
        HashMap<Character, Integer> numCharData2 = new HashMap<>();
        for (int i = 0; i < data2.length(); i++) {
            Character currentChar = data2.charAt(i);
            numCharData2.merge(data2.charAt(i), 1, (a, b) -> a + b);
            if (numCharData1.getOrDefault(currentChar, 0) < numCharData2.get(currentChar)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
