# pico-y-placa-predictor
Project of a "pico y placa" predictor which predicts if a license plate number can be on the road in a specific date and time.
Application design on Java Programming Language using Spring Framework, Spring boot validation, Lombok(for boilerplate code). 
JUnit and Mockito for testing.

Following the next patterns for input:
  - license plate number: "@@@-####" (optional 3 or 4 numbers at the end)
  - date: "dd/MM/yyyy" 
  - time: "hh:mm"

With June 6th, 2022 "pico y placa" rules between time intervals of (7:00am - 9:30am / 16:00pm - 19:30) :
  - Monday -> Plate numbers ending in 1 and 2.
  - Tuesday -> Plate numbers ending in 3 and 4.
  - Wednesday -> Plate numbers ending in 5 and 6.
  - Thursday -> Plate numbers ending in 7 and 8.
  - Friday -> Plate numbers ending in 9 and 0.
  - Saturday -> Free circulation 24 hours.
  - Sunday -> Free circulation 24 hours.

Expected Output:
  - Output will be a string which tells if the license plate number can or can not be on the road in that date and time.

To run tests:
  - Right clic on /src/test/java with coverage of 60% due to app context.
 
To run application:
  - Right clic on /src/main/PicoYPlacaApplication and enter the inputs requested on the console menu.
