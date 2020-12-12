class Solution:
    def totalNQueens(self, n: int) -> int:
        def isSafe(row,column,board):
            r=row
            c=column
            while((r>=0) and (c>=0) and (r<n) and (c<n)):
                if board[r][c]=='Q':
                    return False
                r-=1
            r=row
            c=column
            while((r>=0) and (c>=0) and (r<n) and (c<n)):
                if board[r][c]=='Q':
                    return False
                r-=1
                c+=1
            r=row
            c=column
            while((r>=0) and (c>=0) and (r<n) and (c<n)):
                if board[r][c]=='Q':
                    return False
                r-=1
                c-=1
            return True
                
        
        
        
        
        result=[]
        def placeQueen(row,board):
            # print(board)
            
            for column in range(n):
                if row==n:
                    result.append(board)
                    return
                if isSafe(row,column,board):
                    newBoard=[x.copy() for x in board]
                    newBoard[row][column]='Q'
                    placeQueen(row+1,newBoard)
        
        board=[['.' for i in range(n)] for i in range(n)]
        placeQueen(0,board) 
        ans=[]
