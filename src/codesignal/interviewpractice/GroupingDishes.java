package codesignal.interviewpractice;

import java.util.*;

public class GroupingDishes {

    public static void main(String[] args) {
        GroupingDishes s = new GroupingDishes();
        System.out.println(s.solution(new String[][]{{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"}, {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"}, {"Quesadilla", "Chicken", "Cheese", "Sauce"}, {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}}));
    }

    String[][] solution(String[][] dishes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String[] ingred : dishes) {
            for (int i = 1; i < ingred.length; i++) {
                map.computeIfAbsent(ingred[i], v -> new ArrayList<>()).add(ingred[0]);
            }
        }

        ArrayList<String[]> list = new ArrayList<>();
        map.forEach((ingred, foods) -> {
            if (foods.size() > 1) {
                Collections.sort(foods);
                String[] fin = new String[foods.size() + 1];
                fin[0] = ingred;
                for (int i = 0; i < foods.size(); i++) {
                    fin[i + 1] = foods.get(i);
                }
                list.add(fin);
            }
        });
        /**

           list.sort((a, b) -> {
            return a[0].compareTo(b[0]);
         });

         */
        list.sort(Comparator.comparing(a -> a[0]));
        return list.toArray(new String[0][0]);
    }


    String[][] solution3(String[][] dishes) {
        final Map<String, Set<String>> map = new TreeMap<>();

        for (String[] dish : dishes) {
            final String name = dish[0];
            for (int i = 1; i < dish.length; i++) {
                map.computeIfAbsent(dish[i], v -> new TreeSet<>()).add(name);
            }
        }

        return map.entrySet().stream().filter(e -> e.getValue().size() > 1).map(e -> {
            final String[] array = new String[e.getValue().size() + 1];
            array[0] = e.getKey();
            int offset = 1;
            for (String item : e.getValue()) {
                array[offset++] = item;
            }
            return array;
        }).toArray(String[][]::new);
    }
}
