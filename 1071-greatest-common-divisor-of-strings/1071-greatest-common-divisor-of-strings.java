class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String min = str1.length() <= str2.length() ? str1 : str2;
        String max = str1.length() <= str2.length() ? str2 : str1;
        StringBuilder sb = new StringBuilder();
        for (int i = min.length() - 1; i >= 0; i--) {
            if (i != 0 && max.length() % (i + 1) != 0 || min.length() % (i + 1) != 0)
                continue;
            for (int j = 0; j <= i; j++) {
                sb.append(min.charAt(j));
            }
            for (int k = 0; k < max.length(); k++) {
                if (max.charAt(k) != sb.charAt(k % sb.length())
                        || min.charAt(k % min.length()) != sb.charAt(k % sb.length()))
                    break;
                else if (k == max.length() - 1)
                    return sb.toString();
            }
            sb.setLength(0);
        }
        return "";
    }
}