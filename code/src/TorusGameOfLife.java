
public class TorusGameOfLife extends GameOfLife {

    public TorusGameOfLife()
    {

    }


    public TorusGameOfLife(int s)
    {
        size = s;
        board = new boolean[size][size];
        previousBoard = new boolean[size][size];
    }
    public TorusGameOfLife( boolean[][] a)
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


        // up
        if (( previousBoard[(row -1 )% previousBoard.length][col])  == alive)
            countAlive++;
        // down
        if ((previousBoard[(row +1) % previousBoard.length][col]) == alive)
            countAlive++;
        //left
        if ((previousBoard[row][(col -1) % previousBoard[row].length-1]) == alive)
            countAlive++;
        // right
        if ((previousBoard[row][(col +1) % previousBoard[row].length-1]) == alive)
            countAlive++;
        //  diagonal_down_right
        if ((previousBoard[(row + 1) % previousBoard.length-1][(col+1) % previousBoard[row].length-1]) == alive)
            countAlive++;
        //diagonal_ down_ left
        if ((board[(row+1) % board.length-1][(col - 1) % previousBoard[row].length-1]) == alive)
            countAlive++;
        //diagonal_ up_left
        if ((previousBoard[(row -1)% previousBoard.length-1][(col - 1) % previousBoard[row].length-1]) == alive)
            countAlive++;
        //diagonal_up_right
        if ((previousBoard[(row - 1) % previousBoard.length-1][(col + 1) % previousBoard[row].length-1]) == alive)
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



}
