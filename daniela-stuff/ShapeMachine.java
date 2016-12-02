import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ShapeMachine {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//menu
		System.out.print("Shape Machine login");
		System.out.println( );

		for (int i = 1; i <= 3 ; ++i){
			
			System.out.println();

			//ask user for passcode
			System.out.print("What is today's day? ");
			String day = input.next();
			System.out.print("What is today's month? ");
			String month = input.next();
			System.out.print("What is today's year? ");
			String year = input.next();
			
			//find correct date and create users date
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String dateConcat = day + "-" + month + "-" + year;
			
			//comparing
			if (date.compareTo(dateConcat) == 0){
				i = 4;
			}
			else {
				if (i < 3) {
					System.out.print("#ERROR Login attempt #" + i +" Invalid input. Please try again.");			}
					System.out.println();
				}
				if (i == 3) {
					System.out.print("#ERROR 3rd invalid login attempt. Terminating program.");
					System.exit(0);
				}

			}
			//password is correct
			System.out.println("Correct date. Welcome!");
			System.out.println( );
			
			String shape = "";
			
			//menu
			do 
			{
			System.out.println("---Welcome to the Shape Machine---");
			System.out.println("Available Options:");
			
			System.out.println("Circles");
			
			System.out.println("Rectangles");
			
			System.out.println("Triangles");

			System.out.println("Exit");
			
			shape = input.next();
			
			//circles
			if (shape.equals("Circles")){
				System.out.println();
				System.out.print("Circles selected. Please enter the radius: ");
					double radius = input.nextDouble();
					//check negative
					while (radius < 0){
						System.out.print("#ERROR Negative input. Please input the radius again: ");
						radius = input.nextDouble();
					}
					
				//circumference
				double circumference = Math.PI * radius * 2;
				String cText = Double.toString(circumference);
				int cDigitsC = cText.length() - 1;
					
				//area
				double areaCircle = Math.PI * radius * radius;
				String aText = Double.toString(areaCircle);
				int cDigitsA = aText.length() - 1;
				
				//print
				System.out.println("The circumference is: " + circumference);
				System.out.println("The area is: " + areaCircle);
				System.out.println("Total number of digits in the circumference is: " + cDigitsC);
				System.out.println("Total number of digits in the area is: " + cDigitsA);
				System.out.println( );
					
			}
			//rectangles
			else if (shape.equals("Rectangles")){
				System.out.println();
				System.out.print("Rectangles selected. Please enter the 2 sides: ");
					double side1Rekt = input.nextDouble();
					double side2Rekt = input.nextDouble();
					//negative
					while (side1Rekt < 0 || side2Rekt < 0){
						System.out.print("#ERROR Negative input. Please input the 2 sides again: ");
						side1Rekt = input.nextDouble();
						side2Rekt = input.nextDouble();
					}
					
				//area	
				double areaRekt = side1Rekt*side2Rekt;
				String rText = Double.toString(areaRekt);
				int rDigitsA = rText.length()-1;
				
				//perimeter
				double perimeterRekt = (2*side1Rekt) + (2*side2Rekt);
				String pText = Double.toString(perimeterRekt);
				int rDigitsP = pText.length()-1;
				
				//print
				System.out.print("The area is: " + areaRekt);
				System.out.println("\nThe perimeter is: " + perimeterRekt);
				System.out.println("Total number of digits in the area is: " + rDigitsA);
				System.out.println("Total number of digits in the perimeter is: " + rDigitsP);
				System.out.println( );

			}
			//Triangles
			else if (shape.equals("Triangles")){
				System.out.println();
				System.out.print("Triangles selected. Please enter the 3 sides: ");
					double side1T = input.nextDouble();
					double side2T = input.nextDouble();
					double side3T = input.nextDouble();
					//negative
					while (side1T < 0 || side2T < 0 || side3T < 0){
						System.out.print("#ERROR Negative input. Please input the 3 sides again: ");
						side1T = input.nextDouble();
						side2T = input.nextDouble();
						side3T = input.nextDouble();
					}
					
				//checking type of triangle	
				String triangleType = "";
				if (side1T == side2T && side1T == side3T){
					triangleType  = "Equilateral";
				}
				else if (side1T != side2T && side1T != side3T && side2T != side3T){
					triangleType = "Scalene";
				}
				else {
					triangleType = "Isosceles";
				}
				
				//checking validity of triangle
				boolean check1 = side1T + side2T > side3T;
				boolean check2 = side1T + side3T > side2T;
				boolean check3 = side2T + side3T > side1T;
				
					//if triangle is valid
					if (check1 == true && check2 == true && check3 == true){
						double perimeterT = side1T + side2T + side3T;
						//heron's formula
						double s4 = 0.5 * (side1T + side2T + side3T);
						double areaT = Math.sqrt(s4 * (s4 - side1T) * (s4 - side2T) * (s4 - side3T));
						
						String tTextA = Double.toString(areaT);
						int tDigitsA = tTextA.length() - 1;
						
						String tTextP = Double.toString(perimeterT);
						int tDigitsP = tTextP.length() - 1 ;
						
						System.out.println("The triangle is: " + triangleType);
						System.out.println("The perimeter is: " + perimeterT);
						System.out.println("The area is: " + areaT);
						System.out.println("Total number of digits in the perimeter is: " + tDigitsP);
						System.out.println("Total number of digits in the area is: " + tDigitsA);
						System.out.println( );

					}
					//if triangle is not valid
					else{
						System.out.println("#ERROR Triangle is not valid. Returning to menu.");
						System.out.println();
						continue;
					}
			}
			
			//user exits program
			else if (shape.equals("Exit")){
				System.out.println();
				System.out.print("Terminating the program. Have a nice day!");
				System.out.println();

				System.exit(0);
			}
			
			//user types something invalid
			else {
				System.out.println( );
				System.out.println("#ERROR Invalid option. Please try again.");
			}
			
		} while (shape != "Circles" || shape != "Triangles" || shape != "Rectangles" || shape != "Exit");
				

	
	}
}
