package P12Arrays_More_Exercises;

import java.util.Scanner;

public class P05KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputLength = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int inputCounter = 0;
        int[] bestInputData = new int[4]; // 0 Element = input number; 1 element  = highestSeqOnesCounter; 2 Element = endSequenceIndex; 3 Element = Sum of input sequence
        int[] bestDnaArray = new int[inputLength];

        while (!input.equals("Clone them!")) {
            String[] inputArr = input.split("!+");
            int[] currentInputArr = new int[inputArr.length];
            for (int i = 0; i < currentInputArr.length; i++) {
                currentInputArr[i] = Integer.parseInt(inputArr[i]);
            }

            int seqOnesCounter = 0;
            boolean previousElementIsOne = false;
            int highestSeqOnesCounter = 0;
            int currentSum = 0;
            int endSequenceIndex = -1;

            inputCounter++;

            for (int i = 0; i < currentInputArr.length; i++) {
                if (currentInputArr[i] == 1) {
                    seqOnesCounter++;
                    previousElementIsOne = true;
                } else {
                    seqOnesCounter = 0;
                    previousElementIsOne = false;
                }

                if (seqOnesCounter > highestSeqOnesCounter) {
                    highestSeqOnesCounter = seqOnesCounter;
                    endSequenceIndex = i;
                }

                currentSum += currentInputArr[i];

            }

            if (highestSeqOnesCounter > bestInputData[1]) {
                bestInputData[0] = inputCounter;
                bestInputData[1] = highestSeqOnesCounter;
                bestInputData[2] = endSequenceIndex;
                bestInputData[3] = currentSum;
                bestDnaArray = currentInputArr;
            } else if (highestSeqOnesCounter == bestInputData[1]) {
                if ((endSequenceIndex - highestSeqOnesCounter + 1) < (bestInputData[2] - bestInputData[1] + 1)) {
                    bestInputData[0] = inputCounter;
                    bestInputData[1] = highestSeqOnesCounter;
                    bestInputData[2] = endSequenceIndex;
                    bestInputData[3] = currentSum;
                    bestDnaArray = currentInputArr;
                } else if ((endSequenceIndex - highestSeqOnesCounter + 1) == (bestInputData[2] - bestInputData[1] + 1)) {
                    if (currentSum > bestInputData[3]) {
                        bestInputData[0] = inputCounter;
                        bestInputData[1] = highestSeqOnesCounter;
                        bestInputData[2] = endSequenceIndex;
                        bestInputData[3] = currentSum;
                        bestDnaArray = currentInputArr;
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestInputData[0], bestInputData[3]);
        for (int i : bestDnaArray) {
            System.out.print(i + " ");
        }

    }
}
