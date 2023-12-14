package Arrays1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeggarsOutsideTemple_pfSum {
    public static ArrayList<Integer> solution(List<List<Integer>> queries, List<Integer> initialArray){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        answer.addAll(initialArray);
        for(List<Integer> currentQuery : queries){
            Integer startIndex = currentQuery.get(0);
            Integer endIndex = currentQuery.get(1);
            Integer value = currentQuery.get(2);

            Integer currentValue = answer.get(startIndex);
            Integer newValue = currentValue + value;
            answer.set(startIndex, newValue);

            if(endIndex != 0 && endIndex < initialArray.size()-1){
                currentValue = answer.get(endIndex+1);
                newValue = currentValue - value;
                answer.set(endIndex+1, newValue);
            }
        }
        return getPrefixSumArray(answer);
    }

    public static ArrayList<Integer> getPrefixSumArray(ArrayList<Integer> givenArray){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int index = 0;
        for(Integer currentElement : givenArray){
            if(index==0) {
                result.add(currentElement);
            } else {
                result.add(result.get(index-1)+currentElement);
            }
            index += 1;
        }
        return result;

    }
    public static void main(String[] args) {
        testCase1();
        testCase2();
    }

    private static void testCase1() {
        Integer[][] queries = new Integer[][] { {2,4,2},{1,3,1},{0,2,3},{3,5,4}  };
        List<List<Integer>> queryList = Arrays.stream(queries).map(Arrays::asList).collect(Collectors.toList());

        Integer[] givenArray = new Integer[] {0,0,0,0,0,0};
        List<Integer> initialArray = Arrays.asList(givenArray);
        System.out.println(BeggarsOutsideTemple_pfSum.solution(queryList, initialArray).toString());
    }

    private static void testCase2() {
        Integer[][] queries = new Integer[][] { {1,3,5},{2,4,3} };
        List<List<Integer>> queryList = Arrays.stream(queries).map(Arrays::asList).collect(Collectors.toList());

        Integer[] givenArray = new Integer[] {2,3,1,6,9,-5};
        List<Integer> initialArray = Arrays.asList(givenArray);
        System.out.println(BeggarsOutsideTemple_pfSum.solution(queryList, initialArray).toString());
    }
}
