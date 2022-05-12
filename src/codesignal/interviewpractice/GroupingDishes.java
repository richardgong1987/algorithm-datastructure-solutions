package codesignal.interviewpractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingDishes {


    String[][] solution(String[][] dishes) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String[] ingred : dishes) {
            for (int i = 1; i < ingred.length; i++) {
                if (map.containsKey(ingred[i])) {
                    ArrayList<String> foods = map.get(ingred[i]);
                    foods.add(ingred[0]);
                    map.put(ingred[i], foods);
                } else {
                    ArrayList<String> foods = new ArrayList<>();
                    foods.add(ingred[0]);
                    map.put(ingred[i], foods);
                }
            }
        }

        ArrayList<String[]> list = new ArrayList<>();
        for (String ingred : map.keySet()) {
            ArrayList<String> foods = map.get(ingred);
            if (foods.size() > 1) {
                Collections.sort(foods);
                String[] fin = new String[foods.size() + 1];
                fin[0] = ingred;
                for (int i = 0; i < foods.size(); i++)
                    fin[i + 1] = foods.get(i);
                list.add(fin);
            }
        }


        list.sort(Comparator.comparing(a -> a[0]));
        return list.toArray(new String[0][]);
    }

    String[][] solution2(String[][] dishes) {
        return Arrays.stream(dishes).
                flatMap(d -> Arrays.stream(d).skip(1).
                        map(i -> new AbstractMap.SimpleEntry(i, d[0]))).
                collect(Collectors.groupingBy(Map.Entry::getKey, TreeMap::new, Collectors.mapping(Map.Entry::getValue, Collectors.toList()))).entrySet().stream().filter(e -> e.getValue().size() > 1)
                .map(e -> Stream.concat(Stream.of(e.getKey()), e.getValue().stream().sorted()).toArray(String[]::new)).toArray(String[][]::new);
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
