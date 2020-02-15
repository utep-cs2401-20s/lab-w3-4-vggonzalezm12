import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GOLTester {

    ///////neighbors////////

    @Test
    public int testneighbors() //test with a normal array
    {

        boolean [][] board = new boolean[][] {{false, false, true, false},
                                              {false, true, false , true},
                                              {true, true, true, false},
                                              {true, false, false, false}};
        TorusGameOfLife test1= new TorusGameOfLife(board);
        int row = 0;
        int col = 0;
        assertEquals(1, test1.neighbors(row, col));
    }

    @Test
    public int testneighbors2() // to see if it works with just one element
    {

        boolean [][] board = new boolean[][] {{true}};

        TorusGameOfLife test2= new TorusGameOfLife(board);
        int row = 0;
        int col = 0;
        assertEquals(0, test2.neighbors(row, col));
    }


    @Test
    public int testneighbors3() // to see if it works with non squared  or rectangular array
    {

        boolean [][] board = new boolean[][] {{true, false, false, true},
                                              {false, false, false ,true},
                                              {false, false, false,false},
                                              {true, false, false}};

        TorusGameOfLife test3= new TorusGameOfLife(board);
        int row = 3;
        int col = 4;
        assertEquals(1, test3.neighbors(row, col));
    }

    @Test
    public int testneighbors4() // to see if it works with the default constructor (expected error)
    {

        boolean [][] board = new boolean[][] {{true, false, false, true},
                                                {false, false, false ,true},
                                                {false, false, false,false},
                                                {true, false, false, false}};
        TorusGameOfLife test4= new TorusGameOfLife();
        int row = 3;
        int col = 4;
        assertEquals(2, test4.neighbors(row, col));
    }

    @Test
    public int testneighbors5() // to see if it works with other constructor that take as a parameter integers
    {
        boolean [][] board = new boolean[][]
                        {{true, false, false, true},
                        {false, false, false ,true},
                        {false, false, false,false},
                        {true, false, false, false},
                        {false, false, false, true},
                        {true, false, true, false},
                        {false, false, false, true},
                        {true, false, true, false},
                        {true, true, true, true},
                        {false, true, true, false}};

        int size = 10;
        TorusGameOfLife test5= new TorusGameOfLife(size);
        int row = 9;
        int col = 4;
        assertEquals(2, test5.neighbors(row, col));
    }

    // I couldn't figure it out why the test kept coming out of bounds


    //////// oneStep//////////

    @Test
    public void testoneStep() // to see if it works with other constructor that take as a parameter integers
    {
        int size = 5;
        TorusGameOfLife test5= new TorusGameOfLife(size);
        neighbors(3,2);
        assertEquals(, test5.oneStep());
    }


    //// evolution///////

    @Test
    public void testevolution()   // if it works
    {
        boolean [][] board = new boolean[][]
                {{true, false, false, true},
                {false, false, false ,true},
                {false, false, false,false},
                {true, false, false, false}};

        int n = 5;
        TorusGameOfLife test5= new TorusGameOfLife(board);

        assertEquals(board[][], test5.evolution(n));
    }

    @Test
    public void testevolution2() // if it works with doubles, expected error.
    {
        boolean [][] board = new boolean[][]
                         {{true, false, false, true},
                        {false, false, false ,true},
                        {false, false, false,false},
                        {true, false, false, false}};

        int n = 2.2;
        TorusGameOfLife test5= new TorusGameOfLife(board);

        assertEquals(board[][], test5.evolution(n));
    }

}

}
// I can not make any of them work, honestly I dont undertand how use this test and make them to work