
public class array_mode_count {

    public static void main(String[] args) {

        int[] arr = {3, 7, 3, 1, 1, 1};

        int mode      = arr[0];  
        int modeCount = 0;     

        for (int i = 0; i < arr.length; i++) {

            int count = 0; 

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }

            System.out.printf("比對中：%d 出現次數 = %d%n", arr[i], count);

            if (count > modeCount) {
                mode      = arr[i];
                modeCount = count;
            }
        }

        System.out.printf("眾數為：%d，出現 %d 次%n", mode, modeCount);
    }
}

