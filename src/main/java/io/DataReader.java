package io;

import model.City;
import model.Monument;
import model.NaturalSpot;

import java.util.Scanner;

public class DataReader {

    private Scanner sc = new Scanner(System.in);

    public void close(){
        sc.close();
    }

    public int getInt(){
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }

    public City readAndAddCity(){
        System.out.println("Title");
        String title = sc.nextLine();
        System.out.println("City");
        String city = sc.nextLine();
        System.out.println("Country");
        String country = sc.nextLine();
        System.out.println("Is it capital city? \n yes or no");
        String capitalCityString = sc.nextLine();
        boolean capital = stringToBoolean(capitalCityString);

        return new City(title, city, country,capital);
    }


    public Monument readAndAddMonument(){
        System.out.println("Title");
        String title = sc.nextLine();
        System.out.println("City");
        String city = sc.nextLine();
        System.out.println("Country");
        String country = sc.nextLine();
        System.out.println("Is it on UNESCO list? \n yes or no");
        String unescoListString = sc.nextLine();
        boolean unescoList = stringToBoolean(unescoListString);
        System.out.println("Is it Wonder of the World? \n yes or no");
        String wonderOfTheWorldString = sc.nextLine();
        boolean wonderOfTheWorld = stringToBoolean(wonderOfTheWorldString);

        return new Monument (title,country,unescoList,wonderOfTheWorld);
    }

    public NaturalSpot readAndAddNature(){
        System.out.println("Title");
        String title = sc.nextLine();
        System.out.println("Country");
        String country = sc.nextLine();
        System.out.println("Is it on UNESCO list? \n yes or no");
        String unescoListString = sc.nextLine();
        boolean unescoList = stringToBoolean(unescoListString);
        System.out.println("Is it Natural Wonder of the World? \n yes or no");
        String naturalWonderOfTheWorldString = sc.nextLine();
        boolean naturalWonderOfTheWorld = stringToBoolean(naturalWonderOfTheWorldString);

        return new NaturalSpot(title,country,unescoList,naturalWonderOfTheWorld);
    }

    private boolean stringToBoolean (String receivedData) {
        boolean result = false;
        if(receivedData.equals("yes")){
            result=true;
        } else if (receivedData.equals("no")){
            result=false;
        }
        return result;
    }
}