package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FI {
    public static void main(String[] args) {
        String[] numbers = {
                "1. Task",
                "2. Task",
                "11. Task"
        };
        Comparator<Attachment> myComparator = (left, right) -> {
            String leftName = left.getName();
            String rightName = right.getName();
            System.out.printf("compare - %s %s\n", leftName, rightName);
            int first = Integer.parseInt(leftName.substring(0, leftName.indexOf('.')));
            int second = Integer.parseInt(rightName.substring(0, rightName.indexOf('.')));
            return second - first;
        };
        ArrayList<Attachment> attachments = new ArrayList<>();
        for (String number : numbers) {
            attachments.add(new Attachment(number, number.length()));
        }

        //Results
        attachments.sort(myComparator);
        attachments.forEach(el -> System.out.println(el.getName()));
    }
}
