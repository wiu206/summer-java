public class StudentGradeSystem {

    private static char gradeOf(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else return 'D';
    }

    private static void displayReport(int[] scores) {


        int n = scores.length;
        int total = 0;
        int max = scores[0], min = scores[0];
        int maxIdx = 0,            minIdx = 0;
        int[] levelCnt = new int[4]; 
        for (int i = 0; i < n; i++) {
            int s = scores[i];
            total += s;

            if (s > max) { max = s; maxIdx = i; }
            if (s < min) { min = s; minIdx = i; }

            switch (gradeOf(s)) {
                case 'A' -> levelCnt[0]++;
                case 'B' -> levelCnt[1]++;
                case 'C' -> levelCnt[2]++;
                case 'D' -> levelCnt[3]++;
            }
        }
        double avg = total / (double) n;

        int aboveAvg = 0;
        for (int s : scores) if (s > avg) aboveAvg++;
        double aboveRatio = aboveAvg * 100.0 / n;

        System.out.println("==== 學生成績報告 ====");
        System.out.println("學生人數 : " + n);
        System.out.println("--------------------");
        System.out.printf("總分      : %d%n", total);
        System.out.printf("平均      : %.2f%n", avg);
        System.out.printf("最高分    : %d (索引 %d)%n", max, maxIdx);
        System.out.printf("最低分    : %d (索引 %d)%n", min, minIdx);
        System.out.printf("等級統計  : A=%d  B=%d  C=%d  D=%d%n",
                          levelCnt[0], levelCnt[1], levelCnt[2], levelCnt[3]);
        System.out.printf("高於平均者: %d人 (佔 %.1f%%)%n", aboveAvg, aboveRatio);
        System.out.println("--------------------");

        System.out.println("序號  分數  等級");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-4d  %-4d  %c%n", i, scores[i], gradeOf(scores[i]));
        }
        System.out.println("====================");
    }

    public static void main(String[] args) {

        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        displayReport(scores);
    }
}
