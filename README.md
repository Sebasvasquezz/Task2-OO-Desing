# Task 2 OO Desing

This project comprises two Java classes, MyLinkedList and Calculate, tailored to facilitate numerical data manipulation within a linked list structure. The MyLinkedList class encapsulates core functionalities such as adding, removing, and accessing elements, along with computing mean and standard deviation. On the other hand, the Calculate class acts as a utility, leveraging the capabilities of MyLinkedList to process numerical data from a file, calculate mean and standard deviation, and present the results.



## Getting Started
Download the project from 
[the repository.](https://github.com/Sebasvasquezz/Task2-OO-Desing)

### Prerequisites

* [Maven](https://maven.apache.org/): Automate and standardize the life flow of software construction

* [Git](https://www.git-scm.com/): Decentralized Configuration Manager

### Installing
1. Maven
    * Download Maven in http://maven.apache.org/download.html
    * You need to have Java installed (7 or 8)
    * Follow the instructions in http://maven.apache.org/download.html#Installation

2. Git
    * Download git in https://git-scm.com/download/win
    * Follow the instructions in https://git-scm.com/book/en/v2/Getting-Started-Installing-Git

## Running the tests

The unit tests included in this project aim to validate the accuracy and reliability of the statistical calculation methods implemented within the Calculate class. These tests comprehensively cover scenarios involving calculation of mean and standard deviation for numerical data stored in a linked list, ensuring the correctness of the underlying algorithms and calculations. For a detailed examination of the test suite, it's recommended to explore the Tests class, which provides insights into the test scenarios and assertions used to verify the functionality of the Calculate class.

To execute the unit tests after cloning the repository, navigate to the project directory in a command prompt and enter the following command:

```
mvn test
```
The execution:

![Execution of unit tests](image.png)


## Design

### Class Diagram
The class diagram was made by using Astah. To go deeper into it, check out the OO-Desing.asta file.

![Class Diagram](image-1.png)

The class diagram depicts two main classes: MyLinkedList and Calculate, along with an inner class Node<T> within the MyLinkedList class.

* MyLinkedList represents a simple linked list data structure capable of storing elements of any type. It contains private members head and size to manage the structure of the linked list. Key functionalities include adding elements to the list, removing elements, accessing elements by index, and computing the mean and standard deviation of the stored elements. Additionally, it implements the Iterable interface to enable iteration over its elements.

* The inner class Node<T> encapsulates the individual nodes of the linked list, holding data of type T and a reference to the next node in the sequence.

* Calculate serves as a utility class for performing calculations on numerical data read from a file. It utilizes the MyLinkedList class to store the numbers read from the file and provides methods for reading numbers from a file, calculating the mean and standard deviation of the numbers, and printing the results to the console. Additionally, it offers a main method to facilitate command-line execution and a method to retrieve the linked list containing the numbers.

This diagram succinctly illustrates the structure and relationships between the classes, highlighting their key attributes and functionalities within the context of the project.

## Build the project
* Run the comand:
    ```
    mvn package
    ```
* Run the application:
    ```
    mvn exec:java -Dexec.args="<pathString>" 
    ```
    or 
    ```
    & 'C:\Program Files\Java\jdk-21\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'E:\ARSW\Tarea2\OO-Desing\target\classes' 'edu.escuelaing.arsw.ASE.app.Calculate' E:\ARSW\Tarea2\OO-Desing\testFiles\Column1.txt 
    ```
* And the execution:

    ![Execution](image-2.png)
### Phase architecture
* To allow running the main application directly from the command line using Maven (mvn exec:java):
    ```
    <build>
    <plugins>
        <plugin>
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>exec-maven-plugin</artifactId>
          <version>3.0.0</version>
          <configuration>
              <mainClass>edu.escuelaing.arsw.ASE.app.Calculate</mainClass>
          </configuration> 
    </plugins>
  </build>
    ```
## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Juan Sebastian Vasquez Vega**  - [Sebasvasquezz](https://github.com/Sebasvasquezz)

## Date

June 15, 2024

## License

This project is licensed under the GNU License - see the [LICENSE.txt](LICENSE.txt) file for details.