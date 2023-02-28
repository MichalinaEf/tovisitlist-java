public class Place {

    private String title;
    private String city;
    private String country;
    private String category;
    private boolean unescoList;
    private boolean wonderOfTheWorld;

    public Place(String title, String city, String country, String category, boolean unescoList, boolean wonderOfTheWorld) {
        this.title = title;
        this.city = city;
        this.country = country;
        this.category = category;
        this.unescoList = unescoList;
        this.wonderOfTheWorld = wonderOfTheWorld;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isUnescoList() {
        return unescoList;
    }

    public void setUnescoList(boolean unescoList) {
        this.unescoList = unescoList;
    }

    public boolean isWonderOfTheWorld() {
        return wonderOfTheWorld;
    }

    public void setWonderOfTheWorld(boolean wonderOfTheWorld) {
        this.wonderOfTheWorld = wonderOfTheWorld;
    }



    @Override
    public String toString() {
        return title + " in " + city + ", " + country + ", category: " + category +
                placeAdditionalInfo(unescoList,wonderOfTheWorld);
    }

    private String placeAdditionalInfo(boolean unescoList, boolean wonderOfTheWorld){
        String printInfo = "";
        if(unescoList == true && wonderOfTheWorld == true){
            printInfo = " and it is listed on the UNESCO list and it is Wonder of the Wrold, it feels like MUST HAVE to visit!";
        } else if (unescoList==true && wonderOfTheWorld == false) {
            printInfo = " and it is listed on the UNESCO list, you should visit it!";
        } else if (unescoList==false && wonderOfTheWorld==true) {
            printInfo = " and it is Wonder of The World, how many of them have you already visited?";
        } else
            printInfo = "";
        return printInfo;
    }
}