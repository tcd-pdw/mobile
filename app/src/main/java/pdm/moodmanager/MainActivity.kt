package pdm.moodmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moodmanager.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test()
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
}