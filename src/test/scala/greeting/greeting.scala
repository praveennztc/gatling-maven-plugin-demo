package greeting

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://abe13b4f3a60b11e98988021b2294b8d-1833402536.us-west-2.elb.amazonaws.com")
  // http://a99e647209ff011e98988021b2294b8d-1313009118.us-west-2.elb.amazonaws.com/greeting?name=test
    .acceptHeader("application/json") // Here are the common headers
    .header("Content-Type", "application/json")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")
  
  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
      .get("/greeting?name=test"))
    .pause(7) // Note that Gatling has recorder real time pauses
  
  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))
  
}
