# s7-ODOS-testing
Automation Testing

# Instructions for running

open ---> cmd   <--- run the execution

then:

Maven execution commands:

`mvn verify `                                                          //  this command will execute all tests
`mvn verify -Dcucumber.filter.tags="@regression"`            //will execute tests with the given tags
`mvn clean`                                        //  will clean the target folder, which holds all the logs, reportings etc
`mvn clean verify`                                  //   will clean and execute tests
`mvn clean verify -Dcucumber.filter.tags="@regression"`    //  will clean and execute given tag tests
