package ns.api

class ServerRequest private constructor(
    val userId: String?
) {
    data class Builder(
        var userId: String? = null
    ) {
        fun userId(userId: String) = apply { this.userId = userId }


        fun build() = ServerRequest(
            userId
        )
    }
}