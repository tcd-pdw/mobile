package pdm.moodmanager.model

data class Register(
        val date: String?,
        val description: String?,
        val score: Long,
        var id:Long
    ) {
    override fun toString(): String {
        return "Register(date='$date', description='$description', score=$score, id=$id)"
    }
}