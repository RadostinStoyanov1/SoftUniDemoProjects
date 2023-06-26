package P26MapsLambdaAndStreamAPI_Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materialsMap = new LinkedHashMap<>();
        materialsMap.put("shards", 0);
        materialsMap.put("fragments", 0);
        materialsMap.put("motes", 0);

        Map<String, Integer> junkMap = new LinkedHashMap<>();
        boolean isWin = false;

        while (!isWin) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");

            for (int i = 0; i < inputArr.length; i += 2) {
                int currentQuantity = Integer.parseInt(inputArr[i]);
                String currentMaterial = inputArr[i + 1].toLowerCase();

                if (currentMaterial.equals("shards") || currentMaterial.equals("fragments") || currentMaterial.equals("motes")) {
                    materialsMap.put(currentMaterial, materialsMap.get(currentMaterial) + currentQuantity);
                } else {
                    if (junkMap.containsKey(currentMaterial)) {
                        junkMap.put(currentMaterial, junkMap.get(currentMaterial) + currentQuantity);
                    } else {
                        junkMap.put(currentMaterial, currentQuantity);
                    }
                }

                if (materialsMap.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    materialsMap.put("shards", materialsMap.get("shards") - 250);
                    isWin = true;
                    break;
                } else if (materialsMap.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    materialsMap.put("fragments", materialsMap.get("fragments") - 250);
                    isWin = true;
                    break;
                } else if (materialsMap.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    materialsMap.put("motes", materialsMap.get("motes") - 250);
                    isWin = true;
                    break;
                }

            }

            if (isWin) {
                break;
            }

        }
        materialsMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        junkMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
