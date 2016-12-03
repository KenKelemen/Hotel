
public abstract class Room {
	
	public String roomType;
	protected double roomPrice;
	
	public Room(){

	}

    public double getPrice() {
        return this.roomPrice;
    }

    public String getType() {
        return this.roomType;
    }
    
    public void setType(String tp) {
    	this.roomType=tp;
    }
    
    public void setPrice(double rp){
    	this.roomPrice=rp; 
    }

    public String getInfo() {
        String info = new String("    Rm. #: " + 
                "\nRoom Type: " + roomType +
                "\n    Price: " + roomPrice);
        return info;
    }

	
	
	
}
