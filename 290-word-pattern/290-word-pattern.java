class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<String, String> map = new HashMap<>();
        int i = 0;
        String[] a = s.split(" ");
        for(char ch: pattern.toCharArray()) {
            String c = String.valueOf(ch);
            if(i==a.length) return false;
            if(map.containsKey(a[i]+'1')) {
                if(!map.get(a[i]+'1').equals(c)) return false;
            }
            if(map.containsKey(c)) {
                if(!map.get(c).equals(a[i])) return false;
            }
            else {
                map.put(c, a[i]);
                map.put(a[i]+'1', c);
            }
            i++;
        }
        if(i!=a.length) return false;
        return true;
    }
}