import java.util.Scanner;

public class AirplaneMenu {
	Scanner reader = new Scanner(System.in);
	Airplane plane = new Airplane();
	
	public void stage1(){
		System.out.println("A)dd  S)how  Q)uit");
		String input = reader.nextLine();
		if(input.equalsIgnoreCase("a")){
			stage2();
		}else if(input.equalsIgnoreCase("s")){
			plane.printSeats();
		}else if(input.equalsIgnoreCase("q")){
			System.exit(0);
		}else{
			System.out.println("Invalid Input");
		}
	}//close printMenu
	
	public void stage2(){
		while(true){
			System.out.println("F)irst  E)conomy");
			String input = reader.nextLine();
			if(input.equalsIgnoreCase("f")){
				stage3(2);
				break;
			}else if(input.equalsIgnoreCase("e")){
				stage3(3);
				break;
			}//close else
			System.out.println("Invalid input, try again.");
		}
		
	}//close stage2
	
	public void stage3(int cls){
		
		while(true){
			System.out.println("Passengers? (1-" + cls + ")");
			int input = reader.nextInt();
			reader.nextLine();//consume
			if(input == cls){
				plane.findSeats(input,cls,1);
				break;
			}else if(input > 0 && input < cls){
				stage4(cls, input);
				break;
			}else{
				System.out.println("Invalid input, try again");
			}//close else
		}//close while
	}//close stage3
	
	public void stage4(int cls, int pass){
		
		while(true){
			if(cls==2)
				System.out.println("A)isle  W)indow");
			else
				System.out.println("A)isle  C)enter  W)indow");
			String input = reader.nextLine();
			if(input.equalsIgnoreCase("a")){
				if(cls == 2){
					plane.findSeats(pass,cls,2);
					break;
				}
				plane.findSeats(pass,cls,3);
				break;
			}else if(input.equalsIgnoreCase("c")){
				plane.findSeats(pass,cls, 2);
				break;
			}else if(input.equalsIgnoreCase("w")){
				plane.findSeats(pass,cls,1);
				break;
			}else{
				System.out.println("Invalid input, try again");
			}//close else
		}//close while
		
	}//close stage4

}
