package model;

import java.util.Objects;

public class Monument extends Place{
    public static final String TYPE = "Monument";
        private boolean unescoList;
        private boolean wonderOfTheWorld;

        public Monument(String title, String country, boolean unescoList, boolean wonderOfTheWorld) {
            super(title, country);
            this.unescoList = unescoList;
            this.wonderOfTheWorld = wonderOfTheWorld;
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
    public String toCsv() {
            return (TYPE + ";" ) + getTitle()  +";"+ getCountry() +";" + unescoList +";" + wonderOfTheWorld + "";
        }

    @Override
        public String toString() {
            return getTitle() + " in " + getCountry() + printInfo(unescoList,wonderOfTheWorld);
        }

        private String printInfo(boolean unescoList, boolean wonderOfTheWorld) {
            String printInfo = "";
            if (unescoList && wonderOfTheWorld) {
                printInfo = ". It is listed on the UNESCO list and it is Wonder of the World, it seems to be your MUST HAVE to visit!";
            } else if (unescoList && !wonderOfTheWorld) {
                printInfo = " and it is listed on the UNESCO list, you should visit it!";
            } else if (!unescoList && wonderOfTheWorld) {
                printInfo = " and it is Wonder of The World, how many of them have you already visited?";
            } else
                printInfo = "";
            return printInfo;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monument that = (Monument) o;
        return unescoList == that.unescoList && wonderOfTheWorld == that.wonderOfTheWorld;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), unescoList, wonderOfTheWorld);
    }
}
