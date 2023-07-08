import model.ListToys;
import model.Toy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static LinkedList<Toy> listWinnerToys= new LinkedList<>();


    public static void main(String[] args) {

        startGame();

    }

    private static void startGame(){

        ListToys listToys = new ListToys();
        boolean n = true;
        while (n) {
            System.out.println(
                    "1. Добавить игрушку\n" +
                    "2. Розыгрыш игрушек\n" +
                    "3. Получить приз\n" +
                    "3. Выйти");

            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            switch (number) {
                case 1:
                    addToys(listToys);
                    break;
                case 2:
                    winToy(listToys);
                    break;
                case 3:
                    getWinnerToy(listToys);
                    break;
                case 4:
                    n = false;
                    break;
                default:
                    System.out.println("Выбор не распознан");
            }
        }
    }

    private static void addToys(ListToys listToys){

        Scanner in = new Scanner(System.in);
        System.out.println("Введите название игрушки:");
        String name = in.nextLine();
        System.out.println("Введите количество " + name + ":");
        int count = in.nextInt();

        listToys.addToy(name, count);
    }

    private static void winToy(ListToys listToys) {
        listWinnerToys.addLast(listToys.getWinnerToy());
    }

    private static void getWinnerToy(ListToys listToys) {
        Toy toy = listWinnerToys.getFirst();
        System.out.println(toy);
        listWinnerToys.removeFirst();
        addToyToFile(toy);
    }



    private static void addToyToFile(Toy toy) {
        try {

            FileWriter writer = new FileWriter(new File("file.txt"), true);

            writer.write(toy.toString());
            writer.write("\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи");
        }
    }
}