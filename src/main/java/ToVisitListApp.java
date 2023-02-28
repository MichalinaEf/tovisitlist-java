public class ToVisitListApp {

    public static void main(String[] args) {

        final String appName = "ToVisitList v0.3";

        System.out.println(appName);
        ToVisitListControl toVisitListControl = new ToVisitListControl();
        toVisitListControl.controlLoop();

    }
}