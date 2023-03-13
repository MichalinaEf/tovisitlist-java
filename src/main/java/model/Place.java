package model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Place implements Serializable {

    public abstract String toCsv();

    private String title;
    private String country;

    public Place(String title, String country) {
        this.title = title;
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return title + " in " + country;
    }

    private String printInfo(){
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place that = (Place) o;
        return Objects.equals(title, that.title) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, country);
    }
}