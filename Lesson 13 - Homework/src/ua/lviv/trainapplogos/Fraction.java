package ua.lviv.trainapplogos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Fraction {
	private ArrayList <Deputy> deputieslist = new ArrayList<Deputy>();
	private String name;
	
	public Fraction(String name) {
		super();
		this.name = name;
	}
	
	//	Add deputy
	public void addDeputy(Deputy deputy) {
		this.deputieslist.add(deputy);
	}
	
	//	Add deputy from Keyboard
	public void addDeputyFromKeyboard() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("> Input name of the deputy:");
		String name = sc.nextLine(); 
		
		System.out.println("> Input surname of the deputy:");
		String surname = sc.nextLine(); 
		
		System.out.println("> Input weight of the deputy:");
		int weight = Integer.valueOf(sc.nextLine()); 
		
		System.out.println("> Input height of the deputy:");
		int height = Integer.valueOf(sc.nextLine()); 
		
		System.out.println("> Input grafter state of the deputy:");
		System.out.println("  Input 'y' if deputy is grafter else input 'n':");
		String grafter = sc.nextLine(); 
		boolean isgrafter = (grafter.equalsIgnoreCase("y")) ? true : false;
	
		this.deputieslist.add(new Deputy(name, surname, weight, height, isgrafter));
		
		System.out.println("> Input bribe for the deputy:");
		int bribe = Integer.valueOf(sc.nextLine()); 
		deputieslist.get(deputieslist.size() - 1).GiveBribe(bribe);
	}
	
	
	
	// Remove deputy
	public void removeDeputyByKeyboard() {
		Iterator<Deputy> iterator = deputieslist.iterator(); 
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		
		System.out.println("> Processing operation of removing of deputy");
		System.out.println("  Input name of the deputy to remove:");
		String name = sc.nextLine(); //nextLine()
		System.out.println("  Input surname of the deputy to remove:");
		String surname = sc.nextLine(); //nextLine()
		boolean exists = false;
		
		System.out.println("   Searching deputy to remove...");
		
		while(iterator.hasNext()) {
			Deputy next = iterator.next();  
			if (next.getName().equalsIgnoreCase(name)) {
				if (next.getSurname().equalsIgnoreCase(surname)) {
					iterator.remove();
					System.out.println("  Deputy " + next.getName() + " " + next.getSurname() + " was found and deleted! ");
					exists = true;
					break;
				}
			}
		}
		
		if (!exists) System.out.println("There isn't such deputy as " + name + " " + surname);
	}
	
	public void outputAllGraftersOfFraction() {
		Iterator<Deputy> iterator = deputieslist.iterator(); 
		int ind = 0;
		
		System.out.println("> The list of all grafters of Fraction '" + this.name + "':");
		
		while(iterator.hasNext()) {
			
			Deputy next = iterator.next();  
			if (next.isGrafter()) {
				ind++;
				System.out.println("  " + ind + ") " + next);
			}
		}
	}
	
	public Deputy outputBiggestGrafterOfFraction() {
		Iterator<Deputy> iterator = deputieslist.iterator(); 
		Deputy biggestGrafter = new Deputy();
		
		if (deputieslist.size() == 0) {
			System.out.println("The list of deputies is empty. Can't find the biggest grafter!");
			return biggestGrafter;
		} else {
			System.out.println("> Finding the biggest grafter of Fraction '" + this.name + "'...");
			Deputy next = iterator.next();  
			biggestGrafter = next;
			
			while(iterator.hasNext()) {
				 next = iterator.next();  
				 if (next.isGrafter() && (next.getBribeSize() >= biggestGrafter.getBribeSize()))  {
					 biggestGrafter = next;
				 }
			}
			
			
			if (biggestGrafter.isGrafter()) {
				if (biggestGrafter.getBribeSize() > 0) {
					System.out.println("The biggest grafter of this Fraction is " + biggestGrafter);
					return biggestGrafter;
				} else {
					System.out.println("Wow! There aren't any grafter deputates in Fraction '" + 
							this.name + "' who have bribe!");
					return new Deputy();
				}	
			} else {
				System.out.println("Wow! There aren't any grafters in Fraction '" + this.name + "'!");
				return new Deputy();
			}
		}
	}

	public void outputAllDeputiesOfFraction() {
		Iterator<Deputy> iterator = deputieslist.iterator(); 
		int ind = 0;
		
		System.out.println("> List of all deputies of Fraction '" + this.name + "':");
		while(iterator.hasNext()) {
			ind++;
			Deputy next = iterator.next();  
			System.out.println("  " + ind + ") " + next);
		}
	}
	
	public void clearFractionFromDeputies() {
		this.deputieslist.clear();
		System.out.println("> The list of deputies of Fraction '" + this.name + "' is cleared!");
	}

	public ArrayList<Deputy> getDeputiesList() {
		return deputieslist;
	}

	public void setDeputiesList(ArrayList<Deputy> deputieslist) {
		this.deputieslist = deputieslist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
