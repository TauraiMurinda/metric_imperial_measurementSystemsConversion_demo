# metric_imperial_measurementSystemsConversion_demo

Technical test instructions:    

    1. Create a Spring Boot application using rest API’s to do a conversions.

    2. Convert Metric to imperial and vice versa. The API must cater for at least 5 conversions (include temperature conversion please).

    3. Ensure that you have proper Unit and Integration testing that accompany the project.

    4. Postman/Jmeter project with your RestAPI's.

    5. Upload your project into your own GIT repository and share the project with us.

    6. The project must be able to run in its own Docker environment

    7. Build system must use Maven.


#definition from wikipedia

Imperial metric system: 

The metric system is decimal because it is always based on powers of 10. The Imperial system is based on the inch / foot / yard / mile (length), the ounce / pound / stone / hundredweight (weight / mass) and the fluid ounce / pint / quart / gallon (volume).


Solution

As per the requirements, a solution was designed that exposed a single REST API with multiple conversions between two known systems, namely metric and imperial.

The application makes use of the Convertor interface which specifies all convertors must be able to convert both to imperial and to metric. Each of the available services implement this interface and contains formulas to conduct conversions.

All endpoints trigger the convertor method on ConvertorService.java which will then by means of the ConvertorFactory.java injects the appropriate implementation of the Convertor.java interface. The endpoint allows a user (by means of triggering a single endpoint) to convert to metric, or to imperial, by specifying the desired system to convert into, as a path variable on the URL.

Further to this, the user may use the same endpoint to trigger conversions between different types of measurements by specifying the type on a different path variable. There are, as mentioned below, 5 units of measurement that may be specified on the endpoint.

The measurements selected were:

Temperature - allowing conversions between Fahrenheit and Celsius (and vice-versa)
Area - allowing conversions between Acre and Hectare (and vice-versa)
Length - allowing conversions between Mile and Kilometer (and vice-versa)
Volume - allowing conversions between Gallon and Litre (and vice-versa)
Weight - allowing conversions between Pound and Kilogram (and vice-versa)
Should a user specify an unknown system or unknown measurement, the API will respond accordingly with an appropriate error response code as well as an error message defining the issue and what are the possible solutions.

An example would be as follows: http://localhost:8080/convert/temperature/imperial/33.2 where temperature would be a known measurement, 33.2 degrees celsius would be the value to convert and imperial would be the system to convert the value into.


Tech Stack

As per the brief, a Spring Boot application has been created using Maven for dependency management and as the build tool.

Unit tests are implemented using JUnit5 with Mockito for unit tests, and a short-lived Spring Boot Test instance being spun up to facilitate integration testing by triggering all predefined endpoints.

The application has also been containerized by means of a Dockerfile located in the base directory. The image can be built from the root directory (demo) using the docker build . command and specifying a tag of your choice. The image can then be spun up using docker run < your_tagged_image > and will be exposed on port 8080 as per the Dockerfile. Alternatively you may use Docker Desktop to manage images and containers once the image is built and tagged.

A Postman collection has been specified which can be used to trigger all predefined endpoints. The file ayo-convertor.postman.json may be imported into Postman for testing purposes and includes two error test cases to highlight the functionality to first time users.


