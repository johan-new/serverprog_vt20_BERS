# Back-End Raging Snackers

## Customer Management System

With this system you can add, update and locate costumers in a database.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install, the software and how to install them

```
A computer with atleast Windows 95', MacOS or Linux
```

```
Wildfly version 19.0.1
- Install according to wildfly documentation. 
```

```
Local Database of your choice (We used Derby)
- Follow the instructions on the one you chosed. 
```

```
IDE - Eclipse, IntelliJ etc. 
```

```
Webrowser - Chrome, Firefox etc
```

### Installing and Deployment

Here's a step by step guide to get this project running 


```
First fork and download the project here on GitHub 
```

```
Get your database of choice up and running on port 50000 (We chosed Derby for our project).
```

```
Get your Wildfly up and running on localhost:8080
```

```
Run build.xml in your IDE, or right click on ServerManangementApplication and export jar-files to wildfly/deployments. It should deploy to the server. 
```

```
Open the browser and insert http://127.0.0.1:8080/CustomerManagement/webservice/customers 
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Built With

* IDE Eclipse 
* IDE IntelliJ
* Git Bash 
* Ant

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Version BERS 1.0 

## Authors 
* **Erik Manfredsson** 
* **Johan Nyberg** 
* **Simon Södergren** 


## License

This project is licensed under the GOAT License 

## Acknowledgments

* Hat tip to anyone whose code was used
