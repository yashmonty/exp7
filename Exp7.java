import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Process class to store process details
class Process {
    int id; // Process ID
    int burstTime; // Burst time
    int priority; // Priority
    int waitingTime; // Waiting time
    int turnaroundTime; // Turnaround time

    Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class Exp7 {
    public static void main(String[] args) {
        // Hardcoded input: List of processes
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 10, 2)); // Process 1: Burst Time = 10, Priority = 2
        processes.add(new Process(2, 5, 1));  // Process 2: Burst Time = 5, Priority = 1
        processes.add(new Process(3, 8, 3));  // Process 3: Burst Time = 8, Priority = 3

        // Sort processes by priority (higher priority = lower value)
        Collections.sort(processes, Comparator.comparingInt(p -> p.priority));

        // Calculate waiting time and turnaround time
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;

        for (int i = 0; i < processes.size(); i++) {
            if (i == 0) {
                processes.get(i).waitingTime = 0;
            } else {
                processes.get(i).waitingTime = processes.get(i - 1).waitingTime + processes.get(i - 1).burstTime;
            }

            processes.get(i).turnaroundTime = processes.get(i).waitingTime + processes.get(i).burstTime;

            totalWaitingTime += processes.get(i).waitingTime;
            totalTurnaroundTime += processes.get(i).turnaroundTime;
        }

        // Display process details
        System.out.println("Process ID\tBurst Time\tPriority\tWaiting Time\tTurnaround Time");
        for (Process p : processes) {
            System.out.println(p.id + "\t\t" + p.burstTime + "\t\t" + p.priority + "\t\t" + p.waitingTime + "\t\t" + p.turnaroundTime);
        }

        // Display average waiting time and turnaround time
        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / processes.size());
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / processes.size());
    }
}
