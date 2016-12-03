import java.util.*;

public class ReservationManager {

    static ArrayList<Customer> customer_details = new ArrayList<Customer>();
    static ArrayList<Reservation> reservation_list = new ArrayList<Reservation>();;
   

	public void getCustomerInfo()
	{
		//String fName, lName, email, phoneNumber;	
		Customer newCustomer = new Customer();
	
		System.out.print("\nEnter first name of guest: ");
		newCustomer.setFname(IO.readString());
		/*if (ReservationManager.lookupResv(fName, resvs) != null) {
			System.out.println("\nYou already have a reservation.");
			return;
		}*/		
		System.out.print("Enter last name: ");
		newCustomer.setLname(IO.readString());
		System.out.print("Enter your email address: ");
		newCustomer.setEmailAddress(IO.readString());
		System.out.print("Enter your phone number: ");
		newCustomer.setPhoneNumber(IO.readInt());
		
		customer_details.add(newCustomer); // Adds new Customer object to list of customers
		//System.out.println(customer_details);
		System.out.println("customer added");	
		
		for (Customer printCusts : customer_details){
			System.out.println(printCusts.getInfo());
		}
		
	}
	
	public void createReservation(String email){
		Random r = new Random();
		
		
		for(Customer x : customer_details){
			if(x.getEmail().equalsIgnoreCase(email)){
				System.out.println("Email Found");
				
				System.out.println("How many days will you be staying?");
				int days = IO.readInt();
				
				System.out.println("Please select a room type (1.Single, 2.Double, 3.Suite): ");
				int roomOption = IO.readInt();
				
				if(roomOption == 1){
					Single s = new Single();
					
					System.out.println(x.getInfo());
					System.out.println(s.getInfo());
					System.out.println(days);
					
					int resvId = r.nextInt(1000);
					
					Reservation reserved = new Reservation(x, s, days, resvId);
					reservation_list.add(reserved);
					System.out.println(reserved.getInfo());
				}
				if(roomOption == 2){
					Dbl d = new Dbl();
					int resvId = r.nextInt(1000);
					
					Reservation reserved = new Reservation(x, d, days, resvId);
					reservation_list.add(reserved);
					System.out.println(reserved.getInfo());
				}
				if(roomOption == 3){
					Suite st = new Suite();
					int resvId = r.nextInt(1000);
					
					Reservation reserved = new Reservation(x, st, days, resvId);
					reservation_list.add(reserved);
					System.out.println(reserved.getInfo());
					
				}

			}
		
		}
		
	}
	

	public void showCurrentProfile(String email){
		for (Customer profile : customer_details)
		{
			if(profile.getEmail().equalsIgnoreCase(email))
			{
			System.out.println(profile.getInfo());
			}
		}
	}

	public void showCurrentReservation(String email){
	
		for (Reservation show : reservation_list)
		{
			if(show.getEmail().equalsIgnoreCase(email))
			{
				System.out.println("Email Found");
				System.out.println(show.getInfo());
			}
		}		//System.out.println(reservation_list);
	}


	
	public void changeReservation(int resvId) {
		// TODO Auto-generated method stub	
		for (Reservation change : reservation_list){
			if(change.getResvId() == resvId)
			{
				
				System.out.println("Current Reservation: ");
				System.out.println("-------------------- ");
				System.out.println(change.getRoom().getInfo());
				System.out.println("-------------------- ");
				System.out.println("");
					
				
					System.out.println("Options: ");
					System.out.println("1 - Change room type");
					System.out.println("2 - Change days");
					
					System.out.print("\nEnter choice: ");
					int choice = IO.readInt();
					switch (choice) {

					
					case 1:
						System.out.println("Please select a room type (1.Single, 2.Double, 3.Suite): ");
						int roomOption = IO.readInt();
							switch(roomOption){
							
							case 1: 
								change.getRoom().setType("Single");
								change.getRoom().setPrice(49.99);
							}
							
						
						
					break; 
					
					case 2:
				
					break;
				
				
					}
			}
		
		}
	
	}
		
}




	/*
	static Room lookupResv(String name, ArrayList<Reservation> resvs)
	{
		for (int i = 0 ; i < resvs.size(); i++) {
			Room hr = (Room)resvs.get(i);

			if (hr.getGuestName().equalsIgnoreCase(name)) {
				return hr;
			}
		}
		
		return null;
	}
	
	
	static void changeResv(ArrayList<Reservation> resvs)
	{
		Room hr;
		String guestname, roomtype;
		int resvlength;
		
		System.out.print("\nEnter name of guest: ");
		guestname = IO.readString();
		hr = lookupResv(guestname, resvs);
		if (hr == null) {
			System.out.println("\nYou have not yet made a reservation.");
			return;
		}

		while (true) {
			System.out.println("\nReservation for " + guestname + ":");
			System.out.println("Room type: \"" + hr.getRoomType() + "\"");
			System.out.println("Length: " + hr.getReservationLength() + " days");
			System.out.println("Estimated price: $" + hr.getEstimatedPrice());
			
			System.out.println("\nChange Reservation menu:");
			System.out.println("1 - Change room type");
			System.out.println("2 - Change reservation length");
			System.out.println("3 - Return to main menu");
			System.out.println("4 - Quit");

 			System.out.print("\nEnter choice: ");
			int choice = IO.readInt();

			switch (choice) {

				case 1:
					System.out.print("\nEnter type of room: ");
					roomtype = IO.readString();
					hr.setRoomType(roomtype);
					break;
					
				case 2:
					System.out.print("\nEnter reservation length (in days): ");
					resvlength = IO.readInt();
					hr.setReservationLength(resvlength);
					break;
					
				case 3:
					return;
					
				case 4:
					System.exit(0);
					
			}
		}
	}
	
		static void checkOut(ArrayList<Reservation> resvs)
		{
		HotelRoom hr;
		String guestname, roomtype;
		int days;
		
		System.out.print("\nEnter name of guest: ");
		guestname = IO.readString();
		hr = ReservationManager.lookupResv(guestname, resvs);
		if (hr == null) {
			System.out.println("\nYou have not yet made a reservation.");
			return;
		}

		System.out.print("Enter actual number of days stayed: ");
		days = IO.readInt();

		System.out.println("\nPrice at checkout: $" + hr.getActualPrice(days));
		resvs.remove(hr);
		}
	*/

