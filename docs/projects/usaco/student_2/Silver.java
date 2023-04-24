import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Silver {
	private static int arrayRows = 0;
	private static int arrayColumns = 0;
	private static int Time = 0;
	private static int [][] oldPasture;
		
	private static int startingRows = 0;
	private static int startingColumns = 0;
	private static int endingRows = 0;
	private static int endingColumns = 0;
		
	private static int [][] newPasture; 
	
	public static void main(String[] args) {
		try {
			File file = new File("files/ctravel.in");
			Scanner input = new Scanner(file);
		  
			String firstLine = input.nextLine();
			String [] info = firstLine.split(" ");
			arrayRows = Integer.parseInt(info[0]);
			arrayColumns = Integer.parseInt(info[1]);
			Time = Integer.parseInt(info[2]);
			
			oldPasture = new int [arrayRows][arrayColumns];
			
			int rows = 0;
			int columns = 0; 
			while (rows < arrayRows) {
				String line = input.nextLine(); 
				while (columns < arrayColumns) { 
					if (line.substring(columns, columns+1).equals("*"))
						oldPasture[rows][columns] = -1; //populates the array  
					else if (line.substring(columns, columns+1).equals("."))
						oldPasture[rows][columns] = 0;
					//System.out.print(oldPasture[rows][columns] + " ");
					columns += 1;
				}

				rows = rows + 1;
				columns = 0;
				//System.out.println();
			}
			//System.out.println();
			
			String lastLine = input.nextLine();
			String [] startAndEnd = lastLine.split(" ");
			//The instructions given in the file are 1 base but my arrays are 0 based so 
			//I changed the values to fit it here
			startingRows = Integer.parseInt(startAndEnd[0]) - 1; 
			startingColumns = Integer.parseInt(startAndEnd[1]) - 1;
			endingRows = Integer.parseInt(startAndEnd[2]) - 1;
			endingColumns = Integer.parseInt(startAndEnd[3]) - 1;
			
			oldPasture[startingRows][startingColumns] = 1;
			
			//printing number of paths, the answer!
			numPaths();
			
		
		}	catch (FileNotFoundException ex) {
		  //File not found
		  System.out.println("file not found");
		}
	}

	private static void numPaths(){
		newPasture = new int [arrayRows][arrayColumns];
		int timeCounter = 0;
		while (timeCounter < Time){
			for (int finalRows = 0; finalRows < arrayRows; finalRows++){
				for (int finalColumns = 0; finalColumns < arrayColumns; finalColumns++){
					int sum = 0;
					if (oldPasture[finalRows][finalColumns] == 0){
						/**
						Checking for corners of the array 
						*/
						if (finalRows == 0 && finalColumns == 0) {
							if (oldPasture[finalRows+1][finalColumns] > 0)
								sum += oldPasture[finalRows+1][finalColumns];
							if (oldPasture[finalRows][finalColumns+1] > 0)
								sum += oldPasture[finalRows][finalColumns+1];
						}
						
						else if (finalRows == 0 && finalColumns == 9) {
							if (oldPasture[finalRows+1][finalColumns] > 0)
								sum += oldPasture[finalRows+1][finalColumns];
							if (oldPasture[finalRows][finalColumns-1] > 0)
								sum += oldPasture[finalRows][finalColumns-1];
						}
						
						else if (finalRows == 9 && finalColumns == 0) {
							if (oldPasture[finalRows-1][finalColumns] > 0)
								sum += oldPasture[finalRows-1][finalColumns];
							if (oldPasture[finalRows][finalColumns+1] > 0)
								sum += oldPasture[finalRows][finalColumns+1];
						}
						
						else if (finalRows == 9 && finalColumns == 9) {
							if (oldPasture[finalRows-1][finalColumns] > 0)
								sum += oldPasture[finalRows-1][finalColumns];
							if (oldPasture[finalRows][finalColumns-1] > 0)
								sum += oldPasture[finalRows][finalColumns-1];
						}
					
						/**
						Checking for edges of the array
						*/
					
						else if (finalRows == 0 && finalColumns != 0 && finalColumns != 9) {
							if (oldPasture[finalRows+1][finalColumns] > 0)
								sum += oldPasture[finalRows+1][finalColumns];
							if (oldPasture[finalRows][finalColumns+1] > 0)
								sum += oldPasture[finalRows][finalColumns+1];
							if (oldPasture[finalRows][finalColumns-1] > 0)
								sum += oldPasture[finalRows][finalColumns-1];
						}
						
						else if (finalRows == 9 && finalColumns != 0 && finalColumns != 9){
							if (oldPasture[finalRows-1][finalColumns] > 0)
								sum += oldPasture[finalRows-1][finalColumns];
							if (oldPasture[finalRows][finalColumns+1] > 0)
								sum += oldPasture[finalRows][finalColumns+1];
							if (oldPasture[finalRows][finalColumns-1] > 0)
								sum += oldPasture[finalRows][finalColumns-1];
						}
							
						else if (finalColumns == 0 && finalRows != 0 && finalRows != 9){
							if (oldPasture[finalRows+1][finalColumns] > 0)
								sum += oldPasture[finalRows+1][finalColumns];
							if (oldPasture[finalRows-1][finalColumns] > 0)
								sum += oldPasture[finalRows-1][finalColumns];
							if (oldPasture[finalRows][finalColumns+1] > 0)
								sum += oldPasture[finalRows][finalColumns+1];
						}
						
						else if (finalColumns == 9 && finalRows != 0 && finalRows != 9){
							if (oldPasture[finalRows+1][finalColumns] > 0)
								sum += oldPasture[finalRows+1][finalColumns];
							if (oldPasture[finalRows-1][finalColumns] > 0)
								sum += oldPasture[finalRows-1][finalColumns];
							if (oldPasture[finalRows][finalColumns-1] > 0)
								sum += oldPasture[finalRows][finalColumns-1];
						}
							
						/** 
						all other cases that are not on an edge or corner
						*/ 
 						else {
							if (oldPasture[finalRows+1][finalColumns] > 0)
								sum += oldPasture[finalRows+1][finalColumns];
							if (oldPasture[finalRows-1][finalColumns] > 0)
								sum += oldPasture[finalRows-1][finalColumns];
							if (oldPasture[finalRows][finalColumns+1] > 0)
								sum += oldPasture[finalRows][finalColumns+1];
							if (oldPasture[finalRows][finalColumns-1] > 0)
								sum += oldPasture[finalRows][finalColumns-1];
						}
						newPasture[finalRows][finalColumns] = oldPasture[finalRows][finalColumns] + sum;  
					}
					
					//changing positive values to 0 for the next move
					else if (oldPasture[finalRows][finalColumns] > 0)
						newPasture[finalRows][finalColumns] = 0;
					
					//making trees stay as trees
					else if (oldPasture[finalRows][finalColumns] == -1)
						newPasture[finalRows][finalColumns] = -1;

				}
			}
			timeCounter++;
			if (timeCounter < Time){
				copyArray(newPasture, oldPasture);
				newPasture = new int [arrayRows][arrayColumns];
			}
		}
		System.out.println(newPasture[endingRows][endingColumns]);
		//System.out.println();
	}
	
	//copies values from old array to new array
	public static void copyArray (int [][] sourceArray, int [][] destinationArray){
		
		for (int finalRows = 0; finalRows < arrayRows; finalRows++){
				//System.out.println("finalRows is " + finalRows);
			for (int finalColumns = 0; finalColumns < arrayColumns; finalColumns++){
				destinationArray[finalRows][finalColumns] = sourceArray[finalRows][finalColumns];
				//System.out.print(destinationArray[finalRows][finalColumns] + " ");
			}
			//System.out.println();
		}
		//System.out.println();
		//System.out.println();
	}
	
}
