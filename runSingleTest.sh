export BROWSERSTACK_USERNAME=diegopachecoflor_fUsoOk
export BROWSERSTACK_ACCESS_KEY=zGMpYr27qyMXBwGyTz1Z
./mvnw clean test -Dcucumber.feature="src/test/resources/features" -Dcucumber.filter.tags="@single" -DRUN_ON_BROWSERSTACK=true