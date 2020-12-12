import java.util.StringJoiner;
​
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> out = new ArrayList<>();
​
        for (int i = 0; i <= 3 && i < s.length(); i++) {
​
            String part1 = s.substring(0, i);
            if (!isValid(part1)) {
                continue;
            }
            for (int j = i + 1; j <= i + 3 && j < s.length(); j++) {
                String part2 = s.substring(i, j);
                if (!isValid(part2)) {
                    continue;
                }
                for (int k = j + 1; k <= j + 3 && k < s.length(); k++) {
                    String part3 = s.substring(j, k);
                    if (!isValid(part3)) {
                        continue;
                    }
                    String part4 = s.substring(k);
                    if (!isValid(part4)) {
                        continue;
                    }
​
                    StringJoiner sj = new StringJoiner(".");
                    sj.add(part1);
                    sj.add(part2);
                    sj.add(part3);
                    sj.add(part4);
​
                    out.add(sj.toString());
                }
            }
​
        }
​
        return out;
    }
​
    static boolean isValid(String part) {
        return part.length() > 0 && part.length() <= 3 && !(part.startsWith("0") && part.length() > 1)
                && Integer.valueOf(part) <= 255;
