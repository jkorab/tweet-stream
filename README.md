# tweet-stream
A sample Spring Boot Kafka Streams app

To execute, in the parent directory of this project create a properties file called ``tweet-stream.properties``
that contains the following Twitter credentials (see https://dev.twitter.com/apps/new):

    accessToken=
    accessTokenSecret=
    consumerKey=
    consumerSecret=

Run the project via:

     mvn spring-boot:run -Dspring.config.location=../tweet-stream.properties

