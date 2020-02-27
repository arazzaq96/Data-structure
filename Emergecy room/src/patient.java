
// parsing, will parse each element o the basis of , 

public class patient { 

	/*public Patient () {
		this();
	}*/
	long startTime = System.nanoTime();

	public patient (String Name, int age, String gender, String complaint, String AL, int HR, String BP, int RR, double Temperature, String OS, String PL, String Dr, long waitingTime) {
	this.setName(Name);
	this.setage(age);
	this.setgender(gender);
	this.setcomplaint(complaint);
	this.setAL(AL);
	this.setHR(HR);
	this.setBP(BP);
	this.setRR(RR);
	this.setTemperature(Temperature);
	this.setOS(OS);
	this.setPL(PL);
	this.setDr(Dr);
	priority();
	}	
	public String Name;
	public int age;
	public String gender;
	public String complaint;
	public String AL;
	public int HR;
	public int RR;
	public String BP;
	public double Temperature;
	public String OS;
	public String PL;
	public String Medicine;
	public String Dr;
	public int priority;
	long waitingTime;
	
	public String getName() {
		return Name;
	}
	public void setName (String Name) {
		this.Name = Name;
	}
	
	public String getgender() {
		return gender;
	}
	public void setgender (String gender) {
		this.gender = gender;
	}
	public String getcomplaint() {
		return complaint;
	}
	public void setcomplaint (String complaint) {
		this.complaint = complaint;
	}
	public String getAL() {
		return AL;
	}
	public void setAL (String AL) {
		this.AL = AL;
	}
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age= age;
	}
	public int getHR() {
		return HR;
	}
	public void setHR(int HR) {
		this.HR= HR;
	}
	public String getBP() {
		return BP;
	}
	public void setBP(String BP) {
		this.BP= BP;
	}
	public int getRR() {
		return RR;
	}
	public void setRR(int RR) {
		this.RR= RR;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String OS) {
		this.OS= OS;
	}
	public String getPL() {
		return PL;
	}
	public void setPL(String PL) {
		this.PL= PL;
	}
	public double getTemperature() {
		return Temperature;
	}
	public void setTemperature(double Temperature) {
		this.Temperature = Temperature;
	}
	public String getMedicine() {
		return Medicine;
	}
	public void setMedicine(String Medicine) {
	this.Medicine = Medicine;
	}
	public String getDr() {
		return Dr;
		
	}
	public void setDr(String dr) {
		this.Dr = dr;
	}
	public int getpriority() {
		return priority;
	}
	public void setpriority( int priority) {
		this.priority = priority;
	}
	public void setstartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getwaitingTime() {
		return getwaitingTime();
	}
	public void setwaitingTime(long waitingTime) {
		this.waitingTime = waitingTime;
	}

	public String toString() {
    String bpStatus = "Normal";
    String bp = getBP();
    String systolic = bp.split("/")[0];
    String diastolic = bp.split("/")[1];
    if (Integer.parseInt(systolic)<90 || Integer.parseInt(diastolic)<60){
      bpStatus = "Hypotension";
    }
    if (Integer.parseInt(systolic)>130 && Integer.parseInt(diastolic)>80){
      bpStatus = "Hypertension";
    }
    long endTime = System.nanoTime();
    long waitingTime = (endTime - startTime)/1000;
	return "Name: " + getName()+"\r\n" + getage() +", " + getgender()+ ", " + getcomplaint()+"\r\n" + priority+"\r\n" +getDr()+"\r\n"+ "waiting time:" +waitingTime+ "ms"+ "\r\n"+"Alertness Level: " + getAL() +"\r\n"+ "Pain Level: " + getPL()+"\r\n"+ "Vital Sign Assessment" +"\r\n"+"\tHR: " + getHR()  +(getHR()<60?" Bradycardia":(getRR()>20?" Tachycardia":" Normal"))+"\r\n"+ "\tBP: " + getBP() +" "+bpStatus+"\r\n" + "\tRR: " + getRR() +(getRR()<12?" Bradypnea":(getRR()>20?" Tachypnea":" Normal"))+"\r\n" + "\tTemperature: " + getTemperature()+(getTemperature()>98.6?" (Fever)":"") +"\r\n"+ "\tSO2: " + getOS()+(Integer.parseInt(getOS().replace("%",""))<90?" Low":" Normal") +"\r\n"+"\r\n";
	}

	// 
	public void priority() { try {
		if(getHR() > 150 || getHR() < 30 || getRR() < 6 || getAL() =="U") { //Integer.parseInt(getOS())< 90 || Integer.parseInt(getBP()) > 90 || getRR() < 6 || getAL() =="U") {
			priority = 1;
		} 
		else if (getHR() > 100 || getHR() < 30 || getAL() == "V") { // Integer.parseInt(getOS())< 95 ||Integer.parseInt(getOS())< 90 || getAL() == "V" || Integer.parseInt(getBP()) > 90 ) {
			priority=  2;
		}
		else if (getHR() > 50 || getHR() < 100 || getAL() == "A" || getRR() < 20 ||getRR() > 16  || getTemperature() == 98.6) {// Integer.parseInt(getBP()) == 120/80 || getRR() < 20 ||getRR() > 16  || getTemperature() == 98.6 || Integer.parseInt(getOS()) > 95 || Integer.parseInt(getOS()) < 100 ) {
			priority = 3;
		}
		//System.out.println ( Integer.parseInt(getBP()) );

	}

	catch (NumberFormatException e) {

		System.out.println(priority);
	}
	}
	// add toString method to it
	
	//System.out.println(text);
	
}
