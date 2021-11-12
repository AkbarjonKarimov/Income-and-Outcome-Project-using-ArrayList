package com.akbar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutComeList {

    private String filename = "outcome.txt";

    private FileService fileService = new FileService();

    private ArrayList<Model> outcomeList = Utils.convertToJson(fileService.read(filename));

    public void addOutComeList(String description, double price) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        outcomeList.add(new Model(outcomeList.size() + 1, description, price, simpleDateFormat.format(new Date())));

        fileService.write(filename, Utils.convertToString(outcomeList));
    }

    public void printIncomeList(List<Model> list) {
        if (list == null) {
            System.out.println("You have " + outcomeList.size() + " items in your list");
            outcomeList.forEach(i -> System.out.println(String.format("%s,%s,%s,%s", i.getId(), i.getDescription(), i.getPrice(), i.getDate())));
        } else {
            System.out.println("You have " + list.size() + " items in your OutComeList");
            double sum = 0;

            for (Model i : outcomeList) {
                System.out.println(String.format("%s,%s,%s,%s", i.getId(), i.getDescription(), i.getPrice(), i.getDate()));

                sum += i.getPrice();
            }

            if (sum > 0) {
                System.out.println("Sum of incomes prices :" + sum);
            }
        }
    }

    public void modifyOutComeList(int id, String newDescription, double newPrice) {
        for (Model model : outcomeList) {
            if (model.getId() == id) {
                model.setDescription(newDescription);
                model.setPrice(newPrice);
            }
        }

        fileService.write(filename, Utils.convertToString(outcomeList));
    }

    public void removeOutComeList(int id) {
        for (int i = 0; i < outcomeList.size(); i++) {
            if (outcomeList.get(i).getId() == id) {
                outcomeList.remove(i);
            }
        }

        fileService.write(filename, Utils.convertToString(outcomeList));
    }

    public List<Model> find(String searchedDate) {
        List<Model> resultList = new ArrayList<>();

        for (Model model : outcomeList) {
            if (model.getDate().equals(searchedDate)) {
                resultList.add(model);
            }
        }
        return resultList;
    }
}
