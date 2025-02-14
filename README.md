
# Traini8 Problem Statement

This is the backend project for Traini8, a startup focused on building a registry for government-funded training centers.

# Setup Instructions

Prerequisites
1. Java Development Kit (JDK) version 8 or higher
2. Apache Maven
3. MySQL Server
4. IDE (Eclipse, IntelliJ IDEA, etc.)

# Steps
Clone the Repository: 
git clone "https://github.com/sahil-1208/Traini8-Problem-Statement.git"

Database Setup:
Create a MySQL database schema named training_center.

Update the application.yml file located in src/main/resources with your database connection details.
Build the Project

Run the Application:Run the Spring Boot application using Maven:

# API Endpoints

Access the API:Once the application is running, you can access the API endpoints using 
http://localhost:8080/api/v1/training/center.


Create a new training center : 

POST: http://localhost:8080/api/v1/training/center/add

 Get a list of all stored training centers : 

GET: http://localhost:8080/api/v1/training/center/get/pgNo/{pageNumber}/pgSize/{pageSize}/field/{fieldName}

# Sample Request And Response(JSON)

POST: http://localhost:8080/api/v1/training/center/add
 

JSON Request :

{
    "centerName": "Delhi Tech Academy",
    "address": {
        "detailedAddress": "45 Tech Park Road",
        "city": "New Delhi",
        "state": "Delhi",
        "pinCode": "110001"
    },
    "studentCapacity": 150,
    "coursesOffered": [
        "Full Stack Development",
        "Data Science",
        "Cyber Security"
    ],
    "email": "delhitech@gmail.com",
    "phoneNumber": "9876543210"
}

JSON Response :

{
    "status":"OK",
    "message":"Training Center Added ,Training Center Code : TC6LYPL3HCOF"
}


GET: http://localhost:8080/api/v1/training/center/get/pgNo/2/pgSize/6/field/centerName?order=desc


JSON Response :

[
    {
        "centerCode": "TC02RR5KAH1X",
        "centerName": "Delhi Tech Academy",
        "address": {
            "id": 4,
            "detailedAddress": "45 Tech Park Road",
            "city": "New Delhi",
            "state": "Delhi",
            "pinCode": "110001"
        },
        "studentCapacity": 150,
        "coursesOffered": [
            "Full Stack Development",
            "Data Science",
            "Cyber Security"
        ],
        "createdOn": 1739528441,
        "email": "delhitech@gmail.com",
        "phoneNumber": "9876543210"
    },
    {
        "centerCode": "TCEYLMHV0MHE",
        "centerName": "Chennai Developer Hub",
        "address": {
            "id": 7,
            "detailedAddress": "99 IT Avenue",
            "city": "Chennai",
            "state": "Tamil Nadu",
            "pinCode": "600050"
        },
        "studentCapacity": 180,
        "coursesOffered": [
            "MERN Stack",
            "Django",
            "Big Data Analytics"
        ],
        "createdOn": 1739528466,
        "email": "chennaidevhub@xyz.com",
        "phoneNumber": "9753102468"
    },
    {
        "centerCode": "TCNYE7FTPP53",
        "centerName": "Chandigarh Skill Center",
        "address": {
            "id": 12,
            "detailedAddress": "88 IT Hub Road",
            "city": "Chandigarh",
            "state": "Chandigarh",
            "pinCode": "160017"
        },
        "studentCapacity": 150,
        "coursesOffered": [
            "C++",
            "Embedded Systems",
            "IoT"
        ],
        "createdOn": 1739528519,
        "email": "chandigarhskill@training.com",
        "phoneNumber": "9988556677"
    },
    {
        "centerCode": "TC6LYPL3HCOF",
        "centerName": "Bhopal Tech Training",
        "address": {
            "id": 13,
            "detailedAddress": "101 Code Avenue",
            "city": "Bhopal",
            "state": "Madhya Pradesh",
            "pinCode": "462001"
        },
        "studentCapacity": 130,
        "coursesOffered": [
            "Cyber Security",
            "Ethical Hacking",
            "Networking"
        ],
        "createdOn": 1739528527,
        "email": "bhopaltechtrain@academy.com",
        "phoneNumber": "9871234560"
    },
    {
        "centerCode": "TCQ0HC65J63C",
        "centerName": "Bangalore Code Academy",
        "address": {
            "id": 6,
            "detailedAddress": "22 Software Lane",
            "city": "Bangalore",
            "state": "Karnataka",
            "pinCode": "560100"
        },
        "studentCapacity": 120,
        "coursesOffered": [
            "Kubernetes",
            "ReactJS",
            "Spring Boot"
        ],
        "createdOn": 1739528459,
        "email": "bangaloreca@edu.com",
        "phoneNumber": "9123456789"
    },
    {
        "centerCode": "TCLOZPFSN9YI",
        "centerName": "Ahmedabad Training Institute",
        "address": {
            "id": 11,
            "detailedAddress": "12 Learning Street",
            "city": "Ahmedabad",
            "state": "Gujarat",
            "pinCode": "380015"
        },
        "studentCapacity": 220,
        "coursesOffered": [
            "DevOps",
            "AWS",
            "Terraform"
        ],
        "createdOn": 1739528511,
        "email": "ahmedabadinstitute@learn.com",
        "phoneNumber": "9911223344"
    }
]


