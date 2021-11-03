/*
 *@author Tevfik Kesici
 *@since 03.10.2021
 *
 * Puzzle with LinkedHashMap
 */

import java.util.*;
import java.util.HashMap;

public class Puzzle {
    public static void main(String[] args) throws Exception {
        Create create = new Create();
        Solve solve = new Solve();
        create.createFirst();
        create.createSecond();
        create.createOutput();
        solve.Solve(create.getFirst(), create.getSecond(), create.getOutput());
        //solve.check(create.getFirst(),create.getSecond(),create.getOutput());
        solve.display();

    }
}

class Create {
    Scanner sc = new Scanner(System.in);

    private String first;
    private String second;
    private String output;

    public String createFirst() throws Exception {
        System.out.print("Enter 1st input value: ");
        first = sc.nextLine();
        if (!(first.length() >= 2 && first.length() <= 6)) {
            throw new IllegalArgumentException
                    ("The length of input must be greater than or equal " +
                            "to 2 or less than or equal to 6.");
        }
        return first;
    }

    public String createSecond() throws Exception {
        System.out.print("Enter 2nd input value: ");
        second = sc.nextLine();
        if (!(second.length() >= 2 && second.length() <= 6)) {
            throw new IllegalArgumentException
                    ("The length of input must be greater than or equal " +
                            "to 2 or less than or equal to 6.");
        }
        return second;
    }

    public String createOutput() throws Exception {
        System.out.print("Enter Output value:    ");
        output = sc.nextLine();
        return output;
    }

    public String getFirst() {
        return this.first;
    }

    public String getSecond() {
        return this.second;
    }

    public String getOutput() {
        return this.output;
    }

}

class Solve {

    LinkedHashMap firstMap = new LinkedHashMap();
    LinkedHashMap secondMap = new LinkedHashMap();
    LinkedHashMap outputMap = new LinkedHashMap();
    LinkedHashMap allMap = new LinkedHashMap();
    List allList = new ArrayList();
    String firstInput = "";
    String secondInput = "";
    String outputInput = "";


    public void Solve(String first, String second, String output) {
        for (int i = 0; i < first.length(); i++) {
            if (!(firstMap.containsKey(first.charAt(i)))) {
                firstMap.put(first.charAt(i), null);
                allMap.put(first.charAt(i), null);
                if (!(allList.contains(first.charAt(i)))) {
                    allList.add(first.charAt(i));
                }

            }
        }
        for (int i = 0; i < second.length(); i++) {
            if (!(secondMap.containsKey(second.charAt(i)))) {
                secondMap.put(second.charAt(i), null);
                allMap.put(second.charAt(i), null);
                if (!(allList.contains(second.charAt(i)))) {
                    allList.add(second.charAt(i));
                }

            }
        }
        for (int i = 0; i < output.length(); i++) {
            if (!(outputMap.containsKey(output.charAt(i)))) {
                outputMap.put(output.charAt(i), null);
                allMap.put(output.charAt(i), null);
                if (!(allList.contains(output.charAt(i)))) {
                    allList.add(output.charAt(i));
                }

            }
        }

    }

    public void Fill(String first, String second, String output) {
        for (int i = 0; i < allMap.size(); i++) {
            allMap.replace(allList.get(i), (int) (Math.random() * 10));

        }
        for (int i = 0; i < first.length(); i++) {
            firstInput += allMap.get(first.charAt(i));
        }
        for (int i = 0; i < second.length(); i++) {
            secondInput += allMap.get(second.charAt(i));

        }
        for (int i = 0; i < output.length(); i++) {
            outputInput += allMap.get(output.charAt(i));

        }

    }

    public void check(String first, String second, String output) {
        Fill(first, second, output);
        boolean check = Integer.valueOf(firstInput) +
                Integer.valueOf(secondInput) == Integer.valueOf(outputInput);
        while (check == false) {
            Fill(first, second, output);
            System.out.println("false");
            System.out.println(Integer.valueOf(firstInput));
        }

    }

    public void display() {
        System.out.println(allMap);
        System.out.println("FIRST: " + Integer.valueOf(firstInput));
        System.out.println("SECOND: " + Integer.valueOf(secondInput));
        System.out.println("OUTPUT: " + Integer.valueOf(outputInput));
    }

    public HashMap<Character, Integer> getFirstMap() {
        return firstMap;
    }

    public HashMap<Character, Integer> getSecondMap() {
        return secondMap;
    }

    public HashMap<Character, Integer> getOutputMap() {
        return outputMap;
    }

    public HashMap<Character, Integer> getAllMap() {
        return allMap;
    }


}
