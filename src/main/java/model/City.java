package model;

import java.lang.reflect.Type;
import java.util.Objects;

public class City extends Place{

    public static final String TYPE = "City";

    private String city;
    private boolean capital;

    public City(String title, String city, String country, boolean capital) {
        super(title, country);
        this.city = city;
        this.capital = capital;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }


    @Override
    public String toCsv() {
        return (TYPE + ";" ) + getTitle() +";" + city +";"+ getCountry() +";" + capital + "";
    }

    @Override
    public String toString() {
        return getTitle() + ", " + city + " " + printInfo(capital) + getCountry();
    }


    private String printInfo (boolean capital){
        String isCapital = "";
        if (capital){
            isCapital = ", the capital city of ";
        } else
            isCapital = " in ";
        return isCapital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        City city = (City) o;
        return Objects.equals(city, city.city) && capital == city.capital;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), city, capital);
    }
}
