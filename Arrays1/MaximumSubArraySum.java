package Arrays1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubArraySum {
    public static Integer solveUsingKadanes(ArrayList<Integer> givenArray){
        Integer tempSum = 0;
        Integer finalSum = Integer.MIN_VALUE;
        for(Integer thisElement : givenArray){
            tempSum += thisElement;
            if(tempSum > finalSum){
                finalSum = tempSum;
            }
            if(tempSum < 0){
                tempSum = 0;
            }
        }

        return finalSum;
    }

    public static List<Integer> SubArrayWithLargestSum(ArrayList<Integer> givenArray){
        Integer tempSum = 0;
        Integer finalSum = Integer.MIN_VALUE;
        Integer startIndex = 0;
        Integer endIndex = 0;
        Integer currentIndex = -1;
        Integer answerStartIndex = 0;
        Integer answerEndIndex = 0;
        for(Integer thisElement: givenArray){
            currentIndex += 1;
            tempSum += thisElement;

            if(tempSum > finalSum){
                finalSum = tempSum;
                endIndex = currentIndex;
            }

            if(tempSum < 0){
                tempSum = 0;
                startIndex = currentIndex+1;
            }

            if(startIndex > answerStartIndex && endIndex >= startIndex){
                answerStartIndex = startIndex;
            }

            if(endIndex > answerEndIndex){
                answerEndIndex = endIndex;
            }

        }
        return givenArray.subList(answerStartIndex, answerEndIndex+1).stream().toList();
    }
    public static void main(String[] args) {

        System.out.println(MaximumSubArraySum.solveUsingKadanes(new ArrayList<Integer>(Arrays.asList(-1,2,3,-4,6,9,2,-1,8,3)) ));
        System.out.println(MaximumSubArraySum.SubArrayWithLargestSum(new ArrayList<Integer>(Arrays.asList(-1,2,3,-4,6,9,2,-1,8,3)) ).toString());
        System.out.println();

        System.out.println(MaximumSubArraySum.solveUsingKadanes(new ArrayList<Integer>(Arrays.asList(-9,-6,-3,-15, -12)) ));
        System.out.println(MaximumSubArraySum.SubArrayWithLargestSum(new ArrayList<Integer>(Arrays.asList(-9,-6,-3,-15, -12)) ).toString());
    }
}
