rootProject.name = "Haxagonal-practice"
include("sns-bootstrap-api")
include("sns-application")
include("sns-domain")
include("sns-infrastructure")
include("sns-infrastructure:sns-dao")
findProject(":sns-infrastructure:sns-dao")?.name = "sns-dao"
