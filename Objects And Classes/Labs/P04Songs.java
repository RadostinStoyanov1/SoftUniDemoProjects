package P22ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04Songs {

    static class Song { //Създаваме класа Song
        String typeList; // Вкарваме параметрите на класа...
        String name;
        String time;

        public Song (String typeList, String name, String time) { //построяваме конструктора на класа
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return this.name;
        }

        public String getTypeList() {
            return this.typeList;
        }

    }

    public static void main(String[] args) { //започва основния (мейн) метод
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songsList = new ArrayList<>(); //създаваме списък с променливи от новосъздадения тип Song, където в един индекс на списъка ще запазваме парамтрите на всяка отделна песен. Всяка една песен (обект Song) ще притежава трите полета на класа Song, но ще се запазва под индекс в списъка от тип Song.
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] inputSongArr = input.split("_"); //създаваме масив с 3-те елемента на песента
            String typeListFromInput = inputSongArr[0];
            String nameFromInput = inputSongArr[1];
            String timeFromInput = inputSongArr[2];

            Song currentSong = new Song(typeListFromInput, nameFromInput, timeFromInput); //създаваме обект - в който пазим параметрите на всяка въведена песен

            songsList.add(currentSong); //добавяме всеки обект Song в списъка от тип Song
        }

        String command = scanner.nextLine();
        List<Song> filterSong = songsList.stream().filter(e -> e.getTypeList().equals(command)).collect(Collectors.toList());

        if (command.equals("all")) {
            for (Song item : songsList) {
                System.out.println(item.getName());
            }
        } else {
            for (Song song : songsList) {
                if(song.getTypeList().equals(command)) {
                    System.out.println(song.getName());
                }
            }
        }

    }
}
