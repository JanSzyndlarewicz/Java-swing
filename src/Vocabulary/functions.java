package Vocabulary;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class functions {
    public static void wpisanie() throws IOException {
        FileWriter file = new FileWriter("Slowka.txt", true);
        BufferedWriter out = new BufferedWriter(file);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Słowo po polsku: ");
        String polski = scanner.nextLine();
        System.out.print("Słowo po angielsku: ");
        String angielski = scanner.nextLine();
        out.write(angielski + " - " + polski + '\n');
        out.close();
    }

    public static void printAll(){
        String polski, angielski;
        String wiersz_tekstu = null;
        String[] separator;
        File plik = new File("Slowka.txt");

        try (BufferedReader breader = new BufferedReader(new FileReader(plik))) {
            while( (wiersz_tekstu = breader.readLine() ) != null )
            {
                separator = wiersz_tekstu.split(" - ");
                angielski = separator[0];
                polski = separator[1];

                System.out.println(angielski + " - " + polski);
                Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int countLines(){

        int howManyLines = 0;

        File plik = new File("Slowka.txt");

        try (BufferedReader breader = new BufferedReader(new FileReader(plik))) {
            while( breader.readLine() != null )
            {
                howManyLines++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return howManyLines;
    }

    public static String[] getLine(int randomLine){
        File plik = new File("Slowka.txt");
        int licznik = 0;
        String wiersz_tekstu = null;
        String[] separator = null;


        try (BufferedReader breader = new BufferedReader(new FileReader(plik))) {
            while( (wiersz_tekstu = breader.readLine() ) != null  && licznik != randomLine)
            {
                separator = wiersz_tekstu.split(" - ");
                Thread.sleep(10);
                licznik++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return separator;
    }


    public static void losoweSlowko(){
        Random random = new Random();
        String polski = "", angielski = "";
        String[] tmp = null;

        tmp = getLine(random.nextInt(countLines())+1);
        angielski = tmp[0];
        polski = tmp[1];

        System.out.println(angielski + " - " + polski);
    }


    public static void losoweSlowkoPol(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String polski = "", angielski = "", odpowiedz = "";
        String[] tmp = null;

        tmp = getLine(random.nextInt(countLines())+1);
        angielski = tmp[0];
        polski = tmp[1];

        System.out.println(polski);
        odpowiedz = scanner.nextLine();

        if(angielski.equals(odpowiedz)){
            System.out.println("Dobrze!");
        }
        else{
            System.out.println("Źle, poprawna odpowiedź: " + angielski);
            do{
                System.out.print("Popraw się: ");
                odpowiedz = scanner.nextLine();
            }while(!angielski.equals(odpowiedz));
        }

    }


    public static void losoweSlowkoAng(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String polski = "", angielski = "", odpowiedz = "";
        String[] tmp = null;

        tmp = getLine(random.nextInt(countLines())+1);
        angielski = tmp[0];
        polski = tmp[1];

        System.out.println(angielski);
        odpowiedz = scanner.nextLine();

        if(polski.equals(odpowiedz)){
            System.out.println("Dobrze!");
        }
        else{
            System.out.println("Źle, poprawna odpowiedź: " + polski);
            System.out.print("Popraw się: ");
            scanner.nextLine();
        }
    }



    public static void menu(){
        System.out.println("0 - Stop");
        System.out.println("1 - Wypisz wszytkie");
        System.out.println("2 - Wpisz słówka");
        System.out.println("3 - Losowe słówko");
        System.out.println("4 - Tłumaczenie z polskiego na angielski");
        System.out.println("5 - Tłumaczenie z angielskiego na polski");
    }
}
