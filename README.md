# nhs-benefits
Test NHS
This is a MAVEN project.

RegularAmountTest.java
It is the test class and 5 test methods were placed (one for each frequency type)

Frequency.java
It is the enum containing the frequencies.

RegularAmount.java
It is the class passed with the test. A constructor and some null validations were created and the validation class was placed in the entity.

FrequencyAmount.java
It is the interface for creating the validation class.

FrequencyAmountValidator
It is the validation class where the isValid method was implemented.

-------------------------------------------------- -------------------------------------------------- ------

MAVEN

The dependencies were placed for
-validation-api (Required for validator creation)
-junit-jupiter-engine (Required for test class creation)
-hibernate-validator (Required for validator creation)
-slf4j-jdk14 (Required for test class creation)
