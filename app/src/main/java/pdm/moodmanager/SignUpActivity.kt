package pdm.moodmanager

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import kotlinx.android.synthetic.main.signup_activity.*
import pdm.moodmanager.http.APIListener
import pdm.moodmanager.http.user.UserRequest
import pdm.moodmanager.http.user.model.UserModel

class SignUpActivity:AppCompatActivity() {

    val userRequest: UserRequest = UserRequest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("ENTROU NO ONCREATE DO SIGNUP")
        setContentView(R.layout.signup_activity)
    }

    fun OnSignupSubmit(view: View){
        println("NOW ON SUBMIT, SOLVE THE DATA!!")

        var email:TextView = edTxtEmail
        var username:TextView = edTxtName
        var password:TextView = edTxtPassword
        println("DADOS DO FORM")
        println(email.text)
        println(username.text)
        println(password.text)

        println("Starting action...")
        lateinit var p: UserModel
        val body = HashMap<String, Any>()
        body.put("email",email.text)
        body.put("username",username.text)
        body.put("password",password.text)

        println(body.toString())
        userRequest.register(body, object : APIListener {
            override fun onSuccess(model: UserModel) {


            }

            override fun onFailure(str: String) {
                val s = ""
            }
            })

        println("Closing action...")
    }
}