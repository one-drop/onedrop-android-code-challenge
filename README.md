# One Drop Android Coding Challenge

At One Drop we take great pride in the quality of our product and our engineering team’s software craft. As such, we request that engineer candidates submit a code challenge to help us assess their expertise with the Android platform and software development as a whole.

We know your time is valuable, so spend as much or as little time as you like.

### Goal: Build a Weather Forecasting app

* Use [OpenWeather's REST API](https://openweathermap.org/api) to build an Android application that displays the current weather in New York.
* Retrieve the weather information for New York City using the [One Call API](https://openweathermap.org/api/one-call-api).
  - To save time, you can hardcode the city's latitude/longitude coordinates (`40.725302, -73.997776`).
  - In the project, you'll find an existing `WeatherApi` implementation with the required endpoint.
* Show the following set of data on the main app screen:
  - Location (e.g. New York)
  - Temperature
  - Feels like temperature
  - Humidity
  - Wind speed/direction
  - Atmospheric pressure
* Include a way to navigate from the main screen to a detail screen that shows a 7-day weather forecast for that location.

### Requirements
1. Project must be written in [Kotlin](https://kotlinlang.org/).
2. Project must be architected in a testable manner (e.g. `Model–view–presenter`, `Model–view–viewmodel`)
3. Feel free to use any tools or libraries you are comfortable with.
4. Include a README.md in your project that includes the following:
    * A brief explanation of your code architecture or libraries employed.
    * Sample screenshots of your app.
    * Describe any shortcuts or compromises chosen to save development time.
    * A “future work” section where you describe additional features or code optimizations that you would have added to the app if you had more time allocated for this challenge.

### Bonus Points
* Include some unit tests of important logic.
* Use RxJava or Coroutines.
* Use Android's location API to display weather data for the device's current location rather than hardcoding the latitude/longitude coordinates.

### Submitting your work
Once you've completed, push your project to your preferred Git host (Github, GitLab, Bitbucket, etc) and send us the repo link so we can take a look.

* If sharing a public git project is not possible, sending an archive (i.e. zip) of the project is also acceptable.
* Please do *NOT* fork this repo or create a pull request for your submission.
