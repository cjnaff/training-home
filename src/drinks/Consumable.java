package drinks;

public sealed interface Consumable permits Beverage {

    public void consume() ;

}
