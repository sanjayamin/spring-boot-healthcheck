# spring-boot-healthcheck
Spring boot Health check app

Hello World
Using your favorite language (Go, Python, Java, Scala, Bash, etc.), create a hello world web application API that listens on port 8080 and greets a user withÊHello!Êand exposes a health status endpoint.
1. Application url should return a greeting such asÊHello!Êas json or plain text (ex: when you open a browser and navigate toÊhttp://localhost:8080, it should returnÊHello!Êplain text.)

Done

2. Application should provide a health endpoint (http://localhost:8080/healthz) that returns HTTP status (200 OK) which indicates health of the application and returns a valid json with the following information:
o status: status of the app: online, success, OK, error, etc.
o version: running application version (ex: 0.0.1)
o uptime: time duration or time stamp since the app is running (ex: running since YYYY-MM-DD hh:mm:ss) Example: When you open a browser and navigate toÊhttp://localhost:8080/healthzÊit should return:
{
  "status": "OK",
  "version": "0.0.1",
  "uptime": "up since 2020-08-04 08:00:05"
}

//TODO: uptime field need to be corrected

3. What other information would you add to health endpoint json object in step 2? Explain what would be the use case for that extra information?
Information can be added

1. Use case : Get info about CPU usage to find out scaling
- add cpu usage 
2. Use case Ð Check memory consumption and thread statistics to improve app performance and behavior
- add jvm utilization 
3. Use Case Ð check application server usage for optimum configuration
add app server usage 
4. Use Case Ð check db connection and usage
add data source info


4. Create a docker file to build, package, deploy, and run this application locally with Docker.
Done. Please see Dockerfile and step #6 to build and deploy

5. How would you automate the build/test/deploy process for this application? (a verbal answer is enough. installation of CICD is bonus, not required)

Looper and Jenkins can be integrated with Git with branching strategy Ð e.g. dev branch commit can trigger dev build. Stage release can be done with promoting build to stage env. While prod release can be done by cutting release branch and deploying in production.

o What branching strategy would you use for development?

There can be dev, release and master branch configured. For dev env., dev build should be triggered with dev branch commit. For stage, the dev build can be promoted to staging env. For prod, the release branch should be created and promoting build in prod env.

o What CICD tool/service would you use?

Looper/ Jenkins/ GitOps

o What stages would you have in the CICD pipeline?

Dev Build, Stage build and Prod Build

o What would be the purpose of each stage in CICD pipeline

6. Your solution should include a README explaining how to build and run the application with Docker. We will follow the steps you provide in readme file and execute it to verify.
      docker build -t healthchek/spring-boot-app-docker .
      docker run -p 8080:8080 healthchek/spring-boot-app-docker

7. Request / Response

Hello Response
      http://localhost:8080/

Health check Response:

Request: http://localhost:8080/healthz/

Response:
{
    "status": "UP",
    "components": {
        "app": {
            "status": "UP",
            "details": {
                "version": "0.0.1",
                "uptime": "up since:Thu Jan 01 00:00:00 GMT 1970"
            }
        }
    }
}
NOTE: Please submit github repository url for your solution.


