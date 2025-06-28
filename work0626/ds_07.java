package work0626;

public class ds_07 {
    public static void main(String[] args) {
        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        System.out.println("3×3 陣列內容：");
        for (int i = 0; i < matrix.length; i++) {       
            for (int j = 0; j < matrix[i].length; j++) { 
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); 
        }
    }
}
