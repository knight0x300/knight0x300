package coding;

public class FoxAndGomoku {
    public String win(String[] board) {
        int n=board.length;
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n-4 ; i++) {
                if(board[row].charAt(i)=='o'&&board[row].charAt(i+1)=='o'&&board[row].charAt(i+2)=='o'&&board[row].charAt(i+3)=='o'&&board[row].charAt(i+4)=='o')
                { System.out.println(i+" "+row);
                return "found";    }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int i = 0; i < n-4 ; i++) {
                if(board[i].charAt(row)=='o'&&board[i+1].charAt(row)=='o'&&board[i+2].charAt(row)=='o'&&board[i+3].charAt(row)=='o'&&board[i+4].charAt(row)=='o')
                { System.out.println(12);
                    return "found";    }
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n ; col++) {
                if(row+4<n&&col+4<n)
                    if(board[col].charAt(row)=='o'&&board[col+1].charAt(row+1)=='o'&&board[col+2].charAt(row+2)=='o'&&board[col+3].charAt(row+3)=='o'&&board[col+4].charAt(row+4)=='o')
                        return "found";
            }
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n ; col++) {
                if(col-4>=0&&row+4<n)
                    if(board[col].charAt(row)=='o'&&board[col-1].charAt(row+1)=='o'&&board[col-2].charAt(row+2)=='o'&&board[col-3].charAt(row+3)=='o'&&board[col-4].charAt(row+4)=='o')
                        return "found";
            }
        }
        return "not found";
    }
}
