import java.util.Scanner;

public class SumOfSubArrayElements {
    public static boolean hasSubarrayWithSum(int[] numberOfElements, int targetSum) {
        if (numberOfElements == null || numberOfElements.length == 0) {
            return false;
        }
        int currentSum = 0;
        int startOfArray = 0;
        for (int endOfArray = 0; endOfArray < numberOfElements.length; endOfArray++) {
            currentSum += numberOfElements[endOfArray];
            while (currentSum > targetSum && startOfArray <= endOfArray) {
                currentSum -= numberOfElements[startOfArray];
                startOfArray++;
            }
            if (currentSum == targetSum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int arraySize = scanner.nextInt();
        int[] numberOfElements = new int[arraySize];
        System.out.print("Enter the "+arraySize+" elements of array: ");
        for(int value=0;value<arraySize;value++)
        {
            numberOfElements[value]=scanner.nextInt();
        }
        System.out.print("Enter the target sum value ");
        int targetSum = scanner.nextInt();
        scanner.close();
        // Example input {1, 4, 20, 3, 10, 5};
        boolean result = hasSubarrayWithSum(numberOfElements, targetSum);
        if (result) {
            System.out.println("There is a subarray with the given sum.");
        } else {
            System.out.println("No subarray with the given sum found.");
        }
    }
}
