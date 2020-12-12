class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result=[]
        def isValidParanthesis(s):
            stack = []
            dict = {"]":"[", "}":"{", ")":"("}
            for char in s:
                if char in dict.values():
                    stack.append(char)
                elif char in dict.keys():
                    if stack == [] or dict[char] != stack.pop():
                        return False
                else:
                    return False
            return stack == []
​
        
        def helper(tempString):
            if len(tempString)==n*2:
                # print(tempString)
                if isValidParanthesis(tempString):
                    result.append(tempString)
                    return
                else:
                    return
            #Logic
            helper(tempString+'(')
            helper(tempString+')')
        helper("")
        return result
        
