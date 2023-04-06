package P12Arrays_More_Exercises;

import java.util.Scanner;

public class P04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputStrArr = scanner.nextLine().split(" ");
        int[] inputArr = new int[inputStrArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            inputArr[i] = Integer.parseInt(inputStrArr[i]);
        }
        // Най-важното в задачата е: да проверим итерирайки с цикъл по всеки елемент от входящия масив, като започнем с нулевия елемент и приключим с последния.
        // За всеки елемент, проверяваме в ляво от него, колко елемента с по-малка стойност има. На всеки такъв открит по-малък елемент, инкрементираме с единица
        //маскималната дължина за съответния елемент на входящия масив. За удачно съхранение на тези макс. дължини, можем да изпозлваме създадения масив len[],
        //който е с еднаква дължина като входящия.
        //Също така, необходимо е да запазим и кой е номера на индекса, който прешества индекса с максималната дължина
        int maxLength = 0;
        int lastIndex = -1;
        int[] len = new int[inputArr.length];
        int[] previous = new int[inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            len[i] = 1;
            previous[i] = -1;

            for (int j = 0; j < i; j++) {
                if(inputArr[j] < inputArr[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    previous[i] = j;
                }
            }

            if (len[i] > maxLength) {
                maxLength = len[i];
                lastIndex = i;
            }

        }

        int[] output = new int[maxLength];
        int nextIndex = lastIndex;
        int currentIndex = maxLength - 1;


        while (nextIndex != -1) {
            output[currentIndex] = inputArr[nextIndex];
            currentIndex--;
            nextIndex = previous[nextIndex];
        }

        for (int i : output) {
            System.out.print(i + " ");
        }

    }
}
