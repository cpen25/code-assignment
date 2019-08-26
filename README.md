# Securepay Basket allocation optimization algorithm

## Test Driven Development
1. TDD requires us to write test cases first , and then functionality implementation to satisfy and pass all test cases.
2. We should write test cases to cover all scenarios could happen. To write code test we can follow
same structures similar as our source code packages to test models, services, controllers and other parts.
3. Achieving TDD, it makes us confident to do CI/CD via running all test cases and make sure nothing broken from new implementation
and updates.
4. TDD should cover several testing types including unit testing, integration/API testing, automation testing and others.
5. My code creates two testing classes which covers model class and service logics.
However, more testing cases should be created to cover all business logic and even exceptions could happen.

## Design patterns
There are a lot of design patters.
Singleton is one basic design pattern which is used most frequently by us.
We can use Singleton pattern to create single global instance of objects to save system resources 
and also make code more reusable and more readable.

However, Singleton design pattern has some challenges as well like it can make over limit for database connections
and it is not good choice for frequently changing objects.

Besides Singleton, I would like to use Observer patter as well in my coding. This pattern will make our 
projects more reactive. RXJAVA is one example for observer pattern. 
Also, in my experience like LiveData is quite good as you can only change the status or value of observed object
and all observing would apply changes accordingly and instantly.

There are many other good patterns which would make our collaboration easier and more standard.

## SOLID principles
In my code, I would try to separate different types of business logic into different service classes.
Each service class should only contain a specific purpose of functions. However, for this project, it does not
have complicated functions. So I just leave generation of data , main sorting logic and printing results in same service class. 
I just extract random data creation logic into a global util class to be called more easily. We should separate 
data initialization , sorting and printing results into different service classes to achieve better single responsibility rule.

Open/closed principle is an important reflection of encapsulation of OOP, we should make our code more extensible
and also in the meantime we should achieve isolation of each modules.

Interface oriented programming is another important principles, it can help us achieve loose coupling and make
our code more readable and easy to maintain. And also make it more extensible. Here, not much function there, 
so I just create one interface and one implementation. We should segregate modules or functions by different interfaces.

In my understanding, dependency inversion principle requires us to use interfaces as much as we can to achieve service 
and functions instead of using implementations in our code. 
Abstractions should not depend on details. Details should depend on abstractions. This principle is important for decoupling.

SOLID principles are good for building clean, high-quality and more readable code standard.


## Overview of algorithm steps
1. Initial creation of 20 categories and 10 items in each category as required

2. Sort all items inside each category by cost(price + shipping cost) from low to high
and by rating from high to low as second sorting criteria

3. Sort all categories by first item(Index 0 item in sorted results from step 2) 
in each category by cost from low to high and by rating from high to low as second criteria

4. Find top X categories from sorted categories results from step 3 whose sum of first item cost 
is less than given value limit.

5. Print out results as required

## Assumption
1. For price , shipping cost and rating value generation. There is no requirement defined for 
the precision of data. Here, I assume it would be integer for each value field. We might need 
to use double or other data type if there is specific precision requirement

## Run project
1. You can run it to print results by "gradle run" to check the initial data generation and expected output
2. You can run testing by "gradle test" to check the coverage of unit testing.

## To be improved
1. Currently it does not satisfy single responsibility principle well, should separate data initialization and sorting main logic 
in two different service. Probably should separate printing func into another single service as well.

2. Should move all random range limit value as params of method instead of leaving fixed value
inside method to make method more flexible

3. Should add more test cases to do more coverage and probably exceptions as well

## Author
Jeremy Peng