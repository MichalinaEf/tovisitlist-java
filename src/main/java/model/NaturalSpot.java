package model;

public class NaturalSpot extends Place{

    private boolean unescoList;
    private boolean naturalWonderOfTheWorld;

    public NaturalSpot(String title, String country, boolean unescoList, boolean naturalWonderOfTheWorld) {
        super(title, country);
        this.unescoList = unescoList;
        this.naturalWonderOfTheWorld = naturalWonderOfTheWorld;
    }

    public boolean isUnescoList() {
        return unescoList;
    }

    public void setUnescoList(boolean unescoList) {
        this.unescoList = unescoList;
    }

    public boolean isNaturalWonderOfTheWorld() {
        return naturalWonderOfTheWorld;
    }

    public void setNaturalWonderOfTheWorld(boolean naturalWonderOfTheWorld) {
        this.naturalWonderOfTheWorld = naturalWonderOfTheWorld;
    }


    @Override
    public String toString() {
        return getTitle() + " in " + getCountry() + printInfo(unescoList,naturalWonderOfTheWorld);
    }

    private String printInfo(boolean unescoList, boolean naturalWonderOfTheWorld) {
        String printInfo = "";
        if (unescoList && naturalWonderOfTheWorld) {
            printInfo = " . It is listed on the UNESCO list and it is Natural Wonder of the World, it seems to be your MUST HAVE to visit!";
        } else if (unescoList && !naturalWonderOfTheWorld) {
            printInfo = " and it is listed on the UNESCO list, you should visit it!";
        } else if (!unescoList && naturalWonderOfTheWorld) {
            printInfo = " and it is Natural Wonder of The World, how many of them have you already visited?";
        } else
            printInfo = "";
        return printInfo;
    }
}
