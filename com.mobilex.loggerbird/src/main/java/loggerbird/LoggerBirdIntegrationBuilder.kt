package loggerbird

/**
 * LoggerbirdIntegration class is a builder class for calling third party integrations in this pattern.
 */
class LoggerBirdIntegrationBuilder(
    val clubhouseApiToken: String?,
    val slackApiToken: String?,
    val gitlabApiToken: String?,
    val githubUserName: String?,
    val githubPassword: String?,
    val asanaApiToken: String?,
    val basecampApiToken: String?,
    val pivotalApiToken: String?,
    val trelloUserName: String?,
    val trelloPassword: String?,
    val trelloKey: String?,
    val trelloToken: String?,
    val jiraDomainName: String?,
    val jiraUserName: String?,
    val jiraApiToken: String?,
    val bitbucketUserName: String?,
    val bitbucketPassword: String?
) {
    data class Builder(
        private var clubhouseApiToken: String? = null,
        private var slackApiToken: String? = null,
        private var gitlabApiToken: String? = null,
        private var githubUserName: String? = null,
        private var githubPassword: String? = null,
        private var asanaApiToken: String? = null,
        private var basecampApiToken: String? = null,
        private var pivotalApiToken: String? = null,
        private var trelloUserName: String? = null,
        private var trelloPassword: String? = null,
        private var trelloKey: String? = null,
        private var trelloToken: String? = null,
        private var jiraDomainName: String? = null,
        private var jiraUserName: String? = null,
        private var jiraApiToken: String? = null,
        private var bitbucketUserName: String? = null,
        private var bitbucketPassword: String? = null
    ) {
        fun setClubhouseIntegration() = apply {
            val clubhouseToken = LoggerBird.decryptTokenKey("5ef8dbb1-aad1-4d9d-8ea0-1bfd13826aff")
            LoggerBird.clubhouseApiToken = clubhouseToken }

        fun setSlackIntegration() = apply {
            val slackApiToken =
                LoggerBird.decryptTokenKey("523949707746.1305602180822.90bead24d771b9e97136249f12587b5b032bc12babd2d58e77444272e72e2763")
            LoggerBird.slackApiToken = slackApiToken }

        fun setGitlabIntegration() = apply {
            val gitlabApiToken = LoggerBird.decryptTokenKey("6W7xso6qN8mqrDfwZZrd")
            LoggerBird.gitlabApiToken = gitlabApiToken }

        fun setGithubIntegration() = apply {
            val githubUserName = LoggerBird.decryptTokenKey("berkavc")
            val githubPassword = LoggerBird.decryptTokenKey("umbasta1")
            LoggerBird.githubUserName = githubUserName;LoggerBird.githubPassword = githubPassword
        }

        fun setAsanaIntegration() = apply {
            val asanaApiToken =
                LoggerBird.decryptTokenKey("1/1182746606250186:defab27f657ce740cf05ba7f5180cc6e")
            LoggerBird.asanaApiToken = asanaApiToken }

        fun setBasecampIntegration() = apply {
            val basecampApiToken =
                LoggerBird.decryptTokenKey("BAhbB0kiAbB7ImNsaWVudF9pZCI6IjRhOTdmMGVhNzUyNjFiZjE0NTAxNzUxZDgwNzJmYWVmODJmMDNjZDciLCJleHBpcmVzX2F0IjoiMjAyMC0wOS0wMlQxMjo1MDoxOVoiLCJ1c2VyX2lkcyI6WzQyNjM5Nzc1XSwidmVyc2lvbiI6MSwiYXBpX2RlYWRib2x0IjoiMWI1ODg2YjhhMDE4OGQxZmY2NGFmNDhkZjM3ZjEzM2UifQY6BkVUSXU6CVRpbWUNTCAewBS4M8kJOg1uYW5vX251bWkCLgI6DW5hbm9fZGVuaQY6DXN1Ym1pY3JvIgdVgDoJem9uZUkiCFVUQwY7AEY=--8049568f5b2b0d93d2e4352e0c3a8c6cce899624")
            LoggerBird.basecampApiToken = basecampApiToken }

        fun setPivotalIntegraton() = apply {
                val pivotalApiToken = LoggerBird.decryptTokenKey("067510e1f4f5db8e92ba9aaadcd204b0")
                LoggerBird.pivotalApiToken = pivotalApiToken }

        fun setTrelloIntegration() = apply {
            val trelloUserName = LoggerBird.decryptTokenKey("appcaesars@gmail.com")
            val trelloPassword = LoggerBird.decryptTokenKey("umbasta1")
            val trelloKey = LoggerBird.decryptTokenKey("08669397e16b6d79bde0317d1476941e")
            val trelloToken = LoggerBird.decryptTokenKey("febcd9b160281966db0f34f51aae563b42ea7a273ca83319f7c82c5cdb5e343f")
            LoggerBird.trelloUserName = trelloUserName;LoggerBird.trelloPassword =
            trelloPassword; LoggerBird.trelloKey = trelloKey; LoggerBird.trelloToken =
            trelloToken
        }

        fun setJiraIntegration() = apply {
            val jiraDomainName = LoggerBird.decryptTokenKey("https://mobilex.atlassian.net")
            val jiraUserName = LoggerBird.decryptTokenKey("berk.avcioglu@mobilex.com.tr")
            val jiraApiToken = LoggerBird.decryptTokenKey("HSqKR7ci5Ue7bmjttHeeC642")
            LoggerBird.jiraDomainName = jiraDomainName;LoggerBird.jiraUserName =
            jiraUserName; LoggerBird.jiraApiToken = jiraApiToken
        }

        fun setBitbucketIntegration() = apply {
            val bitbucketUserName = LoggerBird.decryptTokenKey("appcaesars")
            val bitbucketPassword = LoggerBird.decryptTokenKey("umbasta1")
            LoggerBird.bitbucketUserName = bitbucketUserName
            LoggerBird.bitbucketPassword = bitbucketPassword
        }

        fun build() = LoggerBirdIntegrationBuilder(
            clubhouseApiToken,
            slackApiToken,
            gitlabApiToken,
            githubUserName,
            githubPassword,
            asanaApiToken,
            basecampApiToken,
            pivotalApiToken,
            trelloUserName,
            trelloPassword,
            trelloKey,
            trelloToken,
            jiraDomainName,
            jiraUserName,
            jiraApiToken,
            bitbucketUserName,
            bitbucketPassword
        )
    }
}