class Solution {
    List<List<Integer>> output = new ArrayList<>();
​
    public List<List<Integer>> combine(int n, int k) {
​
        implementation( new ArrayList<Integer>(), 1 , k, n);
        return output;
    }
​
    private void implementation( List<Integer> currentList,int currentValue, int listSize, int maximumValue) {
​
        //if list size is equal to defines size, add list to output
        if(currentList.size() == listSize){
            output.add(new ArrayList<Integer>(currentList));
            return;
        }
​
        //initial value calculation
        int initialValue = currentValue+listSize-1-currentList.size();
        
        // loop maximum value or start value is less than the frame (start value should be lesser than the minimum size element,
        //as they are waste to perform recursive)
        for(int i = currentValue ; i <= maximumValue &&  initialValue<= maximumValue; i++) {
​
            //adding first element to list
            currentList.add(i);
​
            //call recursively as next element as first element
            implementation(currentList, i+1, listSize, maximumValue );
​
            //remove last index value
            currentList.remove(currentList.size()-1);
        }
    }
}
