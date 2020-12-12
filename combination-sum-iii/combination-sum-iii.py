class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        numbers=[1,2,3,4,5,6,7,8,9]
        
        result=[]
        def backtrack(tempList,index,total):
            tempList=tempList.copy()
            if len(tempList)==k and total==n:
                result.append(tempList)
                return
            if len(tempList)>k or total>n:
                return
            for i in range(index,9):
                tempList.append(numbers[i])
                backtrack(tempList,i+1,total+numbers[i])
                tempList.pop(-1)
        backtrack([],0,0)
        return result
            
                
        
        
        
