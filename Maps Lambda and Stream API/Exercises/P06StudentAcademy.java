package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numStudents = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Double>> studentsMap = new LinkedHashMap<>();

        for (int i = 1; i <= numStudents; i++) {
            String currentName = scanner.nextLine();
            double currentGrade = Double.parseDouble(scanner.nextLine());

            if (!studentsMap.containsKey(currentName)) {
                studentsMap.put(currentName, new ArrayList<>());
            }
            studentsMap = addElementInListMap(studentsMap, currentName, currentGrade);
        }

        Map<String, ArrayList<Double>> filteredStudentsMap = new LinkedHashMap<>();

        for (Map.Entry<String, ArrayList<Double>> entry : studentsMap.entrySet()) {
            if (entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.50) {
                filteredStudentsMap.put(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<String, ArrayList<Double>> entry : filteredStudentsMap.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble());
        }

    }

    private static Map<String, ArrayList<Double>> addElementInListMap(Map<String, ArrayList<Double>> studentsMap, String currentName, double currentGrade) {
        studentsMap.get(currentName).add(currentGrade);
        return studentsMap;
    }

}
