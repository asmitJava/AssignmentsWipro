package dsa.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingGreedy {

    public static List<Job> JobSequencing(List<Job> jobs) {
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        boolean[] slot = new boolean[maxDeadline];
        List<Job> result = new ArrayList<>();

        for (Job job : jobs) {
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result.add(job);
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 4, 20));
        jobs.add(new Job(2, 1, 10));
        jobs.add(new Job(3, 1, 40));
        jobs.add(new Job(4, 1, 30));

        List<Job> sequence = JobSequencing(jobs);

        System.out.println("Job sequence to maximize profit:");
        for (Job job : sequence) {
            System.out.println("Job ID: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profit);
        }
    }
}

