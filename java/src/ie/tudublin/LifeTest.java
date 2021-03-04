package ie.tudublin;

import javax.lang.model.util.ElementScanner14;

import processing.core.PApplet;

public class LifeTest extends PApplet {

    int size = 100;
    float cellSize;
    boolean[][] board = new boolean[size][size];
    boolean[][] next = new boolean[size][size];
    
    public void settings()
	{
		size(500, 500);
	}

    public void setup() {
        colorMode(HSB);
        randomize();
        println(countNeighbours(0, 2));
        frameRate(50);

        cellSize = width / (size);
           
    }

    public int countNeighbours(int row, int col)
    {
        int count = 0;
        
        for(int r = row -1 ; r <= row + 1; r ++)
        {
            for(int c = col -1 ; c <= col + 1; c ++)
            {
                if (! (r == row && c == col))
                {
                    if (getCell(board, r, c))
                    {
                        count ++;
                    }
                }
            }
        }
        return count;
    }

    public boolean getCell(boolean[][] board, int row, int col)
    {
        if (row >= 0 && row < size && col >= 0 && col < size )
        {
            return board[row][col];
        }
        else
        {
            return false;
        }        
    }

    public void randomize()
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float dice = random(0.0f, 1.0f);

                board[row][col] = (dice < 0.5f) ? true : false;
            }
        }
    }

    public void drawBoard(boolean[][] board)
    {
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                float x = map(col, 0, size, 0, width);
                float y = map(row, 0, size, 0, height);
                if (board[row][col])
                { 
                    
                    rect(x, y, cellSize, cellSize);
                }
            }
        }
    }

    public void updateBoard(){

        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
               int count = countNeighbours(row, col);
               if(getCell(board, row, col))
               {
                   if(count ==2 || count ==3)
                   {
                       next[row][col] = true;
                   }
                   else
                   {
                       next[row][col] = false;
                   }
               }
               else
               {
                   if (count == 3) // if is dead
                   {
                        next[row][col] = true; //make it alive
                   }
                   else
                   {
                        next[row][col] = false;
                   }
                }
            }
        }
        boolean[][] temp = board;
        board = next;
        next = temp;
    }

    int mode = 0;
    boolean paused = false;
    public void keyPressed() {
        if (keyCode == ' ')
        {
            paused = ! paused;
        }
        
        if (keyCode == '1')
        {
            randomize();
        }
        if (keyCode == '2')
        {
            clear();
        }
            
    }

    public void clear(){
        for(int row = 0 ; row < size ; row ++)
        {
            for (int col = 0 ; col < size ; col ++)
            {
                setCell(board, row, col, true);
            }
        }
    }

    public void setCell(boolean board[][], int row, int col, boolean b)
    {
        if (row >= 0 && row < size && col >= 0 && col < size)
        {
            board[row][col] = b;
        }
    }

    public void draw()
    {	
        background(0);
        drawBoard(board);  
        if(!paused){
            updateBoard();
        }


    }
}
