# Personal expenses management console application

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development.

### Prerequisites

Java 8 System Requirements
Detailed information on system requirements for Java 8 are available at Java 8 Supported System Configurations.

Windows
Windows 10 (8u51 and above)
Windows 8.x (Desktop)
Windows 7 SP1
Windows Vista SP2
Windows Server 2008 R2 SP1 (64-bit)
Windows Server 2012 and 2012 R2 (64-bit)
RAM: 128 MB
Disk space: 124 MB for JRE; 2 MB for Java Update
Processor: Minimum Pentium 2 266 MHz processor
Browsers: Internet Explorer 9 and above, Firefox
Mac OS X
Intel-based Mac running Mac OS X 10.8.3+, 10.9+
Administrator privileges for installation
64-bit browser
A 64-bit browser (Safari, for example) is required to run Oracle Java on Mac. 

Linux
Oracle Linux 5.5+1
Oracle Linux 6.x (32-bit), 6.x (64-bit)2
Oracle Linux 7.x (64-bit)2 (8u20 and above)
Red Hat Enterprise Linux 5.5+1, 6.x (32-bit), 6.x (64-bit)2
Red Hat Enterprise Linux 7.x (64-bit)2 (8u20 and above)
Suse Linux Enterprise Server 10 SP2+, 11.x
Suse Linux Enterprise Server 12.x (64-bit)2 (8u31 and above)
Ubuntu Linux 12.04 LTS, 13.x
Ubuntu Linux 14.x (8u25 and above)
Ubuntu Linux 15.04 (8u45 and above)
Ubuntu Linux 15.10 (8u65 and above)
Browsers: Firefox

### Installing

Go to project :

1. open cmd
2. cd <project directory>
3. mvn clean install
4. java -jar -Dapple.awt.UIElement="true" target/Expenses-1.0-SNAPSHOT.jar -h

Or

Open and run the Project in Eclipse or IntelliJ IDEA.

## Commands

Solution provide a command-line application that supports following commands:
● add 2017-04-25 12 USD Jogurt — adds expense entry to the list
  of user expenses. Expenses for various dates could be added in
  any order. Command accepts following parameters:
  2017-04-25 — is the date when expense occurred
  12 — is an amount of money spent
  USD — the currency in which expense occurred
  Jogurt — is the name of product purchased
● list — shows the list of all expenses sorted by date
● clear 2017-04-25 — removes all expenses for specified date, where:
  2017-04-25 — is the date for which all expenses should be removed
● total PLN — this command should take a list of exchange rates from http://fixer.io, calculate the total amount of money spent and
  present it to user in specified currency, where:
  PLN — is the currency in which total amount of expenses should be presented
  
## Authors

Stepan Makara [MonstraL] (https://github.com/MonstraL)
