package model;

import java.util.Objects;

public class NaturalSpot extends Place{
    public static final String TYPE = "Natural Spot";

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
    public String toCsv() {
        return (TYPE + ";" ) + getTitle()  +";"+ getCountry() +";" + unescoList +";" + naturalWonderOfTheWorld + "";
    }

    @Override
    public String toString() {
        return getTitle() + " in " + getCountry() + printInfo(unescoList,naturalWonderOfTheWorld);
    }

    private String printInfo(boolean unescoList, boolean naturalWonderOfTheWorld) {
        String printInfo = "";
        if (unescoList && naturalWonderOfTheWorld) {
            printInfo = ". It is listed on the UNESCO list and it is Natural Wonder of the World, it seems to be your MUST HAVE to visit!";
        } else if (unescoList && !naturalWonderOfTheWorld) {
            printInfo = " and it is listed on the UNESCO list, you should visit it!";
        } else if (!unescoList && naturalWonderOfTheWorld) {
            printInfo = " and it is Natural Wonder of The World, how many of them have you already visited?";
        } else
            printInfo = "";
        return printInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NaturalSpot that = (NaturalSpot) o;
        return unescoList == that.unescoList && naturalWonderOfTheWorld == that.naturalWonderOfTheWorld;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unescoList, naturalWonderOfTheWorld);
    }
}
