package app;

public class ToVisitListApp {
    private final static String appName = "model.ToVisitList v3.0";
    public static void main(String[] args) {

        System.out.println(appName);
        ToVisitListControl toVisitListControl = new ToVisitListControl();
        toVisitListControl.controlLoop();

    }


}