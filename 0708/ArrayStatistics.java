public class ArrayStatistics {

    private static void printTable(String[][] rows) {
        int cols = rows[0].length;
        int[] width = new int[cols];
        for (String[] r : rows)
            for (int c = 0; c < cols; c++)
                width[c] = Math.max(width[c], r[c].length());

        for (String[] r : rows) {
            for (int c = 0; c < cols; c++) {
                System.out.printf("%-" + (width[c] + 2) + "s", r[c]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] data = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        int sum = 0, max = data[0], min = data[0];
        int maxIdx = 0, minIdx = 0;
        int evenCnt = 0, oddCnt = 0;

        for (int i = 0; i < data.length; i++) {
            int v = data[i];
            sum += v;
            if (v > max) { max = v; maxIdx = i; }
            if (v < min) { min = v; minIdx = i; }
            if (v % 2 == 0) evenCnt++; else oddCnt++;
        }

        double avg = sum / (double) data.length;

        int aboveAvg = 0;
        for (int v : data) if (v > avg) aboveAvg++;

        String[][] table = {
            {"統計項目",      "結果"},
            {"總和",          String.valueOf(sum)},
            {"平均值",        String.format("%.2f", avg)},
            {"最大值",        max + " (索引 " + maxIdx + ")"},
            {"最小值",        min + " (索引 " + minIdx + ")"},
            {"大於平均的個數", String.valueOf(aboveAvg)},
            {"偶數個數",      String.valueOf(evenCnt)},
            {"奇數個數",      String.valueOf(oddCnt)}
        };

        printTable(table);
    }
}
