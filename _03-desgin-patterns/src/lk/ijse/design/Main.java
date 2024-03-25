package lk.ijse.design;

public class Main {
    public static void main(String[] args) {
        /*var wm1 = new WashingMachine();
        var wm2 = new WashingMachine();

        System.out.println("wm1 = " + wm1);
        System.out.println("wm2 = " + wm2);*/

//        new WashingMachine2();  // already WachineMachine2 constructor is private

        WashingMachine2 wm1 = WashingMachine2.getInstance();
        WashingMachine2 wm2 = WashingMachine2.getInstance();

        System.out.println("wm1 = " + wm1);
        System.out.println("wm2 = " + wm2);
    }
}
