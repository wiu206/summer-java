public class GradeProcessor {
    public static void main(String[] args) {

        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        int total = 0;
        for (int s : scores) total += s;
        double avg = total / (double) scores.length;

        int maxScore = scores[0], minScore = scores[0];
        int maxIdx = 0,    minIdx = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) { maxScore = scores[i]; maxIdx = i; }
            if (scores[i] < minScore) { minScore = scores[i]; minIdx = i; }
        }

        int aboveAvg = 0;
        for (int s : scores) if (s > avg) aboveAvg++;

        System.out.printf("Total: %d%n", total);
        System.out.printf("Average: %.2f%n", avg);
        System.out.printf("Max score: %d (index %d)%n", maxScore, maxIdx);
        System.out.printf("Min score: %d (index %d)%n", minScore, minIdx);
        System.out.printf("Number of students above average: %d%n", aboveAvg);

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("Student %d: %d%n", i, scores[i]);
        }
    }
}
