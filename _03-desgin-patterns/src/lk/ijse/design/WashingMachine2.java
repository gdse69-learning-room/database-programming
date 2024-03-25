package lk.ijse.design;

public class WashingMachine2 {
    private static WashingMachine2 wm2; //1

    private WashingMachine2() { //2

    }

    public static WashingMachine2 getInstance() {   //3
        if(wm2 == null) {
            wm2 = new WashingMachine2();
        }
        return wm2;
    }

    void wash() {
        System.out.println("wash cloths");
    }
}
