package drinks;

public class makeDrinks {

    private static final Coffee myCoffee;
    private static final Tea myTea;
    private static final Beverage drink;


  static {
       myCoffee = new Coffee();
       myTea = new Tea();
       drink = new Beverage();
  }

    public static void main(String[] args) {
/*        Coffee myCoffee = new Coffee();
        Tea myTea = new Tea();
        Beverage drink = new Beverage();*/
        enjoyConsumable(myCoffee);
        enjoyConsumable(myTea);
        enjoyConsumable(drink);
    }

    public static void enjoyConsumable(Consumable consumable) {
        // Pattern matching switch statement
        switch (consumable) {
            case Coffee c -> c.addCream();
            case Tea t -> t.stir();
            default -> System.out.println("Ready to go");
        }
        consumable.consume();
    }
}
