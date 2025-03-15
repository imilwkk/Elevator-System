import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // getting user inputs
        System.out.print("Enter the number of floors: ");
        int numFloors = sc.nextInt();

        System.out.print("Enter the maximum number of passengers per trip: ");
        int maxPassengers = sc.nextInt();

        System.out.print("Enter the simulation duration (in minutes): ");
        int simulationDuration = sc.nextInt();

        // using a HashMap to store the frequency of calls from each floor
        Map<Integer, Integer> floorCallCount = new HashMap<>();

        // simulating the elevator system
        int totalTime = 0;
        int currentFloor = 0;

        // simulating passenger calls for the simulation duration (1 call per minute)
        System.out.println("\nSimulating passenger calls...");
        for (int i = 0; i < simulationDuration; i++) {
            int floorCalled = rand.nextInt(numFloors); // randomizing floor call
            floorCallCount.put(floorCalled, floorCallCount.getOrDefault(floorCalled, 0) + 1); // count the call
            totalTime += Math.abs(currentFloor - floorCalled); // time needed to move from currentFloor to floorCalled
            currentFloor = floorCalled; // elevator moves to the requested floor

            // log first few calls for simplicity
            if (i < 10) {
                System.out.println("Passenger called elevator from floor " + floorCalled + ".");
            }
        }

        // Results
        System.out.println("\nSimulation completed.\n");
        System.out.println("Total time taken: " + totalTime + " minutes");
        System.out.println("Frequency of calls from each floor:");
        for (Map.Entry<Integer, Integer> entry : floorCallCount.entrySet()) {
            System.out.println("Floor " + entry.getKey() + ": " + entry.getValue() + " calls");
        }

        System.out.println("\nThank you for using the Elevator Simulation!");
        sc.close();
    }
}
