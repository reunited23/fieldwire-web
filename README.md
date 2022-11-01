<H1>Selenium regression and smoke tests against fiedlwire</H1>

<H2>Setup:</H2>

1. Checkout
2. Install maven
3. Install Google Chrome, Edge, Firefox

<B>Running from IDE in Chrome:</B>
1. Right click on regress.xml or smoke.xml to run regression or smoke suites
2. Click "Run"

<B>Running from console using different browsers:</B>
1. run ***mvn clean test -Dbrowser=chrome*** for chrome
2. run ***mvn clean test -Dbrowser=firefox*** for firefox
3. run ***mvn clean test -Dbrowser=edge*** for edge
