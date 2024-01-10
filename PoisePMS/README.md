# Databases
## Description 
You have been asked to create a project management system for a small structural engineering firm called “Poised”. Poised does the engineering needed to ensure the structural integrity of various buildings. 
They want you to create a Java program that they can use to keep track of the many projects on which they work.

Poised stores the following information for each project that they work on:
- Project number.
- Project name.
- What type of building is being designed? E.g. House, apartment block or store, etc.
- The physical address for the project.
- ERF number.
- The total fee being charged for the project.
- The total amount paid to date.
- Deadline for the project.
- The name, telephone number, email address, and physical address of the architect for the project.
- The name, telephone number, email address, and physical address of the contractor for the project.
- The name, telephone number, email address, and physical address of the customer for the project.

Poised wants to be able to use your program to do the following:
- Capture information about new projects. If a project name is not provided when the information is captured, name the project using the surname of the customer.
  - For example, a house being built by Mike Tyson would be called "House Tyson" and an apartment block owned by Jared Goldman would be called "Apartment Goldman."
- Update information about existing projects. Information may need to be adjusted at different stages throughout the lifecycle of a project. For example, the deadline might change after a meeting with various stakeholders.
- Finalise existing projects. When a project is finalised, the following should happen:
  - The project should be marked as "finalised" in some way and the completion date should be added.
- See a list of projects that still need to be completed (have not been finalised).
- See a list of projects that are past the due date.
- Find and select a project by entering either the project number or project name.

## Importance 
This repository is important as it shows that I am able to persist and manipulate data. This project should make it
clear that I can follow a development process to create a data-driven program that is debugged, tested, refactored, documented and
that meets a client’s specifications. Additonally, this repository shows my understanding and comprehension of Java, SQL, MySQL and databases.

## Installation

