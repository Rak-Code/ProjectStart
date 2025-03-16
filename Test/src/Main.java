import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] arr = {18,22};

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for(int num : arr){
            System.out.printf(num + " ");

        }
        System.out.println();
        for(int num : arr) {
            if(num > largest) {
                secondLargest = largest;
                largest = num;
            }
            else if(num > secondLargest && num != largest) {
                secondLargest = num;

            }

        }
        System.out.println("secondlargest "+secondLargest);
        System.out.println("largest "+largest);

        List<Integer> arr2 = new ArrayList<>();
        for(int num : arr){
            if(num != largest){
                arr2.add(num);
            }
        }
//        System.out.println(arr2);


        for(int num : arr2){

            if(num > secondLargest){
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num > thirdLargest && num != secondLargest) {
                thirdLargest = num;
            }
        }
        System.out.println("thirdlargest "+thirdLargest);

        String str = "Rakesh";

       String s = str.toLowerCase();
        char[] c = s.toCharArray();
        Arrays.sort(c);
        System.out.println(c);

    }

}
