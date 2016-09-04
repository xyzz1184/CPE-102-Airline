import java.util.ArrayList;

public class Airplane {

	private SeatRow[] rows = new SeatRow[20];
	
	public Airplane(){
		for(int i=0; i<5; i++)
			rows[i] = new SeatRow("E");
		for(int i=5; i<20; i++)
			rows[i] = new SeatRow("F");
	}
	
	public void printSeats()
	{
		for(int i=0; i<20; i++){
			int j = i+1;
			System.out.print(j);
			System.out.print(":");
			System.out.println(rows[i]);
		}
	}
	
	public void findSeats(int quantity, int cls, int preference)
	{
		boolean seatsTaken = false;
		int firstRow, lastRow, seatCount;		
		if (cls==2){
			firstRow = 0; 
			lastRow = 4;
			}
		else{
			firstRow = 5;
			lastRow = 19;
		}
		
		for(int i=firstRow; i<lastRow && !seatsTaken; i++){
				if(!rows[i].seats[preference-1]){
					boolean seatsAvailable = true;
					for(int j = preference; j<preference + quantity; j++)
					{
						if(rows[i].seats[j-1])
							seatsAvailable = false;
					}
					if(seatsAvailable){
						for(int j = preference; j<preference + quantity; j++)
						{
							rows[i].seats[j-1] = true;
						}
						seatsTaken = true;
					}
				}
				else if(!rows[i].seats[preference-1+cls]){
					boolean seatsAvailable = true;
					for(int j = preference + cls; j<preference + cls + quantity; j++)
					{
						if(rows[i].seats[j-1])
							seatsAvailable = false;
					}
					if(seatsAvailable){
						for(int j = preference +cls; j<preference + cls + quantity; j++)
						{
							rows[i].seats[j-1] = true;
						}
						seatsTaken = true;
					}

				}
		}
	}
	
}
