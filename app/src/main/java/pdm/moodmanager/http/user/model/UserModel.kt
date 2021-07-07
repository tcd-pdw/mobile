package pdm.moodmanager.http.user.model

import com.google.gson.annotations.SerializedName


class UserModel {
    @SerializedName("username")
    var username: String = ""
    @SerializedName("email")
    var email: String = ""
    @SerializedName("password")
    var password: String = ""
}