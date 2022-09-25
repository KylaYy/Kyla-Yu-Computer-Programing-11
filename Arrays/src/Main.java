import java.util.Arrays;

public class Main {

    //method for adding a value at the end of the array
    private static void appendValue(int a, int[] array) {
        //The method takes an integer to be added to the end as well as an array
        //A new array is created with an index of one greater than the original array
        int[] newArray = new int[array.length + 1];

        //A for loop iterates through the index numbers of the original array and copies them into the new array
        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        //The integer, a, is added to the last index position
        newArray[newArray.length-1] = a;
        System.out.println("Array with a new value added to the end:");
        System.out.println(Arrays.toString(newArray));
    }

    //Method that deletes the last value. A new array is created with an index size of one less than the original, then filled using iterations
    private static void popArray(int[] array){
        //The method creates a new array with index of one less than the original array
        int[] newArray = new int[array.length-1];

        //The original array values are pasted into the new array with the new array length (one index position less than the original array) as the upper limit
        for (int i = 0; i < newArray.length; i++){
            newArray[i] = array[i];
        }
        System.out.println("Array with the last value deleted:");
        System.out.println(Arrays.toString((newArray)));

    }

    private static void insertValue(int index, int integer, int[] array){
        //The method takes an integer for the desired index position, an integer to be inserted into the array, and the array
        int[] newArray = new int[array.length + 1];
        //The values are filled in up until one index position before the desired index position
        for(int i = 0; i < index; i++){
            newArray[i] = array[i];
        }
        //The integer is inserted at the desired index position
        newArray[index] = integer;
        //The rest of the numbers are filled in starting at the next index position after the desired index postion
        for(int i = (index + 1); i < newArray.length; i++){
            newArray[i] = array[i-1];
        }

        System.out.println("Array with a new value inserted at the desired position:");
        System.out.println(Arrays.toString(newArray));

    }



    public static void main(String[] args) {
        // array to be tested
        int[] arr1 = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};
        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr1) + "\n");

        appendValue(9, arr1);
        popArray(arr1);
        insertValue(8, 16, arr1);
    }
}
