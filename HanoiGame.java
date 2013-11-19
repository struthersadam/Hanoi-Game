import java.util.Scanner;
import java.util.Vector;

public class HanoiGame {
	
	public static Stack<Integer> pole1 = new Stack<Integer>();
	public static Stack<Integer> pole2 = new Stack<Integer>();
	public static Stack<Integer> pole3 = new Stack<Integer>();
	public static Object[] aPole1;
	public static Object[] aPole2;
	public static Object[] aPole3;
	public static int rings;
	
	
	public static void main (String[] args){
		aPole1 = pole1.toArray();
		Scanner in = new Scanner(System.in);
		System.out.println("How many rings would you like to play with?");
		rings = in.nextInt();
		while (rings < 3){
			System.out.println("Invalid ring count, try again: ");
			rings = in.nextInt();
			
		}
		for (int i = rings; i > 0; i--){
			pole2.push(new Integer(i));
		}
		while (true){
			System.out.println("Current Board: ");
			printBoard();
			System.out.println("Press Enter.");
			in.nextLine(); // Clear buffer
			
			while (true){
				System.out.println("Select your first pole (L = LEFT, C = CENTER, R = RIGHT):");
				String firstP = in.nextLine();
				while (!firstP.equalsIgnoreCase("L") 
						&& !firstP.equalsIgnoreCase("C") 
						&& !firstP.equalsIgnoreCase("R"))
				{
					System.out.println("Invalid selection, try again: ");
					firstP = in.nextLine();
				}
				
				System.out.println("Select your second pole");
				String secondP = in.nextLine();
				
				while ((!firstP.equalsIgnoreCase("L") 
						&& !firstP.equalsIgnoreCase("C") 
						&& !firstP.equalsIgnoreCase("R")) || firstP.equalsIgnoreCase(secondP))
				{
					System.out.println("Invalid selection, try again: ");
					firstP = in.nextLine();
				}
				
				if (firstP.equalsIgnoreCase("L")){
					if (secondP.equalsIgnoreCase("C")){
						if ((!pole1.isEmpty() && pole2.isEmpty()) || pole1.peek() < pole2.peek()){
							pole2.push(pole1.pop());
							break;
						}
						else{
							System.out.println("Invalid Move");
						}
					}
					else if (secondP.equalsIgnoreCase("R")){
						if ((!pole1.isEmpty() && pole3.isEmpty()) || pole1.peek() < pole3.peek()){
							pole3.push(pole1.pop());
							break;
						}
						else{
							System.out.println("Invalid Move");
						}
					}
				}
				else if (firstP.equalsIgnoreCase("C")){
					if (secondP.equalsIgnoreCase("L")){
						if ((!pole2.isEmpty() && pole1.isEmpty()) || pole2.peek() < pole1.peek()){
							pole1.push(pole2.pop());
							break;
						}
						else{
							System.out.println("Invalid Move");
						}
					}
					else if (secondP.equalsIgnoreCase("R")){
						if ((!pole2.isEmpty() && pole3.isEmpty()) || pole2.peek() < pole3.peek()){
							pole3.push(pole2.pop());
							break;
						}
						else{
							System.out.println("Invalid Move");
						}
					}
				}
				else if (firstP.equalsIgnoreCase("R")){
					if (secondP.equalsIgnoreCase("C")){
						if ((!pole3.isEmpty() && pole2.isEmpty()) || pole3.peek() < pole2.peek()){
							pole2.push(pole3.pop());
							break;
						}
						else{
							System.out.println("Invalid Move");
						}
					}
					else if (secondP.equalsIgnoreCase("L")){
						if ((!pole3.isEmpty() && pole1.isEmpty()) || pole3.peek() < pole1.peek()){
							pole1.push(pole3.pop());
							break;
						}
						else{
							System.out.println("Invalid Move");
						}
					}
				}		
		}
			if(pole1.size() == rings || pole3.size() == rings){
				System.out.println("\nYOU WIN BRO!");
				printBoard();
				System.exit(0);
			}
	}
		
}// End Main
	
	public static void printBoard(){
		aPole1 = new Object[rings];
		aPole2 = new Object[rings];
		aPole3 = new Object[rings];
		aPole1 = pole1.toArray(aPole1);
		aPole2 = pole2.toArray(aPole2);
		aPole3 = pole3.toArray(aPole3);
		for (int i = 0; i < aPole1.length; i++){
			if (aPole1[i] == null){
				aPole1[i] = 0;
			}
			if (aPole2[i] == null){
				aPole2[i] = 0;
			}
			if (aPole3[i] == null){
				aPole3[i] = 0;
			}	
		}
		System.out.println("\t|\t|\t|");
		for (int i = rings-1; i >= 0; i--){
			System.out.println("\t" + aPole1[i] + "\t" + aPole2[i] + "\t" + aPole3[i]);
		}
		System.out.println("\t|\t|\t|");
		System.out.println("\t-----------------");
	}
}
