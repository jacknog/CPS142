import java.io.*;
import java.util.*;
public class Main {

	public static final String SHAPE_FILE = "shapes.csv";

	/**
	 * @Description - "Heart" of the program
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// Create an array of Shape objects
		ArrayList<Sizable> shapes = loadData();

		// Lambda expression that returns the Sizable (i.e., Shape) with the larger width
		SizableSelector maxWidth = (a,b) -> a.width() > b.width() ? a : b;
		
		// Lambda expression that returns the Sizable (i.e., Shape) with the larger height
		SizableSelector maxHeight = (a,b) -> a.height() > b.height() ? a : b;
		
		// Lambda expression that returns the Sizable (i.e., Shape) with the larger area
		SizableSelector maxArea = (a,b) -> a.area() > b.area() ? a : b; // replace null with your Lambda expression
		
		// Lambda expression that returns the Sizable (i.e., Shape) with the larger perimeter
		SizableSelector maxPerimeter = (a,b) -> a.perimeter() > b.perimeter() ? a : b; // replace null with your Lambda expression
		
		// TODO: Implement a SizableReducer using an anonymous inner class.
		// The "reduce" method of this class should implement the following 
		// pseudocode algorithm.
		// 
		// ALGORITHM reduce(array, selector)
		// let selected = first element of array
		// for each sizable in array
		//   selected = selector.select(selected, sizable)
		// endFor
		// return selected
		//		
		SizableReducer reducer = new SizableReducer() {
			@Override
			public Sizable reduce(ArrayList<Sizable> array, SizableSelector selector) {
				Sizable selected = array.get(0);
				for (Sizable sizable : array) {
					selected = selector.select(selected, sizable);
				}
				return selected;
			}
		}; 
		
		// Code to printout a friendly report header
		System.out.println("Shape Analyzer 1.0");
		
		// Code to printout the number of objects in the shapes array;
		System.out.println("Rows scanner: " + shapes.size());
		
		// USE MY CODE BELOW TO PRINT OUT THE REPORT
		// DO NOT CHANGE THESE 4 LINES OF CODE IN ANY WAY EVEN TO CORRECT SYNTAX ERRORS.
		// IF YOU HAVE A SYNTAX ERROR IN ONE OF THESE LINES IT IS BECAUSE OF SOMETHING ELSE.
		System.out.printf("Largest Width:\n%s\n\n", reducer.reduce(shapes,maxWidth));
		System.out.printf("Largest Height:\n%s\n\n", reducer.reduce(shapes,maxHeight));
		System.out.printf("Largest Area:\n%s\n\n", reducer.reduce(shapes,maxArea));
		System.out.printf("Largest Perimeter:\n%s\n\n", reducer.reduce(shapes,maxPerimeter));
		// END: DO NOT CHANGE MY CODE
	
		// Code to printout a friendly "finished" message
		System.out.println("End of report.");

	}

	/** @description - "Soul" of the program
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Sizable> loadData() throws FileNotFoundException {
		
		ArrayList<Sizable> data = new ArrayList<>();
		File file = new File(SHAPE_FILE);
		Scanner sc = new Scanner(file);
		sc.nextLine();
		while (sc.hasNextLine()) {
			Shape shape = ShapeFactory.create(sc.nextLine());
			data.add(shape);
		}
		sc.close();
		return data;
	}
}
