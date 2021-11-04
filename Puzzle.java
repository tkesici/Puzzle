/*
 *@author Tevfik Kesici
 *@since 04.10.2021
 *
 *
 **************** LinkedHashMap version ****************
 *
 */

import java.util.*;

public class Puzzle {
    public static void main(String[] args) throws Exception {
        Create create = new Create();
        Solve solve = new Solve();
        create.createFirst();
        create.createSecond();
        create.createOutput();
        solve.solve(create.getFirst(), create.getSecond(), create.getOutput());
        solve.check(create.getFirst(), create.getSecond(), create.getOutput());
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

    private LinkedHashMap firstMap = new LinkedHashMap();
    private LinkedHashMap secondMap = new LinkedHashMap();
    private LinkedHashMap outputMap = new LinkedHashMap();
    private LinkedHashMap allMap = new LinkedHashMap();
    private List allList = new ArrayList();
    private int firstInput;
    private int secondInput;
    private int outputInput;


    public void solve(String first, String second, String output) {
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

    public void fill(String first, String second, String output) {
        firstInput = 0;
        secondInput = 0;
        outputInput = 0;
        for (int i = 0; i < allMap.size(); i++) {
            allMap.replace(allList.get(i), (int) (Math.random() * 10));

        }
        for (int i = 0; i < first.length(); i++) {
            if (i == 0) {
                firstInput += (int) allMap.get((first.charAt(i))) * 100;
            }
            if (i == 1) {
                firstInput += (int) allMap.get((first.charAt(i))) * 10;
            }
            if (i == 2) {
                firstInput += (int) allMap.get((first.charAt(i)));
            }

        }
        for (int i = 0; i < second.length(); i++) {
            if (i == 0) {
                secondInput += (int) allMap.get((second.charAt(i))) * 100;
            }
            if (i == 1) {
                secondInput += (int) allMap.get((second.charAt(i))) * 10;
            }
            if (i == 2) {
                secondInput += (int) allMap.get((second.charAt(i)));
            }

        }
        for (int i = 0; i < output.length(); i++) {
            if (i == 0) {
                outputInput += (int) allMap.get((output.charAt(i))) * 100;
            }
            if (i == 1) {
                outputInput += (int) allMap.get((output.charAt(i))) * 10;
            }
            if (i == 2) {
                outputInput += (int) allMap.get((output.charAt(i)));
            }

        }

    }

    public void check(String first, String second, String output) {
        fill(first, second, output);
        System.out.print("searching...");
        while (!(firstInput + secondInput == outputInput)) {
            fill(first, second, output);
        }
        System.out.println("found!\n");
        System.out.println(first + ":    " + firstInput);
        System.out.println(second + ":    " + secondInput);
        System.out.println(output + ":    " + outputInput);
    }

    public void display() {
        System.out.println(allMap);
        System.out.println(firstMap);
        System.out.println(secondMap);
        System.out.println(outputMap);
        System.out.println("FIRST: " + firstInput);
        System.out.println("SECOND: " + secondInput);
        System.out.println("OUTPUT: " + outputInput);
    }
}
