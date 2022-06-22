package Chapter1;

import java.util.Arrays;

public class URLify {
    public static void main(String[] args) {
        String test = "Mr John Smith    ";

//        System.out.println(urlifyStringBuilder(test));
        urlify(test);
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
            while (idx <= trueLength) {
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

}


