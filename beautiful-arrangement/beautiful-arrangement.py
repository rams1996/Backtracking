class Solution:
    def countArrangement(self, N: int) -> int:
        visited=set()
        count=0
        def recursion(i):
            nonlocal count
            #Base
            if len(visited)%i!=0 and i%len(visited):
                return
            if len(visited)==N:
                count+=1
                return
            
            
            #Logic
            for i in range(1,N+1):
                if i not in visited:
                    visited.add(i)
                    recursion(i)
                    visited.remove(i)
        recursion(1)
        return count
