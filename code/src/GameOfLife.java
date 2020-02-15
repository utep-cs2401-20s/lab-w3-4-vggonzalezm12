
public class GameOfLife
{
    int size;
    boolean [][] board;
    boolean [][] previousBoard;

   // public static void main (String [] args) {

    public GameOfLife()
    {
    }

    public GameOfLife(int s)
    {
        size = s;
        board = new boolean[size][size];
        previousBoard = new boolean[size][size];
    }
    public GameOfLife( boolean[][] a)
    {
        size = a.length;
        board = new boolean[size][size];
        previousBoard = new boolean[size][size];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                previousBoard[i][j] = a[i][j];
            }
        }
    }

    public boolean[][] getBoard()
    {
        return board;
    }

    public void oneStep ()
    {
        // Rules

        for (int i = 0; i < previousBoard.length; i++)
        {
            for (int j = 0; j < previousBoard[i].length; j++)
            {
                boolean alive = true;
                int hold = neighbors(i, j);

                if (previousBoard[i][j] == alive)
                {
                    if (hold <= 1 || hold > 3)
                    {
                        board[i][j] = !alive;
                    }
                    else if (hold == 2 || hold == 3)
                    {
                        board[i][j] = alive;
                    }
                }

                else if (previousBoard[i][j] == !alive)
                {
                    if (hold == 1 || hold == 2)
                    {
                        board[i][j] =!alive;
                    }
                    else if (hold >= 3)
                    {
                        board[i][j] =alive;
                    }
                }

            }
        }

        for(int i = 0; i < this.size; i++)
        {
            for(int j = 0; j < this.size; j++)
            {
                this.previousBoard[i][j] = board[i][j];
            }
        }

    }

    //this wont work you need to set multiple boundaries
    public int neighbors( int row, int col)
    {
        boolean alive = true;
        int countAlive = 0;

        // current: up, down, left, right, diagonal_down_right, diagonal_ down_ left, diagonal_ up_left, diagnoal_up_right
        //  Manuel Gutierrez  helped me with this part

        // up
        if (( row > 0) && (previousBoard[row - 1][col]) == alive)
            countAlive++;
       // down
        if ((col > previousBoard[row].length) && (previousBoard[row+1][col]) == alive)
            countAlive++;
       //left
        if ((col > 0) && (previousBoard[row][col -1]) == alive)
            countAlive++;
        // right
        if ((col < previousBoard.length-1) && (previousBoard[row][col + 1]) == alive)
            countAlive++;
       //  diagonal_down_right
        if ((( row <previousBoard.length -1) && (col < previousBoard[row].length -1) && (row > 0) && (col > 0 )) && (previousBoard[row + 1][col+1]) == alive)
            countAlive++;
        //diagonal_ down_ left
        if ((( row < previousBoard.length -1) && (col <previousBoard[row].length -1 ) && (row > 0 ) && ( col > 0)) && (previousBoard[row+1][ col - 1]) == alive)
            countAlive++;
        //diagonal_ up_left
        if ((( row <previousBoard.length -1) && (col <previousBoard[row].length -1) && (row > 0) && (col > 0)) && (previousBoard[row -1][col - 1]) == alive)
            countAlive++;
        //diagonal_up_right
        if ((( row < previousBoard.length -1) && (col < previousBoard[row].length -1) && (row > 0) && (col > 0)) && (previousBoard[row - 1][col + 1]) == alive)
            countAlive++;

        return countAlive;
    }
    public void evolution(int n)
    {

        while (n > 0) {
                oneStep();
            n--;
        }
    }

//}
}