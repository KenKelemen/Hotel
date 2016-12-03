
public class Reservation {

	protected Customer customer;
	protected Room room;
	protected int days;
	protected int reservationID;
	
	
	public Reservation() {
		this.customer = null;
		this.room = null;
		this.days = 0;
		this.reservationID = 0;
	}
	
	public Reservation(Customer cust, Room rm, int resvDays, int resvId){
		this.customer=cust;
		this.room=rm;
		this.days=resvDays;
		this.reservationID=resvId;
	}
	
	public Room getRoom(){
		return this.room;
	}
	
	public int getDays(){
		return this.days;
	}
	
	public String getEmail(){
		return customer.getEmail();
		
	}
	
	public void setResvDays(int resvDays) {
		this.days=resvDays;
	}
	
	
	public void setResvId (int resvId) {
		this.reservationID=resvId;
	}
	
	public int getResvId () {
		return this.reservationID;
	}
	
	
    public String getInfo() {
        String info = new String("    Name: " + customer.firstName + " " + customer.lastName +
        "\n	  Room: " + room.roomType +
        "\n   Price: $" + room.roomPrice + " per night" +
        "\n   Length of Stay: " + days + " day(s)" +
        "\n   Reservation Id: " + reservationID);
        return info;
    }
	
}