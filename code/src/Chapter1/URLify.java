package Chapter1;

import java.util.Arrays;

public class URLify {
    public static void main(String[] args) {
        String test = "Mr John Smith    ";

//        System.out.println(urlifyStringBuilder(test));
        urlifyOptimized(test);
    }

    public static String urlifyStringBuilder(String str) {


//        char[] characterArray = str.toCharArray();
//
//        for (int i=0; i < characterArray.length; i++){
//            if (characterArray[i] == ' '){
//                // use ' ' instead of " "
//                characterArray[i] = '%20';
//
//            }
//        }

        // brute force using String Builder instead of character array
        StringBuilder sb = new StringBuilder();
        int trueLen = lastCharIdx(str) + 1;
        for (int i = 0; i < trueLen; i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static int lastCharIdx(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') return i;
        }
        return -1;
    }
    public static void urlify(String str) {
        char[] characterArray = str.toCharArray();
        int trueLength = str.trim().length() - 1;
        int idx = 0;

        for (int i = 0; i < characterArray.length; ) {
            // insert stuff in characterArray
            if (idx <= trueLength) {
                char ch = str.charAt(idx);
                if (ch != ' ') {
                    characterArray[i] = ch;
                    i++;
                } else {
                    characterArray[i] = '%';
                    characterArray[i + 1] = '2';
                    characterArray[i + 2] = '0';
                    i += 3;
                }
                idx += 1;
            }
        }


        System.out.println(characterArray);
    }

    public static void urlifyOptimized(String s){
        char[] arr = s.toCharArray();

        // find true length
        int trueL = 0;
        for(int i = arr.length - 1 ; i >= 0; i--){
            if (arr[i] != ' '){
                trueL = i;
                break;
            }
        }

//        System.out.println(trueL); // 12 correct

        // urlify inplace
        for(int i=arr.length - 1; i >= 0;){
            if (arr[trueL] != ' '){
                arr[i] = arr[trueL];
                trueL -= 1;
                i -= 1;
            }
            else {
                arr[i] = '0';
                arr[i-1] = '2';
                arr[i-2] = '%';
                trueL -= 1;
                i -= 3; // move array 3 times back not trueL
            }
        }

        System.out.println(Arrays.toString(arr));

    }

}


