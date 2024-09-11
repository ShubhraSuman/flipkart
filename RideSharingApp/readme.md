### Ride Sharing Application

Description:
Implement a ride sharing application. Below are the expected features from the system. Features:
1. The application allows users to share rides on a route.
2. Users can either offer a shared ride (Driver) or consume a shared ride (Passenger).
3. Users can search and select one from multiple available rides on a route with same source and destination.

Requirements:

1. Application should allow user onboarding.
   a. add_user(user_detail)
   i. Add basic user details
   ii. Add user's vehicle(s) details
2. User should be able to offer a shared ride on a route with details.
   a. offer_ride(ride_detail)
   T. Ride will have details like vehicle, origin, destination, start time, ride time, available seats. (A ride will have no intermediate stops.)
3. Users can select a ride from multiple offered rides using a selection strategy. (A user can only select a ride for himself (only for 1 person)) select_ride(source, destination, selection_strategy)
   a.
   i. One with fastest ride i.e. shortest ride time.
   ii. One which reaches earliest i.e. earliest end time.
4. Find total fuel saved by any passenger. (Only a passenger will save X units of fuels for a shared ride time of X hours.)
5. Find total rides offered/taken by a user.
   Other Notes:
1. Write a driver class for demo purpose. Which will execute all the commands at one place in the code and have test cases.
2. Do not use any database or NoSQL store, use in-memory data-structure for now.
3. Do not create any UI for the application.
4. Please prioritize code compilation, execution and completion.
5. Work on the expected output first and then add bonus features of your own.
   Expectations:
1. Make sure that you have a working and demo-able code.
2. Make sure that code is functionally correct.
3. Use of proper abstraction, entity modelling, separation of concerns is required.
4. Code should be modular, readable and unit-testable.
5. Code should easily accommodate new requirements with minimal changes.
6. Proper exception handling is required.
7. Concurrency Handling (BONUS)
````   Sample Test Cases:
Onboard 5 users

   a. add_user("Rohan, M, 36"); add_vehicle("Rohan, Swift, KA-01-12345)
   b. add_user("Shashank, M, 29′′); add_vehicle("Shashank, Baleno, TS-05-62395)
   c. add_user("Nandini, F, 29)
   d. add_user("Shipra, F, 27"); add_vehicle("Shipra", Polo, KA-05-41491); add_vehicle("Shipra, Scooty KA-12-12332") e. add_user("Gaurav, M, 29);
   Published by Google Drive - Report Abuse $
   (7:12,79%))) Sun Sep 27 6:06 PM ✡
   Updated automatically every 5 minutes
```