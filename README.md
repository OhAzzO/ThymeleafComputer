Creating new project for Thymeleaf
for better structure, wanting to take some code from old project.

Plan.
Create a hello world html and import previous code into this.
I would like this to be more of a build tracker been able to house multiple computer builds with tips regarding
  parts and things to remember.
planning to have a submitting page that will have details about users computer build including parts, overview, price.

Time promoting i would like to make fields for the parts having someway to tell they are compatible or not.


What has been done:
- Created a new project for Thymeleaf and started to proceed with printing out hello world to the localHost
- Packages have been made with the start of a ComputerController
- Computer.html has been made and connected with thymeleaf.org
    created hello world and displayed it as a header.
- Created a ArrayList to test table
- Table working but information from ArrayList is NOT.
- Found an error with names of variable and now fixed.
- Moving on to create database instead of ArrayList.

- Repository made.
- ArrayList has been removed.
- Added Computer properties(computerId, overview, systemComponents and price).
- Added @Column to properties with there own name using c_property (c=computer).
- I have added Lombok to dependencies( as my mentor suggested me to use it).
- Set up test computers to save to the ComputerRepository.
- Using UUID now for auto generated computer id's computer price's, set up and running fine.
- Runs and exampleComputers are show in the h2-console.
- Created ComputerService and made methods for getComputers,getComputer, save and delete.
- A Page layout is been used for getComputers
- H2 console still functioning.

- Created test packages and classes (need to check structure ie- src/test/testPackage).
- Added test case for the save method in the ComputerRepositoryTest and has passed.
- Added test case for ComputerServiceTest - getComputersReturnComputer_WhenComputerDoesExist and test has passed.
- Added test case for ComputerServiceTest - getComputersReturnComputer_WhenComputerDoesNotExist and test has passed.
- Added test case for ComputerServiceTest - save_ReturnWhenComputerIsCreated and test has passed.
- Added test case for ComputerServiceTest - deleteComputer_WhenExists and test has passed.
- Made a Controller package and class ComputerController inside package.
- Created created new resource Directory "templates.computers"
- Added Html file "computerList" to show information.
- Connected to thymeleaf and displaying a simple welcome message.
- Played around to add font to message.
- Added a bootstrap layout and deleted any un wanted properties.
- Put a Exit button (might need to change it to back/home)