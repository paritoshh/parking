**Parking Problem:**

1) I used simple core java **JDK-11** with few libraries like Lombok, Junit etc.
2) I tried to make this application '**Fully Configurable**' as much as possible.
3) Like Costing system is fully configurable (First 2Days and Cost everything is configurable), nothing is hardcoded.
4) I used MULTI-THREADING to incorporate **MULTIPLE-GATES** for parking.
5) **NUMBER OF PARKING GATES** is also configurable.
6) I tested with a file including **99961 commands** and noted the performance with multithreading by putting SLA logs.
7) There are separate service for each functionality.
8) I have hard-coded the Vehicle color to 'Red' as it is not present in the input param, however it can also be a part of input.
9) **Junit test cases** are written for each and every service, including all **positive** and **negative scenarios**.
10) **CUSTOM EXCEPTION** with ERROR_CODES and ERROR_MESSAGES are created and used in multiple exceptional scenarios.


**Steps to run the application:**

1) It's a maven project and I am uploading in to git-hub,so will need maven and git in your system.
2) Take a pull and run below command on source-code 
            `mvn clean install`
3)  Above command will download all the required libraries in your system.
4) I have already put two sample input files in the resources folder. [file_inputs.txt & file_inputs_HUGE_DATA.txt]
5) You need to run the Application main() method to start the application.
6) Application will pick the file_inputs.txt file and provide the expected output.
7) As already mentioned I put most of the things configurable, you can change those and test the application with the desired inputs.

Hope you will like it and I believe that is always a scope of improvement.
Appreciate suggestions.

Thanks
Paritosh Agarwal 