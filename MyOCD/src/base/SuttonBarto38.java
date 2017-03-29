package base;

public class SuttonBarto38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[][] oldGrid = new float[5][5];
		float[][] newGrid = new float[5][5];
		float g = (float) 0.9;
		
		// Load Grid
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				oldGrid[i][j] = 0;
			}
		}
		
		// Run the algorithm m times
		int m = 10;
		for(int l = 1; l < m; l++) {
			// Compute New Grid
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					float[] values = new float[4];
					// Compute special cases
					if (i == 0 && j == 1) {
						values[0] = (float) (0.25 * (10 + g * oldGrid[3][1]));
						values[1] = values[0];
						values[2] = values[0];
						values[3] = values[0];					
					}
					else if (i == 0 && j == 3) {
						values[0] = (float) (0.25 * (5 + g * oldGrid[2][3]));
						values[1] = values[0];
						values[2] = values[0];
						values[3] = values[0];
					}
					else {
						// Compute value when going North
						if(i-1 < 0) {
							values[0] = (float) (0.25 * (-1 + g * oldGrid[i][j]));
						}
						else {
							values[0] = (float) (0.25 * (0 + g * oldGrid[i-1][j]));
						}
						
						// Compute value when going East
						if(j+1 > 4) {
							values[1] = (float) (0.25 * (-1 + g * oldGrid[i][j]));
						}
						else {
							values[1] = (float) (0.25 * (0 + g * oldGrid[i][j+1]));
						}
						
						// Compute value when going South
						if(i+1 > 4) {
							values[2] = (float) (0.25 * (-1 + g * oldGrid[i][j]));
						}
						else {
							values[2] = (float) (0.25 * (0 + g * oldGrid[i+1][j]));
						}
						
						// Compute value when going West
						if(j-1 < 0) {
							values[3] = (float) (0.25 * (-1 + g * oldGrid[i][j]));
						}
						else {
							values[3] = (float) (0.25 * (0 + g * oldGrid[i][j-1]));
						}
					}
					// Compute values of New grid for value function
					newGrid[i][j] = values[0] + values[1] + values[2] + values[3];
					
					// It needs new implementation for optimal value
//					// Compute values of New grid for optimal value function
//					float max = values[0];
//					for (int counter = 1; counter < values.length; counter++)
//					{
//					     if (values[counter] > max)
//					     {
//					      max = values[counter];
//					     }
//					}
//					newGrid[i][j] = max;
				}
			}
			
			int a = l - 1;
			System.out.println("PRINTING GRID FOR k = " + a);
			
			// Print Old Grids' values
			for(int i = 0; i < 5; i++){
				int k = i + 1;
				System.out.println("Line: " + k);
				for(int j = 0; j < 5; j++){
					System.out.println("OldGrid" + i + j + " = " + oldGrid[i][j]);
				}
				System.out.println("\n");
			}
			
			System.out.println("\n\n\n");
			System.out.println("PRINTING GRID FOR k = " + l);
			
			// Print New Grids' values
			for(int i = 0; i < 5; i++){
				int k = i + 1;
				System.out.println("Line: " + k);
				for(int j = 0; j < 5; j++){
					System.out.println("NewGrid" + i + j + " = " + newGrid[i][j]);
				}
				System.out.println("\n");
			}
			
			// Replacing oldGrid with newGrid
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					oldGrid[i][j] = newGrid[i][j];
				}
			}
		}
		
	}

}