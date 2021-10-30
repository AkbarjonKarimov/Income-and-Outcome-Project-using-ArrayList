package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static IncomeList incomeList = new IncomeList();
    private static OutComeList outComeList = new OutComeList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printMenu();

        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    incomeList.printIncomeList(null);
                    break;
                case 2:
                    addIncomeList();
                    break;
                case 3:
                    modifyIncomeList();
                    break;
                case 4:
                    removeIncomeList();
                    break;
                case 5:
                    findIncomeList();
                    break;
                case 6:
                    outComeList.printIncomeList(null);
                    break;
                case 7:
                    addOutComeList();
                    break;
                case 8:
                    modifyOutComeList();
                    break;
                case 9:
                    removeOutComeList();
                    break;
                case 10:
                    findOutComeList();
                    break;
                default:
                    quit = true;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Press number");
        System.out.println("\t 0 - To print Menu");
        System.out.println("\t 1 - To print Income List");
        System.out.println("\t 2 - To add Income List");
        System.out.println("\t 3 - To modify Income List");
        System.out.println("\t 4 - To remove Income List");
        System.out.println("\t 5 - To find Income List");
        System.out.println("\t 6 - To print OutCome List");
        System.out.println("\t 7 - To add OutCome List");
        System.out.println("\t 8 - To modify OutCome List");
        System.out.println("\t 9 - To remove OutCome List");
        System.out.println("\t 10 - To find OutCome List");
        System.out.println("\t 11 - To exit application");
    }

    public static void addIncomeList() {
        System.out.println("Please enter the IncomeList Description and Price");
        incomeList.addIncomeList(scanner.nextLine(), scanner.nextDouble());

    }

    public static void addOutComeList(){
        System.out.println("Please enter the OutComeList Description and Price");
        outComeList.addOutComeList(scanner.nextLine(),scanner.nextDouble());
    }

    public static void modifyIncomeList() {
        System.out.println("Enter item id :");
        int id = scanner.nextInt();
        System.out.println("Enter replacement IncomeList description and price : ");
        scanner = new Scanner(System.in);
        incomeList.modifyIncomeList(id, scanner.nextLine(), scanner.nextDouble());
    }

    public static void modifyOutComeList(){
        System.out.println("Enter item id : ");
        int id = scanner.nextInt();
        System.out.println("Enter replacement OutComeList description and price");
        scanner = new Scanner(System.in);
        incomeList.modifyIncomeList(id,scanner.nextLine(),scanner.nextInt());
    }

    public static void removeIncomeList() {
        System.out.println("Enter id number : ");
        incomeList.removeIncomeList(scanner.nextInt());
    }

    public static void removeOutComeList(){
        System.out.println("Enter id number : ");
        outComeList.removeOutComeList(scanner.nextInt());
    }

    public static void findIncomeList() {
        System.out.println("Enter date (dd.mm.yyyy): ");
        String date = scanner.nextLine();
        List<Model> resultList = incomeList.find(date);
        incomeList.printIncomeList(resultList);
    }

    public static void findOutComeList(){
        System.out.println("Enter date (dd.MM.yy)");
        String date = scanner.nextLine();
        List<Model> resultList = outComeList.find(date);
        outComeList.printIncomeList(resultList);
    }
}


