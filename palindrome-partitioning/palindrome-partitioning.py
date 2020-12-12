class Solution:
    def partition(self, s: str) -> List[List[str]]:
        def isPalindrome(tempString):
            return tempString==tempString[::-1]
        result=[]
        def helper(index,tempList):
            #Base
            if index==len(s):
                result.append(tempList.copy())
                return
            #Logic
            for i in range(index+1,len(s)+1):
                if isPalindrome(s[index:i]):
                    tempList.append(s[index:i])
                    helper(i,tempList)
                    tempList.pop()
        helper(0,[])
        return result
            
            
        
