package mesosphere.marathon
package api.akkahttp

import akka.http.scaladsl.server.Route
import v2.{ AppsController, EventsController, InfoController, PluginsController }

/**
  * Dispatches to various v2 controller routes
  */
class V2Controller(
    appsController: AppsController,
    eventsController: EventsController,
    pluginsController: PluginsController,
    infoController: InfoController
) extends Controller {
  import Directives._
  override val route: Route = {
    pathPrefix("apps") {
      appsController.route
    } ~
      pathPrefix("events") {
        eventsController.route
      } ~
      pathPrefix("plugins") {
        pluginsController.route
      } ~
      pathPrefix("info") {
        infoController.route
      }
  }
}
