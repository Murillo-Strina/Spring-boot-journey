package AutomakerApp.automaker;

import java.awt.Color;

public class Car {
    private String model;
    private Color color;
    private Engine engine;
    private AutoMaker autoMaker;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public AutoMaker getAutoMaker() {
        return autoMaker;
    }

    public void setAutoMaker(AutoMaker autoMaker) {
        this.autoMaker = autoMaker;
    }

    public CarStatus startIgnition(Key key) {
        if (key.getAutoMaker() != this.autoMaker) {
            return new CarStatus("Invalid key!");
        }
        return new CarStatus("Car started! Engine: " + engine);
    }

}
