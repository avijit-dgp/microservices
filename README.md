# This is an POC in microservices architecture. There are Microservice server (currency-exchange-service), consumer (currency-conversion-service) and naming server.

# There are also concept of externalize the configurations and to demonstrate that limits service and config service has been created

In microservices world services needs to talk to each other and based on the traffics services should be able to scale up and down accordingly.
To facilitate this it is necessary to keep track of running instances of the microservices.

netflix-eureka-naming-server is the registry which keeps track of all the running instances of each microservices.

currency-conversion-service will consume the service of currency-exchange-service by getting the running instance details of currency-exchange-service from naming server.

The config server having the configuration of limits service. 
Limits service look for the configuration from the external repository instead of maintaining it's local configuration copy. It is very important in microservices world as if every microservice maintain's it's local copy for configuration, it will be very difficult to update and maintain those.
Apart from that, config server is able to keep configurations for different environments like - DEV, TEST or PROD
