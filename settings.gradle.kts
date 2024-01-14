rootProject.name = "Haxagonal-practice"
include("sns-bootstrap-api")
include("sns-application")
include("sns-domain")
include("sns-infrastructure")
include("sns-infrastructure:sns-data")
findProject(":sns-infrastructure:sns-data")?.name = "sns-data"
