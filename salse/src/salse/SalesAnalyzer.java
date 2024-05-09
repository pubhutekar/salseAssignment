package salse;



public class SalesAnalyzer {
	private double[] sales;
	private int numberOfSales;

	public SalesAnalyzer(int numberOfDays) {
		sales = new double[numberOfDays];
		numberOfSales = 0;
	}

	public void addSale(double saleAmount) 
	{
		if (numberOfSales < sales.length) {
			sales[numberOfSales] = saleAmount;
			numberOfSales++;
		} else {
			System.out.println("Sales array is full. Cannot add more sales.");
		}
	}

	public double calculateTotalSales() {
		double totalSales = 0;
		for (double sale : sales) {
			totalSales += sale;
		}
		return totalSales;
	}

	public double calculateAverageDailySales() {
		if (numberOfSales == 0) {
			return 0;
		}
		return calculateTotalSales() / numberOfSales;
	}

	public int findBestSalesDay() {
		if (numberOfSales == 0) {
			return -1; // No sales recorded yet
		}
		double maxSales = sales[0];
		int bestDay = 0;
		for (int i = 1; i < numberOfSales; i++) {
			if (sales[i] > maxSales) {
				maxSales = sales[i];
				bestDay = i;
			}
		}
		return bestDay;
	}

	public int findWorstSalesDay() {
		if (numberOfSales == 0) {
			return -1; // No sales recorded yet
		}
		double minSales = sales[0];
		int worstDay = 0;
		for (int i = 1; i < numberOfSales; i++) {
			if (sales[i] < minSales) {
				minSales = sales[i];
				worstDay = i;
			}
		}
		return worstDay;
	}

	public void displaySalesReport() {
		System.out.println("Total Sales: $" + calculateTotalSales());
		System.out.println("Average Daily Sales: $" + calculateAverageDailySales());
		int bestDay = findBestSalesDay();
		int worstDay = findWorstSalesDay();
		System.out.println("Best Sales Day: Day " + (bestDay + 1) + " ($" + sales[bestDay] + ")");
		System.out.println("Worst Sales Day: Day " + (worstDay + 1) + " ($" + sales[worstDay] + ")");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SalesAnalyzer analyzer = new SalesAnalyzer(30); // Assuming 30 days in a month
		// Adding sample sales data
		analyzer.addSale(1000);
		analyzer.addSale(1500);
		analyzer.addSale(800);
		// Displaying the sales report
		analyzer.displaySalesReport();
	}

}
