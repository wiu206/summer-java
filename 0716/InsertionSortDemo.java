class InsertionSortDemo {
    /**
     * 插入排序實作
     * 時間複雜度：最佳 O(n)，最壞 O(n²)，平均 O(n²)
     * 空間複雜度：O(1)
     * 穩定性：穩定排序
     * 特點：對於小規模或部分排序的資料效率很高
     */
    static void insertionSort(int[] array) {
        int n = array.length;
        int totalComparisons = 0;
        int totalShifts = 0;
        
        System.out.println("插入排序過程：");
        System.out.println("已排序部分 | 未排序部分");
        System.out.println("------------|------------");
        
        for (int i = 1; i < n; i++) {
            int key = array[i];  // 當前要插入的元素
            int j = i - 1;       // 已排序部分的最後一個元素索引
            
            System.out.printf("\n第 %d 步：插入元素 %d\n", i, key);
            
            // 顯示當前狀態
            System.out.print("插入前：");
            for (int k = 0; k < i; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.print("| ");
            for (int k = i; k < n; k++) {
                if (k == i) {
                    System.out.print("[" + array[k] + "] ");
                } else {
                    System.out.print(array[k] + " ");
                }
            }
            System.out.println();
            
            // 將比 key 大的元素向右移動
            while (j >= 0 && array[j] > key) {
                totalComparisons++;
                System.out.printf("  比較 %d > %d，將 %d 向右移動\n", 
                                array[j], key, array[j]);
                array[j + 1] = array[j];
                totalShifts++;
                j--;
            }
            
            if (j >= 0) {
                totalComparisons++;  // 最後一次比較
            }
            
            // 插入 key 到正確位置
            array[j + 1] = key;
            System.out.printf("  將 %d 插入到位置 %d\n", key, j + 1);
            
            // 顯示插入後的狀態
            System.out.print("插入後：");
            for (int k = 0; k <= i; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.print("| ");
            for (int k = i + 1; k < n; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }
        
        System.out.printf("\n排序完成！總比較次數：%d，總移動次數：%d\n", 
                        totalComparisons, totalShifts);
    }
    
    /**
     * 二分插入排序：使用二分搜尋找到插入位置
     */
    static void binaryInsertionSort(int[] array) {
        System.out.println("\n二分插入排序過程：");
        
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            
            // 使用二分搜尋找到插入位置
            int insertPos = binarySearchInsertPosition(array, 0, i - 1, key);
            
            System.out.printf("將 %d 插入到位置 %d\n", key, insertPos);
            
            // 將元素向右移動
            for (int j = i; j > insertPos; j--) {
                array[j] = array[j - 1];
            }
            
            array[insertPos] = key;
            System.out.println("目前陣列：" + java.util.Arrays.toString(array));
        }
    }
    
    /**
     * 在已排序的陣列區間中找到插入位置
     */
    static int binarySearchInsertPosition(int[] array, int left, int right, int key) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] <= key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        int[] numbers1 = {64, 34, 25, 12, 22, 11, 90};
        int[] numbers2 = numbers1.clone();
        
        System.out.println("原始陣列：" + java.util.Arrays.toString(numbers1));
        
        // 基本插入排序
        System.out.println("\n=== 基本插入排序 ===");
        insertionSort(numbers1);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers1));
        
        // 二分插入排序
        System.out.println("\n=== 二分插入排序 ===");
        binaryInsertionSort(numbers2);
        System.out.println("最終結果：" + java.util.Arrays.toString(numbers2));
    }
}
/* ======================== 複雜度註解區 ======================== */

/*
 * insertionSort 外層 for 迴圈 Time Complexity: O(n)
 * 說明：從第二個元素開始逐一插入，總共進行 n-1 輪插入操作
 */

/*
 * insertionSort 內層 while 迴圈（移動元素） Time Complexity: O(n) 最壞情況
 * 說明：當陣列為反向排序時，每次插入都需將前面所有元素往後移動，總移動次數為 O(n²)
 */

/*
 * insertionSort 整體時間複雜度： 
 * - 最佳 O(n)：當原本已排序，只需做 n-1 次比較、無移動
 * - 最壞 O(n²)：完全反向排序時，每次插入都需移動整個前段
 * - 平均 O(n²)：一般亂序資料情況，移動與比較次數約為 n²/4
 */

/*
 * insertionSort 空間複雜度：O(1)
 * 說明：僅使用常數額外變數 key、j，原地排序
 */

/*
 * binaryInsertionSort 外層 for 迴圈 Time Complexity: O(n)
 * 說明：總共執行 n-1 次插入操作
 */

/*
 * binaryInsertionSort binarySearchInsertPosition Time Complexity: O(log n)
 * 說明：每次使用二分搜尋尋找插入位置，時間為 O(log i)
 */

/*
 * binaryInsertionSort 元素移動 for 迴圈 Time Complexity: O(n)
 * 說明：最壞情況需將前段所有元素右移，與基本插入排序相同
 */

/*
 * binaryInsertionSort 整體時間複雜度：O(n²)
 * 說明：雖然比較次數降為 O(n log n)，但元素移動仍為 O(n²)
 */

/*
 * binaryInsertionSort 空間複雜度：O(1)
 * 說明：使用常數空間儲存 key、位置指標，為原地排序
 */
