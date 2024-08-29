/*
22. D. The code compiles and runs without issue, making option E incorrect. The Child
class overrides the setName () method and hides the static name variable defined in
the inherited Person class. Since variables are only hidden, not overridden, there are two
distinct name variables accessible, depending on the location and reference type. Line 8
creates a Child instance, which is implicitly cast to a Person reference type on line 9. Line
10 uses the Child reference type, updating Child. name to Elysia. Line 11 uses the Person
reference type, updating Person. name to Sophia. Lines 12 and 13 both call the overridden
setName() instance method declared on line 6. This sets Child. name to Webby on line
12 and then to Olivia on line 13. The final values of Child. name and Person. name are
Olivia and Sophia, respectively, making option D the correct answer.
 */



public class StaticInheritanceTest {
    static String name;
    void setName(String q) {name = q;}
     public class ChildClass extends StaticInheritanceTest {
        static String name;
        void setName(String w) {name = w;}
        public void main (String[] p) {
/*            final ChildClass ch = new ChildClass();
            final StaticInheritanceTest t = ch;
            ch.name = "Elysia";  System.out.println("Child: " + ch.name + " " + t.name);
            t.name = "Sophia";  System.out.println("Child: " + ch.name + " " + t.name);
            ch.setName("Webby");  System.out.println("Child: " + ch.name + " " + t.name);
            t.setName("Olivia");
            System.out.println("Child: " + ch.name + " " + t.name);
            System.out.println(ch.equals(t));
Child: Elysia null
Child: Elysia Sophia
Child: Webby Sophia
Child: Olivia Sophia
true
            */

            final ChildClass ch = new ChildClass();
            final StaticInheritanceTest t = new StaticInheritanceTest();
            ch.name = "Elysia";  System.out.println("Child: " + ch.name + " " + t.name);
            t.name = "Sophia";  System.out.println("Child: " + ch.name + " " + t.name);
            ch.setName("Webby");  System.out.println("Child: " + ch.name + " " + t.name);
            t.setName("Olivia");
            System.out.println("Child: " + ch.name + " " + t.name);
            System.out.println(ch.equals(t));
/*Child: Elysia null
Child: Elysia Sophia
Child: Webby Sophia
Child: Webby Olivia
false
*/
        }}
}
