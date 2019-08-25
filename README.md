# Securepay Basket allocation optimization algorithm

## Overview of implementation steps
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

2. Probably, for service layer we can split into more services to achieve the implementation 
in a more decoupling way.

## Get Started
1. You can run it to print results by "gradle run" to check the initial data generation and expected output
2. You can run testing by "gradle test" to check the coverage of unit testing.

## Author
Jeremy Peng