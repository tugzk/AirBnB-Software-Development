# AirBnB-Software-Development

## Group Software Development

### For this coursework we were given the data used in the application, each group had unique data given to them. The data was taken from US cities.

Java application which uses data from Airbnb, analyses it and returns specific results (based on users needs:
average price or by specific city, etc.). Each property has reviews, hosts, and the location of the property. 
Every user who already registered with the application can make a search by location (city) or property type 
(it can be a house/apartment or just a private room) and view the charts and tables with all the data provided by 
the application. Charts are displayed with average daily rates (in specific cities) on both apartments and 
private room for each month. Also, there is a table with all properties given by this search.

Application also makes use of BCrypt to encrypt users sensitive information upon sign up. This is because
user information is stored in a database and for security reasons we cannot have it stored in plain text, 
which is why it was important to encrypt this information.
