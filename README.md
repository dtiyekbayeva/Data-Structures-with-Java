# Data-Structures-with-Java

Term project - Dinara Tiyekbayeva


Zip file should contain following: 
ReadMe.txt, nba_player_data.csv, nbalogo.jpg, PlayerClass1.java, PlayerClass2.java, GUIandTest.java

csv file source: kaggle.com


1. GUIandTest class should be ran to launch the program. The program reads data from csv file and prints out ouputs.
On the left side java program window will have some data about the dataset, on the right buttons. 
When button is clicked, the left side text will change accordignly.

2. Used PlayerClass1 to create basic Player Constructor and setters/getters.

3. Created PlayerClass2 file just to show inheritance, otherwise it was not needed, 
but I could not think of any other opportunities where I could show inheritance, except extending JFrame.


4. Used split method to process data, it handles null values better than BufferedReader.

5. Used multiple maps where the keys are names and values are data I wanted to process, 
so I could iterate through them and get values associated with the Player's name.

6. Most time was spent to figure out how to handle string-date conversion (birth dates).
I used integers and if/else loops instead of java date packages.
I tried java.date, JODA and java.time.LocalDate API's 
but they failed to accurately convert 2 digit year (I had years 1913 till 2002) to a 4 digit year
(e.g. all of them would convert 1913 to 2013).
