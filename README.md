##### Automated Regression
- Based on Serenity+Cucumber4
- Capabilities
  - run predefined suites (smoke,automated,complete feature)
  - do REST API (GET/POST)calls to predefined endpoints
  - check response code, headers,response body using jsonPath
 
- How to run:
  - Prerequisites: maven3, java8 or greater
   - Maven:
    - run command from base project: **mvn clean verify** (will run all testcases with @automated tag by default)
    - if you want to run different tags: ** mvn clean verify -Dcucumber.options="--tags @test"**
    - html report is generated when running previous commands - open target/site/serenity/index.html after run