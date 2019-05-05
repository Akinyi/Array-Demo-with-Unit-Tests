package solution;



import java.util.ArrayList;



/*

This is a demo task.

Write a function:

class Solution { public int solution(int[] A); }

that, given an A A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of A A is an integer within the range [−1,000,000..1,000,000].
*/
public class Solution implements Cloneable {

    public Solution(){
      //  int result = (new Solution()).solution ( A ); 
      
    }
  
    public static void main(String[] args) {

      int[] A = {1, 3, 6, 4, 1, 2};
     // int[] A = {1,3,2};
     //int[] A = {1, -1000, 0, 3};
      int result = (new Solution()).solutionEnd(A);
      System.out.println(result);

    /*    System.out.println("/////////////////");
        arrayConvertedToArrayList(A);
        ArrayList<Integer> array3 = new ArrayList<>();
        for(int i = 0; i<array.length-1; i++)
        if(A[i] >= 0)array3.add(A[i]);
        for(Integer element: array3) System.out.println("\nSorterad array3: " + element); */
    }
  /*  public static Boolean verifyElementSize(int[] array){
        boolean size = true;
        int n = array.length;
        for(int i = 0; i< array.length-1; i++){
          if(array[i]< -1000000 && array[i]> 1000000) size = false;
          else if(array[n] < -1000000 && array[n] > 1000000 ) size = false;
        }
       
       return size;
    }*/
    
    public static Integer solutionEnd(int[] A){
     ArrayList<Integer> array3 = new ArrayList<>();
     if(verifyElementsInArray(A) && verifyArrayLength(A)){
       // ArrayList<Integer> array2 = new ArrayList<>();
       // sort(A);
        array3 = sortAndConvertToArrayList(A);
     }
     return checkMissingInteger(array3);
    }
    public static Boolean verifyArrayLength(int[] array){
        boolean arrayLength = true;
        int N = 100000;
        if(array.length > N){
            arrayLength = false;
        }
        return arrayLength;
    }
    
    public static Boolean verifyElementsInArray(int[] array){
        boolean elementIsAcceptable = true;
        for(int i = 0; i<array.length - 1; i++){
        if(array[i] > 1000000) elementIsAcceptable = false; 
        else if(array[i] < -1000000) elementIsAcceptable = false;
        }
        return elementIsAcceptable;
    }
    
    public static Boolean verifyNegative(int b){
        boolean elementIsNegative = true;
        if(b < 0) elementIsNegative = false;
        
        return elementIsNegative;
    }
   
    public static int[] sort(int[] array) {
        int size = array.length;
        boolean exchangedElement=true;
    while (exchangedElement)
    {
      exchangedElement=false;
      for (int i=0; i<size-1; i++)
        if (array[i]>array[i+1])
        { 
          int temp=array[i]; 
          array[i]=array[i+1]; 
          array[i+1]=temp;
          exchangedElement=true;
        }
    }
    return array;
   }
    
    public static Integer checkMissingInteger(ArrayList<Integer> array){
        int element = 0;
        int bigdifference;
        for(int i = 1; i <= array.size() -1; i++){
          for(int j = 0; j<array.size() - 1; j++){
            ++j;
            bigdifference = array.get(i) - array.get(j);
            if( bigdifference == 0){
            element = array.get(i);
            element += 1;
            break;           
            }
            else if( bigdifference == 1){
            continue;            
            }
            else if(bigdifference >= 2){
            element = array.get(j);
            
          for(; j<array.size(); j++){
               if(array.get(j) == element)continue;
               else element += 1;
              }
           
           }
        }
       }
        
        return element+=1;
    }
    
    //Converts int[] to a sorted ArrayList
    public static ArrayList<Integer> sortAndConvertToArrayList(int[] array){
        int m = array.length;
        sort(array);
        ArrayList<Integer> array3 = new ArrayList<>();
          for(int i = 0; i<array.length-1; i++)
          if(array[i] >= 0)array3.add(array[i]);
          else  array3.add(0);
        return array3;
    }
}
