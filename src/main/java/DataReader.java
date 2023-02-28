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

    public Place readAndAddPlace(){
        System.out.println("Title");
        String title = sc.nextLine();
        System.out.println("City");
        String city = sc.nextLine();
        System.out.println("Country");
        String country = sc.nextLine();
        System.out.println("Category");
        String category = sc.nextLine();
        System.out.println("Is it on UNESCO list? \n yes or no");
        String unescoListString = sc.nextLine();
        boolean unescoList = stringToBoolean(unescoListString);
        System.out.println("Is it Woder of the World? \n yes or no");
        String wonderOfTheWorldString = sc.nextLine();
        boolean wonderOfTheWorld = stringToBoolean(wonderOfTheWorldString);

        return new Place (title,city,country,category,unescoList,wonderOfTheWorld);
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