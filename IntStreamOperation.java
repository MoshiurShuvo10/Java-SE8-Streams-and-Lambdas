import java.util.Arrays ; 
import java.util.stream.IntStream ; 
public class IntStreamOperation{
	public static void main(String[] args){
		int[] numbers = {3,10,6,1,4,8,2,5,9,7};

		//display original values
		System.out.println("------orignial numbers-------");

		IntStream.of(numbers).forEach(number -> System.out.printf("%d ",number));
		System.out.println();

		//count min,max,sum,average of the numbers
		System.out.println("Total numbers present in array: "+IntStream.of(numbers).count()) ; 

		System.out.println("Min: "+IntStream.of(numbers).min().getAsInt());
		System.out.println("Max: "+IntStream.of(numbers).max().getAsInt());
		System.out.println("Average: "+IntStream.of(numbers).average().getAsDouble());

		System.out.println("Calculating sum using reduce() method");
		int sum = IntStream.of(numbers).reduce(0,(x,y)->x+y);

		System.out.println("Calculating sum of squares of values using reduce() method");
		int squareSum = IntStream.of(numbers).reduce(0,(x,y)->x+y*y) ;
		
		System.out.println("Sum: "+sum);
		System.out.println("Sum of square of each value: "+squareSum);
		
		//even values display in sorted order
		System.out.println("Even values in sorted order: ");
		IntStream.of(numbers).filter(number->number % 2 == 0).sorted().forEach(num->System.out.print(num+" "));
		System.out.println();
			
		System.out.println("odd values multiplied by 10, then displayed in sorted order");
		IntStream.of(numbers).filter(number -> number % 2 != 0).map(value->value*10).sorted().forEach(num->System.out.print(num+" "));

		System.out.println("Sum of range 1 to 9 = "+IntStream.range(1,10).sum());
		System.out.println("Sum of 1 to 10 = "+IntStream.rangeClosed(1,10).sum());
		

	}
}
