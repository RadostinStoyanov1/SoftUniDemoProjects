package P35ExamPreparation2;

import java.util.*;

public class P03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialNumPieces = Integer.parseInt(scanner.nextLine());

        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        for (int i = 1; i <= initialNumPieces; i++) {
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];

            piecesMap.putIfAbsent(piece, new ArrayList<>());
            piecesMap.get(piece).add(composer);
            piecesMap.get(piece).add(key);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {
            String action = command.split("\\|")[0];

            if (action.equals("Add")) {
                String piece = command.split("\\|")[1];
                String composer = command.split("\\|")[2];
                String key = command.split("\\|")[3];

                if (piecesMap.containsKey(piece)) {
                    System.out.printf("%s is already in the collection!%n", piece);
                } else {
                    piecesMap.put(piece, new ArrayList<>());
                    piecesMap.get(piece).add(composer);
                    piecesMap.get(piece).add(key);
                    System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
                }
            } else if (action.equals("Remove")) {
                String piece = command.split("\\|")[1];

                if (piecesMap.containsKey(piece)) {
                    piecesMap.remove(piece);
                    System.out.printf("Successfully removed %s!%n", piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }

            } else if (action.equals("ChangeKey")) {
                String piece = command.split("\\|")[1];
                String newKey = command.split("\\|")[2];

                if (piecesMap.containsKey(piece)) {
                    piecesMap.get(piece).set(1, newKey);
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : piecesMap.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
