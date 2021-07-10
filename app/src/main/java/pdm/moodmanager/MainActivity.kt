package pdm.moodmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.moodmanager.states.User
import kotlinx.android.synthetic.main.signin_activity.*
import kotlinx.android.synthetic.main.signup_activity.*
import pdm.moodmanager.helper.ShowToast
import pdm.moodmanager.http.APIListener
import pdm.moodmanager.http.user.UserRequest
import pdm.moodmanager.http.user.model.UserModel

class MainActivity : AppCompatActivity() {

    val userRequest: UserRequest = UserRequest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.signin_activity)
        setContentView(R.layout.home_activity)
//        setContentView(R.layout.signup_activity)
//        setContentView(R.layout.activity_main)
//        test()

        lateinit var p: UserModel
        val body = HashMap<String, Any>()
        body.put("email","daniel@dan.com")
        body.put("username","danielfolgado")
        body.put("password","123")

        userRequest.register(body, object :APIListener{
            override fun onSuccess(model: Any) {

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

    fun OnSigninSubmit(view: View){

        var email: TextView = edLoginEmail
        var password: TextView = edLoginPassword

        val body = HashMap<String, Any>()

        body.put("email",email.text.toString())
        body.put("password",password.text.toString())

        userRequest.login(body, object : APIListener {
            override fun onSuccess(model: Any) {
                ShowToast( applicationContext,"User Logged")

            }

            override fun onFailure(str: String) {
                ShowToast( applicationContext,"Error Conection")
            }
        })
    }

    fun wishSignUp(view: View){
        println("ENTROU EM OnSignUp")
        var signUp = Intent(this, SignUpActivity::class.java)
        startActivity(signUp)
    }

    //Move to HomeActivity
    fun toHistory(view:View){
        println("ENTROU EM TOHISTORY")
        var history = Intent(this,HistoryActivity::class.java)
        startActivity(history)
    }
}