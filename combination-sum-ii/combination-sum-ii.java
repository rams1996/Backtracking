class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new LinkedList<>();
        if(candidates.length==0)
            return ans;
        Arrays.sort(candidates);
        dfs(target,0,ans,new LinkedList<>(),candidates,0);
        return ans;
        
    }
    public void dfs(int target,int s,List<List<Integer>> ans,LinkedList <Integer> tmp, int candidates[],int index){
        if(target<s)
            return;
        if(target==s && !ans.contains(tmp)){
            ans.add(new LinkedList<>(tmp));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            s+=candidates[i];
            tmp.add(candidates[i]);
            dfs(target,s,ans,tmp,candidates,i+1);
            tmp.removeLast();
            s-=candidates[i];
        }        
        
    }
}
