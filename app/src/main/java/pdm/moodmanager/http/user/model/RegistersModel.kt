package pdm.moodmanager.http.user.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

class RegistersModel {

    @SerializedName("id")
    var id: Long = 0
    @SerializedName("date")
    var date: LocalDateTime? = null
    @SerializedName("description")
    var description: String? = null
}