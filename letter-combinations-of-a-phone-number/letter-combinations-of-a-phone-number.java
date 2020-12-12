​
class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if(digits==null||digits.length()==0) return res;
        HashMap<Character,String> map = new HashMap<>();
        map.put('0',"");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        return helper(digits,0,map);
    }
    private List<String> helper(String digits, int start,HashMap<Character,String> map) {
        List<String> res = new ArrayList<>();
        String chars = map.get(digits.charAt(start));
        if(start == digits.length()-1) {
            for(int i=0;i<chars.length();i++) {
                res.add(chars.substring(i,i+1));
            }
            return res;
        }
        List<String> subList = helper(digits,start+1,map);
        for(int i=0;i<chars.length();i++) {
            for(int j=0;j<subList.size();j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(chars.charAt(i));
                sb.append(subList.get(j));
                res.add(sb.toString());
            }
        }
        return res;
    }
}
