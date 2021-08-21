Creating new project for Thymeleaf
for better structure, wanting to take some code from old project.

Plan.
Create a hello world html and import previous code into this.
I would like this to be more of a build tracker been able to house multiple computer builds with tips regarding
  parts and things to remember.
planning to have a submitting page that will have details about users computer build including parts, overview, price.

Time promoting i would like to make fields for the parts having someway to tell they are compatible or not.


What has been done:
- Created a new project for Thymeleaf and started to procced with printing out hello world to the localHost
- Packages have been made with the start of a ComputerController
- Computer.html has been made and connected with thymeleaf.org
    created hello world and displayed it as a header.
- Created a ArrayList to test table
- Table working but information from ArrayList is NOT.computer
- Found an error with names of variable and now fixed.
- Moving on to create database instead of ArrayList.
- Repository made.
- ArrayList has been removed.
- Added Computer properties(computerId, overview, systemComponents and price).
- Added @Column to properties with there own name using c_property (c=computer).
- I have added Lombok to dependencies( as my mentor suggested me to use it).
- Set up test computers to save to the ComputerRepository.
- Using UUID now for auto generated computer id's, set up and running fine.
- Runs and testComputers are show in the h2-console.
-