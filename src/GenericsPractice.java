import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsPractice {


//    MyGenericThings<T> myGenericThings = new MyGenericThings<T>();

    public void useGenericsForList() {
        List listWithoutGenericRequiresCast = new ArrayList();
        listWithoutGenericRequiresCast.add("String");
        String firstString = (String) listWithoutGenericRequiresCast.get(0);

        List<String> listWithGenericTypeNoCast = new ArrayList();
        listWithGenericTypeNoCast.add("String");
        String secondString = listWithGenericTypeNoCast.get(0);
    }
/*
    public MyGenericThings<T> getMyGenericThings() {
        return myGenericThings;
    }

    public <T> void setMyGenericThings(MyGenericThings<T> myGenericThings) {
        this.myGenericThings = myGenericThings;
    }
    private void logThings() {
        System.out.println("Initialized Things: " + .getThings().toString());}
    }

    public <T> void  collectMyThings(T[] genArray) {
        setMyGenericThings( new MyGenericThings(Arrays.stream(genArray).toList()));

    }
    public <T> void collectMyIntegers (Integer[] ints) {
        MyGenericThings<Integer> myIntegers = new MyGenericThings<>(Arrays.asList());
        System.out.println();
    }*/
}



