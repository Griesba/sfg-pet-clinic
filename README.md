[![CircleCI](https://circleci.com/gh/Griesba/sfg-pet-clinic.svg?style=svg)](https://app.circleci.com/pipelines/github/Griesba/sfg-pet-clinic)

# sfg-pet-clinic
pet clinic web app

# dependency inversion vs dependency injection
  dependency injection: how object is initialized with dependents object
  dependency inversion: details should depend on abstraction (not the opposite)


# dependency injection vs IoC
  dependency injection is class composition. You compose your classes with dependency injection in mind.
  IoC is the runtime environment of your code. ie Springframework's IoC container. Spring is in control of the injection of dependency.


#Unit test
we are using Junit 5 in this project. In order to do that Junit 4 (Junit-vintage) was excluded
manually in the spring-boot-starter-test dependency. 