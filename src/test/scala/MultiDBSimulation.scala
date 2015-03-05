import io.gatling.core.Predef._
import io.gatling.http.Predef._


/**
 * Created by gbmetzner on 2/24/15.
 */
class MultiDBSimulation extends Simulation {

  // the test scenario
  val scn = scenario("MultiDBScenario").repeat(1) {
    exec(http(session => "Request User 1")
      .post("http://localhost:9000/user/user1")
      .check(status is 200, substring("Logged: user1"))
    ).exec(http(session => "Request user 2")
      .post("http://localhost:9000/user/user2")
      .check(status is 200, substring("Logged: user2"))
      )
  }

  val httpProtocol = http.baseURL("http://localhost:9000")

  setUp(scn.inject(atOnceUsers(1000))).protocols(httpProtocol)
    .assertions(global.successfulRequests.percent.is(100))

}
