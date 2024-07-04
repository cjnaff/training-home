package drinks;

/*
Sealed Classes example
 */
public sealed class Beverage implements Consumable permits Coffee, Tea {

    private double temperature;

    public double getTemperature() {
        return this.temperature;
    }
    public void heatUp() {
        this.temperature = 200.5;
    }
    @Override
    public void consume() {
        System.out.println("Drinking my " + this.getClass().getSimpleName());
    }
}
