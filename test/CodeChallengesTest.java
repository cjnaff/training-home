import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CodeChallengesTest {
    CodeChallenges challenge = new CodeChallenges();
    @Test
    public void printBoardingPassesInOrder() {

        List<BoardingPass> passes = new ArrayList<>();
        passes.add(new BoardingPass("B", "C"));
        passes.add(new BoardingPass("D", "E"));
        passes.add(new BoardingPass("A", "B"));
        passes.add(new BoardingPass("C", "D"));
        passes.add(new BoardingPass("E", "Z"));

        System.out.println("Ordered Passes: " + challenge.printBoardingPassesInOrder(passes));

    }

    @Test
    public void ableToProcessEmptyPassesList() {
        List<BoardingPass> passes = new ArrayList<>();
        System.out.println("Ordered Passes: " + challenge.printBoardingPassesInOrder(passes));
        assertTrue(challenge.printBoardingPassesInOrder(passes) == null);

    }

    @Test(expected = RuntimeException.class)
    public void errorReturnedUnsortablePasses() {

        List<BoardingPass> passes = new ArrayList<>();
//        passes.add(new BoardingPass("B", "C"));
        passes.add(new BoardingPass("D", "E"));
        passes.add(new BoardingPass("A", "B"));
        passes.add(new BoardingPass("C", "D"));
        passes.add(new BoardingPass("E", "Z"));

        System.out.println("Ordered Passes: " + challenge.printBoardingPassesInOrder(passes));
    }
}