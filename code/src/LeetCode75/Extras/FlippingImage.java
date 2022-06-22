package LeetCode75.Extras;

import java.util.Arrays;

public class FlippingImage {
    // letcode 832
    public static void main(String[] args) {
        int[][] image = {{1,1,0}, {1,0,1}, {0,0,0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }

    static int[][] flipAndInvertImage(int[][] image) {
        // reverse ~ horizontal flip
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][image[0].length - 1 - j];
                image[i][image[0].length - 1 - j] = temp;
            }
        }
        // inverting the image
        for (int i = 0; i < image.length; i++){
            for (int j = 0; j < image[i].length; j++){
                if (image[i][j] == 1)
                    image[i][j] = 0;
                else
                    image[i][j] = 1;
            }
        }
        return image;
    }
}
