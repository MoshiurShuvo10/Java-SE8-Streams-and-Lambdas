# Java-SE8-Streams-and-Lambdas
## Functional Programming
Specify **What** to do, Not **How** to do

## External Iteration
```
int[] numbers = {3,4,5,6,3,2,1,56} ; 
int sum = 0 ; 
for(int i = 0 ; i < numbers.length ; i++){
  sum += numbers[i] ; 
  }
```
Here, we're specifying how to iterate the loop, and how to add the values to the sum. Here, i and sum variables are being mutaed repeatedly. Its called external iteration.

## Internal Iteration
We just specify just what to do but not how to do. 
```
IntStream.of(numbers).sum();
```
Here, we're just specifying that we want the sum. How you iterate the data source, that's your business. I just want the result. Its internal iteration.

## Functional Interface
* An interface that contains exactly only one abstract method(may also contain default and static methods).
* Functional Interfaces are also known as **SAM(Single Abstract Method)** interface.

### Six basic generic functional interfaces in java.util.function
Interface |      Method    |Description
----------|----------------|--------------------
```BinaryOperatior<T>``` | T apply(T t1, T t2) |apply() takes two arguments of type T and returns a values of type T. i.e. takes two integers and calculates the sum and return the sum which is a int
```Consumer<T>```|void accept(T)|accept() takes an object of type T and performs a task with T object such as outputting it, or invoking a method of T
```Function<T,R>```|R apply(T)|apply takes T type object as argument and return a value of type R
```Predicate<T>```|boolean test(T)|Tests wheather T type object satisfies a condition or not and returns a boolean value
```Supplier<T>```|T get()|get() takes no argument and returns a value of type T.Its often used to create a collection object in which a stream operation's results are placed.
```UnaryOperator<T>```|T get()|Takes no argument and returns a value of type T

## IntStream Operations
```
int[] numbers = {3,4,5,6,3,2,1,56} ; 
```
To perform stream operations, first convert the array into IntStream. of() method takes an array as input and returns an IntStream for processing the array's values.
```
IntStream.of(numbers)
```
### sum:
```
IntStream.of(numbers).sum();
```
### min
```
IntStream.of(numbers).min().getAsInt()
```
### reduce() method
**Sum of square of each values**
```
IntStream.of(numbers).reduce(0,(x,y)->x+y*y)
```
* First argument of reduce() is a value that helps to start the reduction operation.
* Second argument is an object that implements IntBinaryOperator functional interface. Here, the ```(x,y)->x+y*y)``` lambda inplements the applyAsInt() method.
* 1st call on reduce(): lambda's x value is identity value (0), and y is the first int value in the stream which is 3. Now, on the first call, 3 is added with 0 producing sum= 3. 
* 2nd call on reduce(): Now, identity value is 3. Second value in the stream is 4. 4 is added with 3 and produces sum = 7.
* 3rd call on reduce(): identity value is 7, third value in stream is 5. 5 is added with 7 , produces sum = 12 and so on..

### filter(), sorted(),forEach(),map()
**even values displayed in sorted order**
```
IntStream.of(numbers)
          //filter used to produce a stream that matches a certain condition.
         .filter(number->number%2 == 0) 
         .sorted() // sorting the stream
         .forEach(num -> System.out.print(num+" "));
```
**odd values multiplied by 10 and display in sorted order**
```
IntStream.of(numbers)
         .filter(number->number%2 != 0)
         .map(value -> value * 10) 
         .sorted()
         .forEach(num -> System.out.print(num+" "));
```