To install this project locally, open the repository in your web browser: [Databases](https://github.com/Darren0422/Databases). On the repository page, click on the green "Code" button located near the top-right of the page. From the dropdown menu, select "Download ZIP". This will start the download of the repository as a ZIP file to your computer. Save it on your local storage device. 

<img width="1440" alt="Screenshot 2023-08-13 at 12 25 06" src="https://github.com/Darren0422/Databases/assets/134398985/e9d3fbe6-1b97-4db3-ab67-b40151ac896e">


##  Usage

You may open this file with a code editor of your choice, such as, VSCode and gain access to the written lines of code.

<img width="773" alt="Screenshot 2023-08-13 at 12 28 32" src="https://github.com/Darren0422/Databases/assets/134398985/11a8cf09-9d94-4762-9a14-e40b02531b69">
<img width="775" alt="Screenshot 2023-08-13 at 12 31 17" src="https://github.com/Darren0422/Databases/assets/134398985/cf9e1ddd-8249-4225-bba4-1ea5212f0c03">

Run the program in you editor of choice.

<img width="1022" alt="Screenshot 2023-08-13 at 12 30 11" src="https://github.com/Darren0422/Databases/assets/134398985/6937e73f-6fa4-4c34-95d0-6cd256a0d825">

### Inputs

#### MySQL Database
a MySQL Database called "PoisePMS" was created.

<img width="626" alt="Create DB" src="https://github.com/Darren0422/Databases/assets/134398985/f5769c3e-b00c-444a-a2b4-977cc29d2601">

A table for Projects, Architects, Contractors and Customers was created with various fields shown below. 

<img width="626" alt="Create Tables" src="https://github.com/Darren0422/Databases/assets/134398985/64bd8a35-b794-4d7a-93ec-ac501a5eccd1">

#### User Prompts
To interact with the progam, the user is prompted to enter the number of the aspect of the menu they wish use. The user may also be prompted to enter various information regarding the aspect of the database they are interacting with. 
Example, the user may need to enter the project name they are searching or to enter various fields of information for a Customer they are adding. 

### Interactions
#### Main Menu
The user is prompted to enter the number of the aspect of the menu they wish to use. 

<img width="1093" alt="Screenshot 2023-08-13 at 13 05 29" src="https://github.com/Darren0422/Databases/assets/134398985/0d38f4ad-4aa5-4e2a-9045-374ab73c4254">

#### Adding to the Database
When the user selects the "Add" option, they are then prompted to enter the number of the aspect of the "Add" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 08 54 53" src="https://github.com/Darren0422/Databases/assets/134398985/d35fdfcb-424b-4a5d-9111-d022c9db0c8a">

##### Add Project
When this option is selected, the user is prompted to enter various fields of information:

- Project name
- Building type
- Projects physical address
- ERF number
- Total fee
- Amount still to be paid
- Project deadline date
- Is the project finalised
- Project completion date
- Select a Architect
- Select a Contractor
- Select a Customer

Once all the information is added, the record is added to the "Projects" table in the database. 

##### Add Architect
When this option is selected, the user is prompted to enter various fields of information:

- Architect name
- Architect telephone number
- Architect email address
- Architect physical address

Once all the information is added, the record is added to the "Architects" table in the database. 

##### Add Contractor
When this option is selected, the user is prompted to enter various fields of information:

- Customer name
- Customer telephone number
- Contractor email address
- Contractor physical address

Once all the information is added, the record is added to the "Contractors" table in the database. 

##### Add Customer
When this option is selected, the user is prompted to enter various fields of information:

- Customer name
- Customer telephone number
- Customer email address
- Customer physical address

Once all the information is added, the record is added to the "Customers" table in the database. 

##### Back to Main Menu
When this option is selected, the user is displayed the main menu.
                            
#### Updating the Database
When the user selects the "Update" option, they are then prompted to enter the number of the aspect of the "Update" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 08 56 00" src="https://github.com/Darren0422/Databases/assets/134398985/3798b825-15b3-4c74-b631-d32386632b84">

##### Update a Project record
When the user selects the "Update Project" option, they are then prompted to enter the number of the aspect of the "Update Project" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 08 58 49" src="https://github.com/Darren0422/Databases/assets/134398985/6bb23b2a-6593-48b6-80d5-02f6101eb43f">

###### Update entire Project record
When this option is selected, the user is prompted to enter the "Project ID" they would like to update. They are then prompted to update various fields of information:

- Project name
- Building type
- Projects physical address
- ERF number
- Total fee
- Amount still to be paid
- Project deadline date
- Is the project finalised
- Project completion date
- Select a Architect
- Select a Contractor
- Select a Customer

Once all the information is added, the record is updated in the "Projects" table in the database.

###### Mark a project record as completed
When this option is selected, the user is prompted to enter the "Project ID" they would like to mark as complete. They are then prompted to update various fields of information:

- Project completion date

Once all the information is added, the record is updated in the "Projects" table in the database.

###### Back to Main Menu
When this option is selected, the user is displayed the main menu.

##### Update a Architect record
When this option is selected, the user is prompted to enter the "Architect ID" they would like to update. They are then prompted to update various fields of information:

- Architect name
- Architect telephone number
- Architect email address
- Architect physical address

Once all the information is added, the record is updated in the "Architects" table in the database. 

##### Update a Contractor record
When this option is selected, the user is prompted to enter the "Contractor ID" they would like to update. They are then prompted to update various fields of information:

- Customer name
- Customer telephone number
- Contractor email address
- Contractor physical address

Once all the information is added, the record is updated in the "Contractors" table in the database. 

##### Update a Customer record
When this option is selected, the user is prompted to enter the "Customer ID" they would like to update. They are then prompted to update various fields of information:

- Customer name
- Customer telephone number
- Customer email address
- Customer physical address

Once all the information is added, the record is updated in the "Customers" table in the database. 

##### Back to Main Menu
When this option is selected, the user is displayed the main menu.




                            
#### Deleting from the Database
When the user selects the "Delete" option, they are then prompted to enter the number of the aspect of the "Delete" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 08 56 07" src="https://github.com/Darren0422/Databases/assets/134398985/8d9594d9-a012-4bca-aa78-7aeadea4b26c">

##### Delete a Project record
When this option is selected, the user is prompted to enter the "Project ID" they would like to delete. 
Once selected, the record is deleted from the "Projects" table in the database. 

##### Delete a Architect record
When this option is selected, the user is prompted to enter the "Architect ID" they would like to delete. 
Once selected, the record is deleted from the "Architects" table in the database. 

##### Delete a Contractor record
When this option is selected, the user is prompted to enter the "Contractor ID" they would like to delete. 
Once selected, the record is deleted from the "Contractors" table in the database. 

##### Delete a Customer record
When this option is selected, the user is prompted to enter the "Customer ID" they would like to delete. 
Once selected, the record is deleted from the "Customers" table in the database. 

##### Back to Main Menu
When this option is selected, the user is displayed the main menu.


                            
#### Searching the Database
When the user selects the "Search" option, they are then prompted to enter the number of the aspect of the "Search" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 08 56 14" src="https://github.com/Darren0422/Databases/assets/134398985/a280162c-39c1-4e29-8ebf-ee2a877dff28">

##### Search a Project record
When the user selects the "Search Project" option, they are then prompted to enter the number of the aspect of the "Search Project" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 08 59 53" src="https://github.com/Darren0422/Databases/assets/134398985/172ab383-586d-4db4-a9cf-f3572bcccc78">

###### Search by Project record ID
When this option is selected, the user is prompted to enter the "Project ID" they would like to search. 
If an existing "Project ID" matches the user input, the record is displayed. 
If the "Project ID" does not match the user input, a message displays that it was not found. 

###### Search by Project record Name
When this option is selected, the user is prompted to enter the "Project name" they would like to search. 
If an existing "Project name" matches the user input, the record is displayed. 
If the "Project name" does not match the user input, a message displays that it was not found. 

###### Search by Project records that must still be completed
When this option is selected, all existing records and corresponding information of projects that must still be completed are displayed. 

###### Search by Project records that are past the due date
When this option is selected, all existing records and corresponding information of projects that are past its due date are displayed. 

###### Back to Main Menu
When this option is selected, the user is displayed the main menu.

##### Search a Architect record
When the user selects the "Search Architect" option, they are then prompted to enter the number of the aspect of the "Search Architect" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 09 00 06" src="https://github.com/Darren0422/Databases/assets/134398985/6dffed39-0c95-43ae-b978-7de43d2a4c9d">

###### Search by Architect record ID
When this option is selected, the user is prompted to enter the "Architect ID" they would like to search. 
If an existing "Architect ID" matches the user input, the record is displayed. 
If the "Architect ID" does not match the user input, a message displays that it was not found. 

###### Search by Architect record Name
When this option is selected, the user is prompted to enter the "Architect name" they would like to search. 
If an existing "Architect name" matches the user input, the record is displayed. 
If the "Architect name" does not match the user input, a message displays that it was not found. 

###### Back to Main Menu
When this option is selected, the user is displayed the main menu.

##### Search a Contractor record
When the user selects the "Search Contractor" option, they are then prompted to enter the number of the aspect of the "Search Contractor" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 09 01 17" src="https://github.com/Darren0422/Databases/assets/134398985/8e8d8f3e-e4e6-42f1-9c6f-e451c7e8a811">

###### Search by Contractor record ID
When this option is selected, the user is prompted to enter the "Contractor ID" they would like to search. 
If an existing "Contractor ID" matches the user input, the record is displayed. 
If the "Contractor ID" does not match the user input, a message displays that it was not found. 

###### Search by Contractor record Name
When this option is selected, the user is prompted to enter the "Contractor name" they would like to search. 
If an existing "Contractor name" matches the user input, the record is displayed.  
If the "Contractor name" does not match the user input, a message displays that it was not found. 

###### Back to Main Menu
When this option is selected, the user is displayed the main menu.

##### Search a Customer record
When the user selects the "Search Customer" option, they are then prompted to enter the number of the aspect of the "Search Customer" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 09 01 36" src="https://github.com/Darren0422/Databases/assets/134398985/ac5a8836-6151-4474-8e51-f91b49a624fa">
###### Search by Customer record ID
When this option is selected, the user is prompted to enter the "Customer ID" they would like to search. 
If an existing "Customer ID" matches the user input, the record is displayed.  
If the "Customer ID" does not match the user input, a message displays that it was not found. 

###### Search by Customer record Name
When this option is selected, the user is prompted to enter the "Customer name" they would like to search. 
If an existing "Customer name" matches the user input, the record is displayed.  
If the "Customer name" does not match the user input, a message displays that it was not found. 

###### Back to Main Menu
When this option is selected, the user is displayed the main menu.

##### Back to Main Menu
When this option is selected, the user is displayed the main menu.



#### Viewing the Database
When the user selects the "View" option, they are then prompted to enter the number of the aspect of the "View" menu they wish to use. 

<img width="1084" alt="Screenshot 2023-08-15 at 08 56 21" src="https://github.com/Darren0422/Databases/assets/134398985/5376679b-b86c-40f7-93de-0fc9b2a5e029">

##### View all Project records
When this option is selected, all the records from the "Projects" table in the database is displayed. 

##### View all Architect records
When this option is selected, all the records from the "Architects" table in the database is displayed. 

##### View all Contractor records
When this option is selected, all the records from the "Contractors" table in the database is displayed. 

##### View all Customer records
When this option is selected, all the records from the "Customers" table in the database is displayed. 

##### Back to Main Menu
When this option is selected, the user is displayed the main menu.

#### Exit
When the user selects the "Exit" option, the program terminates.

<img width="1093" alt="Screenshot 2023-08-14 at 10 31 52" src="https://github.com/Darren0422/Databases/assets/134398985/234b4bc9-435e-4a0a-804b-b8ccb113e665">

## Credits
[Darren Chen](https://github.com/Darren0422)
