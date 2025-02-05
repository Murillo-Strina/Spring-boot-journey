package AutomakerApp.automaker;

import java.awt.Color;

public class FordMustang extends Car {

    public FordMustang(Engine engine) {
        super(engine);
        setModel("Mustang GT");
        setColor(Color.BLACK);
        setAutoMaker(AutoMaker.FORD);
    }
}
