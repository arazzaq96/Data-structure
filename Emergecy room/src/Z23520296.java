import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.*;abstract
public class Z23520296 {
	

	public static void main(String[] args)  throws Exception {
		PriorityQueue<patient> p = new PriorityQueue<patient>(15,Comparator.comparing(patient::getpriority));
		
		//FileReader File = new FileReader(System.getProperty("user.dir")+ "\\patient.txt");
		FileReader File = new FileReader("patient.txt");
        Scanner sc = new Scanner(File);
		
		
		String line;
		String[] arr;
		
		while(sc.hasNextLine()) {
			ArrayList<String> medicine = new ArrayList<>();
			line  = sc.nextLine();

			arr = line.split(",");
		  String name = arr[0].trim();
      int age = Integer.valueOf(arr[1].trim());
      String gender = arr[2].trim();
      String complaint = arr[3].trim();
      String alertnessLevel = arr[4].trim();
      int heartRate = Integer.valueOf(arr[5].trim());
      String bloodPressure = arr[6].trim();
      int respirationRate = Integer.valueOf(arr[7].trim());
      double temperature = Double.valueOf(arr[8].trim());
      String oxygenSaturation = arr[9].trim();
      String painLevel;
      if (arr[10].trim()=="-"){
        painLevel = "N/A";
      }else{
        painLevel = arr[10].trim();
      }
      String medication = "", doctor = "N/A";
        for(int i = 11; i < arr.length; i++) {
					medicine.add(arr[i].trim());	
				}
        if (checkDr(medicine,"neuro.txt")){
          doctor = "Neurologist";
        }
        if (checkDr(medicine,"cardiac.txt")){
          if (doctor.equals("N/A")){
            doctor = "Cardiologist";
          }else{
            doctor += ", Cardiologist";
          }
        }
        if (checkDr(medicine,"cancer.txt")){
          if (doctor.equals("N/A")){
            doctor = "Oncologist";
          }else{
            doctor += ", Oncologist";
          }
      //  }

      }
        
long waitingTime=0;
      patient Patient = new patient(name, age, gender, complaint, alertnessLevel, heartRate, bloodPressure, respirationRate, temperature, oxygenSaturation, painLevel, doctor,waitingTime);
      p.add(Patient);
      
    
     }
  	  //System.out.println(p.size());
		
      for(int i = 0; i <= 14; i++){
    	  File file = new File(String.valueOf(i + 1) + ".txt");

          try {
        	 System.out.println(p.size());
              FileWriter writer = new FileWriter(file);
              writer.append(p.peek().toString());
             // System.out.println("waiting time" + waitingTime);
              p.poll();
              writer.close();
              
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
      //}     
		}
		System.out.println(p);

	}	
		
	
		public static boolean checkDr(ArrayList<String> medicine, String File) throws Exception {
			//FileReader Files = new FileReader(System.getProperty("user.dir")+ File);
			FileReader Files = new FileReader(File);
      Scanner sc = new Scanner(Files);
			
			String line;
			while(sc.hasNextLine()) {
				line  = sc.nextLine();
        for( String medication : medicine){
          
          if(line.toLowerCase().contains(medication.toLowerCase()) && !medication.trim().equals("-")) {
					  return true;
				  }
        }
				
			}
			return false;
			
		}
}	

		


	

