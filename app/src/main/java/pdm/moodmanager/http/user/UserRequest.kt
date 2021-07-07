package pdm.moodmanager.http.user

import pdm.moodmanager.http.APIListener
import pdm.moodmanager.http.RetrofitClient
import pdm.moodmanager.http.user.model.UserModel
import pdm.moodmanager.http.user.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRequest {
    private val remote = RetrofitClient.createService(UserService::class.java)

    fun register(objs: HashMap<String, Any>, listener: APIListener) {
        val call: Call<UserModel> = remote.register(objs)
        call.enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                response.body()?.let { listener.onSuccess(it) } // verifica se é nulo, retorna ele mesmo para dentro a callback {}

            }

        })
    }
}