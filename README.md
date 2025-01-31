# Receipt-Processor

This is a simple Spring Boot web service that processes shopping receipts and calculates reward points based on specific rules.

This guide will help you get started quickly and easily, whether you want to run the app locally or in Docker.

What This Does
-Process Receipts ie. submit a receipt and get a unique ID in response.
-Retrieve Points ie. use the receipt ID to check how many points were awarded.

## Getting Started

You can run the application in two ways (locally or using Docker).


## Run Locally (Maven)

### Prerequisites
 
Make sure you have the following installed on your system:  
✅ Java 17+ (JDK)  
✅ Maven (for building the project) 

### Clone this repository
 ```  
git clone https://github.com/MilkaElias/receipt-processor.git
```
```
cd receipt-processor
```
```
cd receiptProcessor
```

###  Build & Run
```   
mvn clean package
```
```
mvn spring-boot:run
```
   
The app will start on http://localhost:8080/receipts

## Run with Docker

You have to have Docker installed if you wish to run it with docker. 

### Clone this repository
 ```  
git clone https://github.com/MilkaElias/receipt-processor.git
```
```
cd receipt-processor
```
```
cd receiptProcessor
```

### Build the Docker image
```   
docker build -t receipt-processor .
```

### Run the container
```   
docker run -p 8080:8080 receipt-processor
```

The app will start on http://localhost:8080/receipts

You can use data from the [examples](https://github.com/fetch-rewards/receipt-processor-challenge/blob/main/README.md#examples) to test the application
