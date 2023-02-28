public class ToVisitListControl {

    private static final int exit = 0;
    private static final int addNewPlace = 1;
    private static final int printYourToVisitList = 2;

    private DataReader dataReader = new DataReader();

    private ToVisitList toVisitList = new ToVisitList();

    public void controlLoop(){
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
            switch (option){
                case addNewPlace:
                    addNewPlace();
                    break;
                case printYourToVisitList:
                    printYourToVisitList();
                    break;
                case exit:
                    exit();
                    break;
                default:
                    System.out.println("Sorry, there is no option like this, please try again");
            }
        }
        while (option!=exit);
    }



    private void printOptions() {
        System.out.println("Please choose an option:");
        System.out.println(exit + " - to exit the program");
        System.out.println(addNewPlace + " - to add new place to your ToVisitList");
        System.out.println(printYourToVisitList + " - to see your ToVisitList and plan new journey :)");

    }

    private void addNewPlace() {
        Place place = dataReader.readAndAddPlace();
        toVisitList.addPlace(place);
    }

    private void printYourToVisitList() {
        toVisitList.printToVisitList();
    }


    private void exit() {
        System.out.println("See you soon!");
        dataReader.close();
    }
}