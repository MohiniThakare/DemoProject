package coditation;

public class SeedOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int M = 10, N = 10;
		  
	        
	        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
	            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
	        };
	  
	        // Displaying the grid
	        System.out.println("First Generation");
	        for (int i = 0; i < M; i++)
	        {
	            for (int j = 0; j < N; j++)
	            {
	                if (grid[i][j] == 0)
	                    System.out.print(".");
	                else
	                    System.out.print("*");
	            }
	            System.out.println();
	        }
	        System.out.println();
	        nextGeneration(grid, M, N);
	    }
	  
	    // Function to print next generation
	    static void nextGeneration(int grid[][], int M, int N)
	    {
	        int[][] future = new int[M][N];
	  
	        // Loop through every cell
	        for (int l = 1; l < M - 1; l++)
	        {
	            for (int m = 1; m < N - 1; m++)
	            {
	                
	                int aliveNeighbours = 0;
	                for (int i = -1; i <= 1; i++)
	                    for (int j = -1; j <= 1; j++)
	                        aliveNeighbours += grid[l + i][m + j];
	  
	                
	                aliveNeighbours -= grid[l][m];
	  
	                // Implementing the Rules of Life
	  
	                // Cell is lonely
	                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
	                    future[l][m] = 0;
	  
	                // Cell is overcrowding
	                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
	                    future[l][m] = 0;
	  
	                // unchanged
	                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
	                    future[l][m] = 1;
	  
	                // comes of life
	                else
	                    future[l][m] = grid[l][m];
	            }
	        }
	  
	        System.out.println("Next Generation");
	        for (int i = 0; i < M; i++)
	        {
	            for (int j = 0; j < N; j++)
	            {
	                if (future[i][j] == 0)
	                    System.out.print(".");
	                else
	                    System.out.print("*");
	            }
	            System.out.println();
	        }
	}

}
