package pdm.moodmanager.model

data class Register(
        val date: String?,
        val description: String?,
        val score: Long
    ) {
    constructor(date: String?,description: String?,score: Long,id:Long?):this(date,description,score){
        this.id = id
    }
    var id: Long? = null
    override fun toString(): String {
        return "Register(date='$date', description='$description', score=$score, id=$id)"
    }
}