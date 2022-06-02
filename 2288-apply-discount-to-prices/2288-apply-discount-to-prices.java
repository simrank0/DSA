class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; ++i) {
            String word  = words[i], num = word.substring(1);
            if (word.length() > 1 && word.charAt(0) == '$' && num.chars().allMatch(d -> '0' <= d && d <= '9')) {
                words[i] = String.format("$%.2f", Long.parseLong(num) * (1 - discount / 100d));
            }
        }
        return String.join(" ", words);
    }
}