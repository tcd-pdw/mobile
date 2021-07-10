package pdm.moodmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.moodmanager.states.User
import pdm.moodmanager.http.APIListener
import pdm.moodmanager.http.user.UserRequest
import pdm.moodmanager.http.user.model.UserModel

class MainActivity : AppCompatActivity() {

    val userRequest: UserRequest = UserRequest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_activity)

//        setContentView(R.layout.signup_activity)
//        setContentView(R.layout.activity_main)
//        test()

        lateinit var p: UserModel
        val body = HashMap<String, Any>()
        body.put("email","daniel@dan.com")
        body.put("username","danielfolgado")
        body.put("password","123")

        userRequest.register(body, object :APIListener{
            override fun onSuccess(model: UserModel) {

            }

            override fun onFailure(str: String) {
                val s = ""
            }

        })
    }

    fun test(){
        var user:User = User("Dan","segredo1010")
        println("Users: ${user}")
        user.ToPositive()
        user.ToPositive()
        println("Users: ${user}")
        user.ToNegative()
        user.ToNegative()
        println("Users: ${user}")
    }

    fun wishSignUp(view: View){
        println("ENTROU EM OnSignUp")
        var signUp = Intent(this, SignUpActivity::class.java)
        startActivity(signUp)
    }
}