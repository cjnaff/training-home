import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CodeChallenges {
    Integer indx = 0;
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
        Input: nums = [2,7,11,15], target = 9,  Output: [0,1],  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:
        Input: nums = [3,2,4], target = 6,  Output: [1,2]
    Example 3:
        Input: nums = [3,3], target = 6,  Output: [0,1]
    Constraints:
    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.
     */
    public int[] twoSum(int[] nums, int target) {
        indx = 0;
        System.out.println("Finding two numbers that add up to: " + target);
        var numsMap = new LinkedHashMap<Integer, Integer>();
        Arrays.stream(nums).boxed().forEach(i -> numsMap.put(i, nextIndex()) );
        System.out.println("LinkedHashMap: " + numsMap);
        List<Integer> results = new ArrayList<>();
/*        for(Map.Entry e : numsMap.entrySet()) {
            if(numsMap.containsKey(target - (Integer) e.getKey()) && numsMap.get(target - (Integer) e.getKey()) != e.getValue()) {
                results.add((Integer) e.getValue());
            }
        }*/

        numsMap.entrySet()
                .stream()
                .filter(m -> numsMap.containsKey(target - m.getKey()) &&
                        numsMap.get(target - m.getKey()) != m.getValue())
                .forEach(e -> results.add(e.getValue()));

           /*for(int i = 0 ; i < nums.length ; i++) {
               if(numsMap.containsKey(target - numsMap.).intValue() != i  ){
                   results.add(i);
               }

            }*/
        return Arrays.stream(results.stream().mapToInt(i -> i.intValue()).toArray()).toArray();
//        return results.stream().mapToInt(i -> i.intValue()).toArray();
    }

    private Integer nextIndex() {
        return indx++ ;
    }

    public String commonWordSuffix(String[] strings) {
        if(strings!= null ) {
            if(strings.length == 1) {
                return strings[0];
            } else {
                int charCount = 1;
//                int minWordLength = Arrays.stream(strings).min(Comparator.comparingInt(String::length)).get().length();
                int minWordLength = Arrays.stream(strings).map(String::length).min(Integer::compare).orElse(0);
                int charMatch = minWordLength;

                for(int i = 0; i < (strings.length - 1) ; i++) {  // Compare two words at a time
                    boolean matches = true;
                    charCount = 1;  // Check first char, then first 2 chars, up to minimum word length
                    while (matches && charCount <= minWordLength) {
                        if( strings[i].toLowerCase().regionMatches(0, strings[i + 1].toLowerCase(), 0, charCount)) {
                            charCount++;
                        } else {
                            matches = false;
                            charCount--;
                            if(charCount< charMatch) {charMatch = charCount;}  // these two words might have fewer matching characters than the last 2 words
                        }
                    }
                }
                System.out.println("Words: " + String.join(", ", strings) + ", Characters Matching = " + charMatch);
                return strings[0].substring(0, charMatch );
            }
        } else {
            return "";
        }
    }

    public boolean isValidParentheses(String s) {
        Deque<String> deck = new ArrayDeque();
        Map<String, String> parenMap = new HashMap<String, String>( ) {{
            put("(", ")");
            put("{", "}");
            put("[", "]");
        }};

//      String Array of each character in the string
        Stream.of(s.split("")).forEach(ch -> deck.add(ch));

//      Versus getting CharArray of the string and then taking String value of that char
        /*for (char ch : s.toCharArray()) {
            deck.add(String.valueOf(ch));
        }*/
        System.out.println("Stack: " + deck);
        String curParen = "";
        boolean isValid = false;
        while(deck.iterator().hasNext()) {

            if(parenMap.keySet().contains(deck.peek())) {  // is opening paren of some kind
                curParen = deck.peek();
//                System.out.println("Found opening paren: " + curParen);
                deck.poll();  // remove it
                isValid = false;  // reset until we find matching
            } else if (parenMap.values().contains(deck.peek()) ) { // is closing paren
                if( parenMap.get(curParen).equals(deck.peek())) { // does it match to the Opening one?
//                    System.out.println("Found matching paren: " + curParen + " with " + deck.peek());
                    deck.poll(); // remove it
                    isValid = true;
               /*  // Do I need this??  Nope
               } else {
//                    System.out.println("Mismatched parens: " + deck);
                    isValid = false;  */
                }
            } else {
                deck.pop();
            }
        }
//        System.out.println("Is Valid = " + isValid);
        return isValid;
    }

    public boolean isValidParenthesesOnly(String s) {
        // Stack isn't part of Collections, and Deque is preferred.
        // Below is someone else's solution for problem
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = null;
        while(list1.next != null && list2.next != null) {
            if(list1.val <= list2.val) {
                mergedList = new ListNode(list1.val, list2);
                list1 = list1.next;
            } else {
                mergedList = new ListNode(list2.val, list1);
                list2 = list2.next;
            }
        }


        return mergedList;
    }

    public ListNode mergeTwoListsMyWay(ListNode list1, ListNode list2) {
        List<Integer> newList = new LinkedList<>();
        ListNode l1 = list1;
        do {
            if(l1 != null) {
                newList.add(l1.val);
                l1 = l1.next;
            }

        } while(l1 != null);

        System.out.println(newList);
        ListNode l2 = list2;
        do  {
            newList.add(l2.val);
            l2 = l2.next;
        } while (l2 != null);
        newList.sort(Integer::compareTo);
        System.out.println(newList);
        return generateNestedListNodesFromList(newList);
    }

    public ListNode mergeTwoListsMyWay2(ListNode list1, ListNode list2) {
        List<Integer> newList = new LinkedList<>();
        ListNode l1 = list1;
        while(l1 != null) {
            newList.add(l1.val);
            l1 = l1.next;
        }
        System.out.println(newList);
        ListNode l2 = list2;
        while (l2 != null) {
            newList.add(l2.val);
            l2 = l2.next;
        }
        newList.sort(Integer::compareTo);
        System.out.println(newList);
        return generateNestedListNodesFromList(newList);
    }
    public ListNode mergeTwoListsMyWay3(ListNode list1, ListNode list2) {
        List<Integer> newList = new LinkedList<>();
        while(list1 != null) {
            newList.add(list1.val);
            list1 = list1.next;
        }
        System.out.println(newList);
        while (list2 != null) {
            newList.add(list2.val);
            list2 = list2.next;
        }
        newList.sort(Integer::compareTo);
        System.out.println(newList);
        return generateNestedListNodesFromList(newList);
    }

    public ListNode generateNestedListNodesFromList(List<Integer> ints) {
        ListNode prevListNode = null;
        ListNode curListNode = null;

        for (Integer i : ints.reversed()) {
            curListNode = new ListNode(i, prevListNode);
            prevListNode = curListNode;
        }
        return curListNode;
    }

    public List<Integer> flattenNestedListNodeValuesToList(ListNode ln) {
        List<Integer> flatList = new ArrayList<>();
        flatList.add(ln.val);
        do {
            flatList.add(ln.next.val);
            ln = ln.next;
        } while  (ln.next != null);

        return flatList;

    }

    public int trap(int[] height) {
/*
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

   // highest point
        if next is lower than highest
            if exists in remaining another >= highest
            then subtract next point from highest point, and add that to total
            else set highest = next
        else set highest = next
        subtract next point from highest point if next is lower than highest
        if next is > highest, set new highest
*/
        // untested doesn't work
        int trappedWater = 0;
        Integer highmark = 0;
        Queue<Integer> levels = new ArrayDeque<> ();
        levels.addAll(Arrays.stream(height).boxed().collect(Collectors.toCollection(ArrayDeque::new)));
        Queue<Integer> levelCopy = levels;
        for(Integer level : levels) {
            highmark = levelCopy.poll();
           /* if (levelCopy.peek() < highmark) {
                if (levelCopy.stream().filter(i -> i >= highmark)
                        .count() > 0)
                         {
                    trappedWater += highmark - levelCopy.peek();
                } else {
                    highmark = levelCopy.poll();
                }

            }*/
        }
        return trappedWater;
    }


    public List<BoardingPass> printBoardingPassesInOrder(List<BoardingPass> passes) {
        /*
        A ------------ B ---------------C ------------- D ---------------- E ------------ Z

        You might get the passes in any order
        It may have more or less legs than this example
        Find the starting city and ending city and order of passes in between
         *
         */

        System.out.println("Unordered Passes: " + passes);
        if(passes.size() > 0) {
            Set<String> starts = passes.stream()
                    .map(pas -> pas.start)
                    .collect(Collectors.toSet());
            Set<String> ends = passes.stream()
                    .map(pas -> pas.end)
                    .collect(Collectors.toSet());

            String start = starts.stream()
                    .filter(s -> !ends.contains(s))
                    .findFirst().orElse("");
            if(!start.equals("")) {
                List<BoardingPass> sortedPasses = new ArrayList<>();
                // add starting pass
                sortedPasses.add(passes.stream().filter(p -> p.start.equals(start)).findAny().get());
                // find next pass where start equals end on previous
                while (passes.stream()
                        .filter(p -> p.start.equals(sortedPasses.getLast().end))
                        .findAny()
                        .isPresent()) {
                    sortedPasses.add(passes.stream()
                            .filter(p -> p.start.equals(sortedPasses.getLast().end))
                            .findAny()
                            .get());
                }
                if(passes.size() == sortedPasses.size()) {
                    return sortedPasses;
                }else {
                    System.out.println("Missing a boarding pass in the chain. ");
                    throw new RuntimeException("Incomplete set of passes.");
                }
            } else {
                System.out.println("Can't find a start location. ");
                throw new RuntimeException("Cannot sort boarding passes.");
            }
        }
        return null;
    }

}
