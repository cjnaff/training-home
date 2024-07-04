import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingAndMapping {

        private List<Integer> numbers = new ArrayList<>();

        private Map<String, String> anagramStrings = new HashMap<>();
        private Map<Integer, String> favoriteColorsMap = new HashMap<>();
        private int indx = 1;


        public List<Integer> initNumbersList() {
            numbers.addAll(Arrays.asList(300,22,55,38,242,519,22));

            return numbers;
        }

        public List<Integer> integerArrayToList(Integer[] args) {
            return Arrays.asList(args);
        }

        public Map<String, String> initAnagramStrings() {
            anagramStrings.put("tool", "loot");
            anagramStrings.put("door", "rood");
            anagramStrings.put("grab", "brag");
            anagramStrings.put("state", "taste");
            return anagramStrings;

        }

        public void initFavoriteColorsMap() {
            favoriteColorsMap.put(1, "old rose");
            favoriteColorsMap.put(2, "lavendar magenta");
            favoriteColorsMap.put(3, "phlox");

        }

        public Map<Integer, String> getFavoriteColorsMap() {
            return favoriteColorsMap;
        }

        public void setFavoriteColorsMap(Map<Integer, String> favoriteColorsMap) {
            this.favoriteColorsMap = favoriteColorsMap;
        }


        public List<Integer> getSortedNumberList() {
            /*
            sorted numbers
            List<Integer> nums = Arrays.asList(4,6,1,9,33);
            List<Integer> snums = nums.stream()
                    .sorted()
                    .collect(Collectors.toList());
            snums.forEach(System.out::println);
            */
            return numbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
        }

        public List<Integer> getDoubleAllNumbers() {
            return numbers.stream()
                    .map(n -> n = n*2)
                    .collect(Collectors.toList());
        }

        public List<Integer> getUniqueList() {
            return numbers.stream()
                    .distinct()
                    .collect(Collectors.toList());
        }

        public List<Integer> getFilteredListDivisibleBy11() {
            return numbers.stream()
                    .filter(i -> i % 11 == 0)
                    .collect(Collectors.toList());
        }

        public List<Integer> getFilteredListDivisibleBy11FullSyntax() {

            return numbers.stream()
                    .filter(new Predicate<>() {
                        @Override
                        public boolean test(Integer integer) {
                            return integer % 11 == 0;
                        }
                    })
                    .collect(Collectors.toList());
        }
        public int getSumOfNumbersUsingReduce() {
            return  numbers.stream()
                    .reduce(1, (a,b) -> a + b);
        }

        public Map<Integer, Long> getCountEachInt() {
            Map<Integer, Long> map = getNumbers().stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(map);
            return map;
        }

        public List<Integer> getNumbers() {
            return numbers;
        }

        public void setNumbers(List<Integer> numbers) {
            this.numbers = numbers;
        }


        public Map<String, String> getAnagramStrings() {
            return anagramStrings;
        }

        public void setAnagramStrings(Map<String, String> anagramStrings) {
            this.anagramStrings = anagramStrings;
        }


        public int  getOccurrencesWordInString(String source, String word) {
            String[] words = source.toLowerCase().replaceAll("[.!?]", "").split(" ");
            System.out.println(
                    Stream.of(words)
                            .filter(w -> w.equalsIgnoreCase(word))
                            .collect(Collectors.toList())
            );
            System.out.println("Count of words :" + Arrays.stream(words).filter(w -> w.equalsIgnoreCase(word)).count());
            return  Stream.of(words)
                    .filter(w -> w.equalsIgnoreCase(word))
                    .collect(Collectors.toList()).size();


        }

        public List<Integer> getListOfIntegersReversed(List<Integer> list) {
            List<Integer> newList = new ArrayList<>();
            list.iterator().forEachRemaining(i -> {
                newList.add(list.get(list.size() - getNextIndx()));

            });
            return newList;
        }

        public List<Integer> getListOfIntegersReversedEasier(List<Integer> list) {
            System.out.println("List : " + list + ", and reversed " + list.reversed());
//             Collections.reverse(list);
//             return list;
            // new method available in jdk 21
             return list.reversed();



        }


        private int getNextIndx() {
            return indx++;
        }

    }
