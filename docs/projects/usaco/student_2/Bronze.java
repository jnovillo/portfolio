import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Bronze {
	private static int [][] pasture; //I think I need pasture to be a field so that the other methods can access it 
	private static int arrayRows = 0;
	private static int arrayColumns = 0;	
	private static int Elevation = 0;
	private static int numStomps = 0;	
					  		  
	public static void main(String[] args) {
	  
    try {
		File file = new File("files/makelake.in");
		Scanner input = new Scanner(file);
	  
		String firstLine = input.nextLine();
		String [] info = firstLine.split(" ");
		arrayRows = Integer.parseInt(info[0]);
		arrayColumns = Integer.parseInt(info[1]);
		Elevation = Integer.parseInt(info[2]);
		numStomps = Integer.parseInt(info[3]);		
		
		pasture = new int [arrayRows][arrayColumns];
	
	
		int rows = 0;
		int columns = 0; 
		while (rows < arrayRows) {
			String line = input.nextLine(); 
			Scanner stringed = new Scanner(line);
			while (columns < arrayColumns) { 
				pasture[rows][columns] = stringed.nextInt(); //populates the array 
				columns++; 
				//System.out.print(pasture[rows][columns] + " ");
			}
			rows++;
			columns = 0;
			//System.out.println();
			
		}
		
		while (input.hasNextLine()) {
			String instructionLine = input.nextLine();
			String [] instructionInfo = instructionLine.split(" ");
			//instructions are given in 1 base so I changed these below to match it
			int digRow = Integer.parseInt(instructionInfo[0])-1;
			int digColumn = Integer.parseInt(instructionInfo[1])-1;
			int digAmount = Integer.parseInt(instructionInfo[2]);
			//System.out.println(instructionInfo[0] + " " + instructionInfo[1] + " " + instructionInfo[2]);
			Dig(digRow, digColumn, digAmount);
	
		//Getting the answer!
		System.out.println(volumeCalculator());

      input.close();//releases the file from your program

		
	}	catch (FileNotFoundException ex) {
      //File not found
	  System.out.println("file not found");
    }
  
  }
   
	public static int highestNum (int rows, int columns){
		int largestNum = 0;
		int rowOffset = 0;
		while ( rowOffset < 3 ){
			int columnOffset=0;
			while (columnOffset < 3){
				if (pasture[rows + rowOffset][columns + columnOffset] > largestNum)
					largestNum = pasture[rows + rowOffset][columns + columnOffset]; 
				columnOffset++;
			}
		rowOffset++;
		}
		return largestNum;
	}
	
	private static void Dig (int rows, int columns, int digAmount){
		int largestNum = highestNum(rows, columns);             
		int rowOffset = 0;							
		while ( rowOffset < 3 ){
			int columnOffset=0;
			while (columnOffset < 3){
				int currNum = pasture[rows + rowOffset][columns + columnOffset];
				if (currNum >= largestNum - digAmount){
					currNum = largestNum - digAmount;
				}
				pasture[rows + rowOffset][columns + columnOffset] = currNum; 
				columnOffset++;
			}
		rowOffset++;
			
		}
  }
	  
	public static int volumeCalculator (){
		int totalDepth = 0;
		int totalVolume = 0;
		for (int finalRows = 0; finalRows < arrayRows; finalRows++){
			for (int finalColumns = 0; finalColumns < arrayColumns; finalColumns++){
				int currNum = pasture[finalRows][finalColumns];
				if (currNum < Elevation){
					totalDepth += Elevation - currNum;
				}	
			}
		}	
		totalVolume = totalDepth * 72 * 72;
		return totalVolume;
	}
			 
}
