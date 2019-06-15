# Follow steps below to start the hystrix demo application
* Get the project in your local machine by cloning or downloading it
* Oen command prompt and navigate to /hystrixDemo directory
* Execute the below command

        gradlew bootrun
     
* If everything fine you would see the application started on port 8081
* Now navigate to below url to check the status/health of the application

     http://localhost:8082/health
 
 * If it's up then hit the endpoint
 
    http://localhost:8081/message
    
  Here you can see the message coming from the application. Hit multiple times then you will see the default message coming out in case
    of fallback.
    
* To see the cicruit breaker data take the url http://localhost:8081/hystrix.stream and put it in hystrixDashboard

Note - Soon I'll be posting youtube video to explain the circuitbreaker with this application.
