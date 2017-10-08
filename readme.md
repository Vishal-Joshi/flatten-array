# Application summary
This application is an implementation of flattening array which is composed of multiple
uni-dimensional arrays.

## Technologies used
*Java 8* for development
*JUnit 4* for unit testing

## Build
The application can be built using `mvn clean package`

## Execution
The application altogether is 1 service which is `FlatteningService`. For execution, you
can execute tests written in `FlatteningServiceTest` by adding your desired use case like
`FlatteningServiceTest#testShouldFlattenArrayOfMultipleArrayOfArrays` and only changing
`inputArray`.
