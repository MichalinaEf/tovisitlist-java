package io;

import model.City;
import model.Monument;
import model.NaturalSpot;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class DataReader {

    private Scanner sc = new Scanner(System.in);

    public void close(){
        sc.close();
    }

    public int getInt(){
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw e;
        }finally {
            sc.nextLine();
        }
    }

    public City readAndAddCity(){
        System.out.println("Title");
        String title = sc.nextLine();
        System.out.println("City");
        String city = sc.nextLine();
        System.out.println("Country");
        String country = sc.nextLine();
        System.out.println("Is it capital city? \n yes or no?");
        String capitalCityString = yesOrNoAnswer();
        boolean capital = stringToBoolean(capitalCityString);

        return new City(title, city, country,capital);
    }


    public Monument readAndAddMonument(){
        System.out.println("Title");
        String title = sc.nextLine();
        System.out.println("Country");
        String country = sc.nextLine();
        System.out.println("Is it on UNESCO list? \n yes or no");
        String unescoListString = yesOrNoAnswer();
        boolean unescoList = stringToBoolean(unescoListString);
        System.out.println("Is it Wonder of the World? \n yes or no");
        String wonderOfTheWorldString = yesOrNoAnswer();
        boolean wonderOfTheWorld = stringToBoolean(wonderOfTheWorldString);

        return new Monument (title,country,unescoList,wonderOfTheWorld);
    }

    public NaturalSpot readAndAddNaturalSpot(){
        System.out.println("Title");
        String title = sc.nextLine();
        System.out.println("Country");
        String country = sc.nextLine();
        System.out.println("Is it on UNESCO list? \n yes or no");
        String unescoListString = yesOrNoAnswer();
        boolean unescoList = stringToBoolean(unescoListString);
        System.out.println("Is it Natural Wonder of the World? \n yes or no");
        String naturalWonderOfTheWorldString = yesOrNoAnswer();
        boolean naturalWonderOfTheWorld = stringToBoolean(naturalWonderOfTheWorldString);

        return new NaturalSpot(title,country,unescoList,naturalWonderOfTheWorld);
    }

    private String yesOrNoAnswer() {
        String givenAnswer =sc.nextLine();
        String answer = givenAnswer.toLowerCase();
        while (!answer.equals("yes") && !answer.equals("no")) {
            System.out.println("type 'yes' or 'no'");
            answer = sc.nextLine();
            answer.toLowerCase(Locale.US);
        }
        return answer;
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