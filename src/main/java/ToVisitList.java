public class ToVisitList {

    private static final int maxNumberOfPlacesOnTheList = 1000;
    private Place[] places = new Place[maxNumberOfPlacesOnTheList];
    private int placesNumber;

    public void addPlace(Place place){
        if(placesNumber < maxNumberOfPlacesOnTheList){
            places[placesNumber] = place;
            placesNumber++;
        } else
            System.out.println("Sorry, no more space on your list, you should plan your trip now");
    }

    public void printToVisitList(){
        if(placesNumber == 0){
            System.out.println("You don't have any place to visit, you have to add something to your list!");
        }
        for (int i = 0; i < placesNumber; i++) {
            System.out.println(places[i].toString());
        }
    }
}