package pdm.moodmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.moodmanager.states.User
import kotlinx.android.synthetic.main.signin_activity.*
import pdm.moodmanager.helper.ShowToast
import pdm.moodmanager.http.APIListener
import pdm.moodmanager.http.user.UserRequest
import pdm.moodmanager.http.user.model.PhraseModel
import pdm.moodmanager.http.user.model.UserLoginModel
import pdm.moodmanager.http.user.model.UserModel
import pdm.moodmanager.model.Interest
import pdm.moodmanager.model.Phrase
import pdm.moodmanager.model.Register

class MainActivity : AppCompatActivity() {

    val userRequest: UserRequest = UserRequest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_activity)
//        setContentView(R.layout.home_activity)
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

//    fun test(){
//        var user:User = User("Dan","segredo1010")
//        println("Users: ${user}")
//        user.ToPositive()
//        user.ToPositive()
//        println("Users: ${user}")
//        user.ToNegative()
//        user.ToNegative()
//        println("Users: ${user}")
//    }

    fun OnSigninSubmit(view: View){

        var email: TextView = edLoginEmail
        var password: TextView = edLoginPassword

        val body = HashMap<String, Any>()

        body.put("email",email.text.toString())
        body.put("password",password.text.toString())

        userRequest.login(body, object : APIListener {
            override fun onSuccess(model: Any) {
                ShowToast( applicationContext,"User Logged")
                val output = model as UserLoginModel
                val user = model.user as UserModel
                //println(user)

                if(user!=null || user?.username.equals("")){
                    var toHome = Intent(applicationContext,HistoryActivity::class.java)

                    theUser = User(user.id,user.username,user.email,user.password,user.geralScore)
                    user.registers.forEach {
                        theUser.registers.add(Register(it.date,it.description,it.score,it.id))
                    }
                    user.interests.forEach {
                        theUser.interests.add(Interest(it.name,it.description,it.id,it.score))
                    }

                    model.phrase.forEach {
                        phrases.add(Phrase(it.id,it.type,it.content))
                    }

//                    toHome.putExtra("User",user)
                    startActivity(toHome)
                    println("POR ENQUANTO OK")
                }else{
                    ShowToast(applicationContext,"There is no  user to be worked with")
                }
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

    companion object {
        lateinit var theUser:User
        var phrases: MutableList<Phrase> = arrayListOf()
    }
}