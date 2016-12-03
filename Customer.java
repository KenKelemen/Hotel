
public class Customer {

    protected String firstName;
    protected String lastName;
    protected int phoneNumber;
    private String email;
    
    public Customer() {
        this.firstName = null;
        this.lastName = null;
        this.phoneNumber = 0;
        this.email = null;
    }
  
    
    public Customer(String fName, String lName, int phNum, String mail){
    	this.firstName=fName;
    	this.lastName=lName;
    	this.phoneNumber=phNum;
    	this.email=mail;
    }
	
    
    @Override
	public String toString()
    {
	return (" FirstName: "+ this.firstName +","+
            " \n LastName: "+ this.lastName +","+
            " \n Phone: "+ "$"+ this.phoneNumber +","+
            " \n Email: " + this.email);
	}
	
    public String getInfo() {
        String info = new String(" Name: " + firstName + " " + lastName + "" +
        "\n Phone #: "+ phoneNumber + 
        "\n E-Mail: " + email);
        return info;
    }
    
    public String getfirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public int getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setFname(String fn) {
        this.firstName = fn;
    }
    
    public void setLname(String ln){
    	this.lastName = ln;
    }
    
    public void setPhoneNumber(int n) {
        this.phoneNumber = n;
    }
    
    public void setEmailAddress(String e) {
        this.email = e;
    }
    
 
    
    
}
