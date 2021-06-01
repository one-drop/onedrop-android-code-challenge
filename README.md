# One Drop Android Coding Challenge

At One Drop we take great pride in the quality of our product and our engineering team’s software craft. As such, we request that engineer candidates submit a code challenge to help us assess their expertise with the Android platform and software development as a whole.

We know your time is valuable, so spend as much or as little time as you like. However, we designed this coding challenge so that it should not take more than 3-4 hours to complete.

### Goal: Weather Forecasting for New York

Use [OpenWeather's REST API](https://openweathermap.org/api) to build an Android application that displays the current weather in New York.


### Requirements

1. Retrieve the weather information for New York City using the [One Call API](https://openweathermap.org/api/one-call-api). To save time, you can hardcode the city's latitude/longitude coordinate. In the project, you'll find an existing `WeatherApi` implementation with the required endpoint. From this API response, we expect the following set of data to be shown on the main/landing screen:

    * Location (i.e. New York, etc)
    * Temperature
    * Humidity
    * Feels like
    * Wind speed/degrees
    * Pressure
2. Another feature of this project is a “detail” screen where we show users a 7-day forecast of the weather. Users will get to this screen by tapping anywhere on the main screen of the app.
3. Project must be written in [Kotlin](https://kotlinlang.org/).
4. Project must be architected using [Model-View-Presenter](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter) (MVP)
5. Feel free to use any tools or libraries you are comfortable with.
6. Include a README.md to your project that includes the following information:

    * A brief explanation of your code architecture or libraries employed
    * Sample screenshots of your app.
    * Optional: A “future work” section where you can tell the team about feature or code optimizations that you would have done in the app if you had more time allocated for this challenge.

### Bonus Points
* Include a few unit tests
* Use of RxJava for all your network requests
* Use Android's location API to use the device's current location (i.e. latitude/longitude coordinates) instead of a static location.

### Submitting your work
Once you've completed, push your project to your preferred Git host (Github, GitLab, Bitbucket, etc) and send us the repo link so we can take a look.

* If sharing a public git project is not possible, sending an archive (i.e. zip) of the project is also acceptable.
* Do not fork this repo
* Do not submit a pull-request
