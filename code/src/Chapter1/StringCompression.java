package Chapter1;

public class StringCompression {
    public static void main(String[] args){
        String test = "aabcccccaaa";
        //System.out.println(stringCompression(test));

        char[] leetcodeTest = {'a','a','b','b', 'c','c','c'};
        System.out.println(compressOptimized(leetcodeTest));

    }

    public static String stringCompression(String str){
        // sliding window intuition
        StringBuilder sb = new StringBuilder();
        Integer counter = 1;
        int start = 0;
        int end = 0;

        while (end + 1 <= str.length()){
            if (end+1 < str.length() && str.charAt(end) == str.charAt(end + 1)){
                end += 1;
                counter += 1;
            }
            else {
                sb.append(str.charAt(end) + counter.toString());
                start = end + 1;
                end = start;
                counter = 1;
            }
        }


        return sb.toString().length() < str.length() ? sb.toString() : str;

    }

    // leetcode 443
    public static int compress(char[] chars){

        StringBuilder sb = new StringBuilder();
        int counter = 1;
        int start = 0;
        int end = 0;
        int len = 0;

        while (end + 1 <= chars.length){
            if (end+1 < chars.length && chars[end] == chars[end + 1]){
                end += 1;
                counter += 1;
            }
            else {
                if (counter == 1){
                    sb.append(chars[end]);
                    len += 1;
                }
                else {
                    sb.append(chars[end] + String.valueOf(counter));
                    len += 1 + String.valueOf(counter).length();
                }
                start = end + 1;
                end = start;
                counter = 1;
            }
        }

        // modify chars in place
        for(int i = 0; i < sb.length(); i++){
            chars[i] = sb.charAt(i);
        }
        return len;
    }

    public static int compressOptimized(char[] chars) {
        int left = 0;
        int right = 0;
        int i = 0;

        while (right < chars.length){
            int counter = 0;
            while(right < chars.length && chars[right] == chars[left]){
                right += 1;
                counter += 1;
            }

            // match end
            chars[i] = chars[left];
            i += 1;

            if (counter > 1){
                for (char ch: Integer.toString(counter).toCharArray()){
                    chars[i] = ch;
                    i++;
                }
            }

            left = right;
        }

        return i;

    }
    }
