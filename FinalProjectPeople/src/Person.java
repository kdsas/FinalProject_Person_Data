import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Person {

	private static String firstName;
    private static String lastName;
    private static int age;
    public Person(String firstName, String lastName, int age) {
  
    	this.firstName    = firstName;
		this.lastName  = lastName;
	    this.age   = age;
    	
    }

   

    @Override
    public String toString() {

    return "Person [First Name=" + firstName + ", Last Name=" + lastName + ", Age=" + age + "]";//Returns info in string format

    }	
    


    public static class AddQueue {
    	ArrayList<Person> queue; // Makes ArrayList of Person class
    	final static ArrayList<Integer> ageList = new ArrayList<>();
    	final static ArrayList<String> nameList = new ArrayList<>();

    	//default constructor
    	AddQueue() {
    	    queue = new ArrayList<>();
    	}
    
    	public void AddAge(Person P) {
    		
    		ageList.add(P.age);//Adds person's age to queue
    	}

     
       public void AddName(Person P) {
    	   
    	   nameList.add(P.lastName);//Adds person's last name to queue
       }
    	public static void sort(List<Integer> list) {
    	    sort(list, 0, list.size() - 1); //performs sort method on list of ages
    	}

    	public static void sort(List<Integer> list, int from, int to) {
    	    if (from < to) {
    	        int pivot = from;
    	        int left = from + 1;
    	        int right = to;
    	        int pivotValue = list.get(pivot);
    	        while (left <= right) {
    	            // left <= to -> limit protection
    	            while (left <= to && pivotValue >= list.get(left)) {
    	                left++;
    	            }
    	            // right > from -> limit protection
    	            while (right > from && pivotValue < list.get(right)) {
    	                right--;
    	            }
    	            if (left < right) {
    	                Collections.swap(list, left, right);
    	            }
    	        }
    	        Collections.swap(list, pivot, left - 1);
    	        sort(list, from, right - 1); // <-- pivot was wrong!
    	        sort(list, right + 1, to);   // <-- pivot was wrong!
    	    }
    	}
    

	public static void main(String[] args) {
		
		
		int counter = 0;// counts number of entries 
		AddQueue addQueue = new AddQueue();// establishes AddQueue class
		 Scanner scanner = new Scanner(System.in); //establishes scanner class for reading input
		
		 while(counter < 5) {
			 
			 System.out.print("Enter first name of the person : ");
		        firstName = scanner.nextLine();
		        System.out.print("Enter last name of the person : ");
		        lastName = scanner.nextLine();
		        System.out.print("Enter age of the person : ");
		        age = scanner.nextInt();
		        scanner.nextLine();
		        Person person = new Person(firstName, lastName, age); //establishes Person class 
		        java.util.Queue<Person> queue = new LinkedList<>(); //establishes Queue class 
		        queue.add(person); //adds Person to Queue class 
		        System.out.println(queue);
		        addQueue.AddAge(person);//AddAge method within AddQueue class
		        addQueue.AddName(person);//AddName method within AddQueue class
		        counter++;
		
		   
				
		       
		 }
		 
		
		 scanner.close();
		    // call quicksort on array data
		     sort(ageList, 0, ageList.size()-1);

		   
		    
		 
		    Collections.sort(ageList, new Comparator<Integer>() {
		    	 
	            public int compare(Integer o1, Integer o2) {// compares integers 
	 
	                return o2 - o1;// Sorts in Descending Order
	 
	            }
	 
	        }); 
		    System.out.println("Sorted Array of Ages in Descending Order ");
		    System.out.println(Arrays.toString(ageList.toArray()));
	       
	 
	        // Sorts Last Names in descending order 
	        Collections.sort(nameList, Collections.reverseOrder()); 
	        System.out.println("Sorted Array of Last Names in Descending Order ");
	        System.out.println(Arrays.toString(nameList.toArray()));
		
	





    }
}
    }



