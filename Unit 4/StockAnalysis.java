import java.util.Random; // Import Random class for generating random numbers
import java.util.ArrayList; // Import ArrayList class for dynamic list operations


public class StockAnalysis {
    public static void main(String[] args) {
        // Generate an array of stock prices with 10 random float values between 60.0 and 100.0
        float[] stockPricesArray = generateStockPrices(10, 60.0f, 100.0f);


        // Convert the generated array into an ArrayList for dynamic operations
        ArrayList<Float> stockPricesArrayList = convertArrayToArrayList(stockPricesArray);


        // Calculate and print the average stock price from the array
        float average = calculateAveragePrice(stockPricesArray);
        System.out.println("The average stock price is: " + average);


        // Find and print the maximum stock price from the array
        float max = findMaximumPrice(stockPricesArray);
        System.out.println("The maximum stock price is: " + max);


        // Determine the occurrence count of a specific price and print the result
        float targetPrice = 97.68294f; // Define a target price to search for
        int count = countOccurrences(stockPricesArray, targetPrice);
        System.out.println("When target price is " + targetPrice + ". The occurrence count of " + targetPrice + " is: " + count);


        // Compute and print the cumulative sum of stock prices in the ArrayList
        ArrayList<Float> cumulativeSumList = computeCumulativeSum(stockPricesArrayList);
        System.out.println("The cumulative sum of stock prices is: " + cumulativeSumList);
    }


    // Method to generate random stock prices within a specified range
    public static float[] generateStockPrices(int size, float min, float max) {
        float[] stockPrices = new float[size]; // Initialize the array to hold stock prices
        Random random = new Random(42); // Seed the Random generator for reproducibility


        // Generate 'size' random stock prices within the range [min, max)
        for (int i = 0; i < size; i++) {
            stockPrices[i] = random.nextFloat() * (max - min) + min; // Scale random float to range
        }


        return stockPrices; // Return the generated stock prices array
    }


    // Method to convert an array of stock prices to an ArrayList for dynamic operations
    public static ArrayList<Float> convertArrayToArrayList(float[] stockPricesArray) {
        ArrayList<Float> stockPricesArrayList = new ArrayList<>(); // Initialize an empty ArrayList


        // Add each element from the array to the ArrayList
        for (float num : stockPricesArray) {
            stockPricesArrayList.add(num);
        }


        return stockPricesArrayList; // Return the populated ArrayList
    }


    // Method to calculate the average stock price from an array
    public static float calculateAveragePrice(float[] stockPricesArray) {
        float sum = 0; // Initialize the sum to 0


        // Accumulate the sum of all stock prices
        for (float stock : stockPricesArray) {
            sum += stock;
        }


        // Calculate the average by dividing the sum by the number of elements
        float average = sum / stockPricesArray.length;
        return average; // Return the calculated average
    }


    // Method to find the maximum stock price in an array
    public static float findMaximumPrice(float[] stockPricesArray) {
        float max = Float.NEGATIVE_INFINITY; // Initialize max to the smallest possible value


        // Iterate through the array and update max whenever a larger value is found
        for (float stock : stockPricesArray) {
            if (stock > max) {
                max = stock; // Update max
            }
        }


        return max; // Return the maximum stock price
    }


    // Method to count the occurrences of a specific price in an array
    public static int countOccurrences(float[] stockPricesArray, float targetPrice) {
        int count = 0; // Initialize the count to 0
        float tolerance = 0.0001f; // Define a small tolerance for floating-point comparisons


        // Iterate through the array and count occurrences of the target price
        for (float stock : stockPricesArray) {
            if (Math.abs(stock - targetPrice) < tolerance) { // Use tolerance for float comparison
                count++;
            }
        }


        return count; // Return the count of occurrences
    }


    // Method to compute the cumulative sum of stock prices in an ArrayList
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPricesArrayList) {
        ArrayList<Float> cumulativeSumList = new ArrayList<>(); // Initialize an empty ArrayList for cumulative sums
        float sum = 0; // Initialize the running sum to 0


        // Compute the cumulative sum at each position and add it to the new ArrayList
        for (float stock : stockPricesArrayList) {
            sum += stock; // Update the running sum
            cumulativeSumList.add(sum); // Add the running sum to the list
        }


        return cumulativeSumList; // Return the ArrayList containing cumulative sums
    }
}
