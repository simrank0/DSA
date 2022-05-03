package Arrays;

import java.util.*;

public class RemoveDigitFromNumber {
    public String removeDigit(String n, char d) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i<n.length(); i++){
            if(n.charAt(i)==d){
                String sub1 = i-1<0?"":n.substring(0,i-1);
                String sub2 = i+1==n.length()?"":n.substring(i+1);
                int num = Integer.parseInt(sub1+sub2);
                s.add(num);
            }
        }
        System.out.println(s.size());
        return String.valueOf(Collections.max(s));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char d = in.next().charAt(0);
        RemoveDigitFromNumber r = new RemoveDigitFromNumber();
        System.out.println(r.removeDigit(s,d));
    }
}