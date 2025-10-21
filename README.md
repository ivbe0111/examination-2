**Gym Check-in System**

**Description**
A gym had problem with their systems, but an employee had a list of members saved to a file. We were tasked with creating a check in system so that only Active member (There is expired members on the list also) will be allowed to enter the gym. 
The second task was to record all visit so that the personal trainer could get his own list written to a file with members that visits the gym.

**Installation**
Follow these steps to set up the project in IntelliJ IDEA:
**Prerequisites:**
* IntelliJ IDEA (Community or Ultimate Edition)
* Java Development Kit (JDK) 8 or higher (developed and tested with JDK 25)
* Git 

1) **Clone the repository:**
   ```bash
   git clone https://github.com/ivbe0111/examination-2.git```
   Alternatively, download the project as a ZIP file from GitHub and extract it.
2) **Open the project in IntelliJ:**
* Launch IntelliJ Idea
* Select `File -> Open` and navigate to examination-2 folder.
3) **Configure the JDK:**
* Go to `File -> Project Structure`
* Set the Project SDK to JDK25 (or JDK 8 and higher)
* If no JDK is configured, Click `New...` and select the JDK installation path.
4) **Build the project**
* IntelliJ should automatically compile the project. If not, click `Build -> Build Project`.

**Usage**
Run the program in IntelliJ IDEA.
1) Locate the main class (`Main.java`) in the project explorer.
2) Right-click the file and select `Run 'Main.main()'`

**Example Usage:**
Enter a member's Personal number or name. 
If the member is an active member (Time of his last payment is less that 1 year ago) then user will be prompted with members active subscription Type (Standard, Gold or Platina) and member will automaticlly check in.
If the entered name or personal number doesn't exist or the member hasn't payed in the last year, user will be prompted with a red message telling the user that member is either expired or doesn't exist.
Upon closing the program all visits will be written to a file named `PT-File.txt` which will be either created or rewritten in `src/Textfiles`.

**Contact**
For questions or feedback feel free to contact me at:
Email: berezkinivan94@gmail.com
GitHub: ivbe0111
