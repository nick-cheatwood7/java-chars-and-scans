
import java.util.Scanner;

public class Problem1 {
	
	static double calculateShippingCharge(int numItems) {
		
		double totalCharge = 0.00;
		int i = 1;
		
		while(i <= numItems) {
			
			if(i == 1) {
				totalCharge += 10.95;
			} else {
				totalCharge += 2.95;
			}
			
			i++;
			
		};
		
		return totalCharge;
		
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// TODO: read in number from user
		Scanner scan = new Scanner(System.in);
		System.out.println("How many items in order: ");
		
		int num = scan.nextInt();
		scan.close();
		
		// TODO: Calculate shipping charge
		double totalShippingCharge = calculateShippingCharge(num);
		System.out.println("Total shipping charge for " + num + " items: $" +  String.format("%.2f", totalShippingCharge));
	}

}
