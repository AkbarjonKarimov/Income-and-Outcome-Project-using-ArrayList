package com.company;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IncomeList {
    private ArrayList<Model> incomeList = new ArrayList();

    public void addIncomeList(String description,double price){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        incomeList.add(new Model(incomeList.size()+1,description,price,simpleDateFormat.format(new Date())));
    }


    public void printIncomeList(List<Model> list){
        if(list==null){
            System.out.println("You have "+incomeList.size()+" items in your IncomeList");
            incomeList.forEach(i-> System.out.println(String.format("%s,%s,%s,%s",i.getId(),i.getDescription(),i.getPrice(),i.getDate())));
        }else {
            System.out.println("You have "+list.size()+" items in your IncomeList");
            double sum = 0;

            for (Model i:incomeList){
                System.out.println(String.format("%s,%s,%s,%s,",i.getId(),i.getDescription(),i.getPrice(), i.getDate()));

                sum +=i.getPrice();
            }

            if(sum>0){
                System.out.println("Sum of incomes prices : "+sum);
            }
        }
    }

    public void modifyIncomeList(int id,String newDescription, double newPrice){
        for (Model model:incomeList){
            if(model.getId() == id){
                model.setDescription(newDescription);
                model.setPrice(newPrice);
            }
        }
    }

    public void removeIncomeList(int id){
        for (int i=0;i<incomeList.size();i++){
            if(incomeList.get(i).getId() == id){
                incomeList.remove(i);
            }
        }
    }

    public List<Model> find(String searchedDate){
        List<Model> resultList = new ArrayList<>();

        for (Model model:incomeList){
            if(model.getDate().equals(searchedDate)){
                resultList.add(model);
            }
        }
        return resultList;
    }


}
