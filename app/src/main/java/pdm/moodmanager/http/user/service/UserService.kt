package pdm.moodmanager.http.user.service

import pdm.moodmanager.http.user.model.UserModel
import retrofit2.Call
import retrofit2.http.*

interface UserService {

//    @GET("users/new")
//    fun register(): Call<List<UserModel>>

    @Headers("accept: application/json",
        "content-type: application/json")
    @POST("users/new")
    fun register(@Body params: HashMap<String, Any>
                ): Call<UserModel>
}