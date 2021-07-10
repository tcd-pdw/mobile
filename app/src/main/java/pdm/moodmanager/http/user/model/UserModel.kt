package pdm.moodmanager.http.user.model

import com.google.gson.annotations.SerializedName


class UserModel {
    @SerializedName("username")
    var username: String = ""

    @SerializedName("email")
    var email: String = ""

    @SerializedName("password")
    var password: String = ""

    @SerializedName("geralScore")
    var geralScore: Int = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("preference")
    var preference: PreferenceModel? = null

    @SerializedName("registeres")
    var registers: ArrayList<RegistersModel> = ArrayList()

    @SerializedName("interests")
    var interests: ArrayList<InterestModel> = ArrayList()

    @SerializedName("phrase")
    var phrase: ArrayList<PhraseModel> = ArrayList()
}