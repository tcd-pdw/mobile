package pdm.moodmanager

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class PreferenceActivity : AppCompatActivity() {
    lateinit var cheers: CheckBox
    lateinit var habits: CheckBox
    lateinit var songs: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        cheers =  findViewById(R.id.cbPreferenceCheerMeUp)
        habits = findViewById(R.id.cbPreferenceHelpImprove)
        songs = findViewById(R.id.cbPreferenceSugestSome)

//        if ()

//        MainActivity.theUser.preference.setPreference(cheers.isChecked,songs.isChecked,habits.isChecked)

        // Enables Always-on
        setContentView(R.layout.activity_preference)
    }

    fun onCheckListener(view: View){
        println("ENTROU ON CHECKLISTENER")
        var checks = view as CheckBox
        println(checks.id.toString())
        println(checks.text)
        if(checks.text == "Cheer me up"){
            MainActivity.theUser.preference.cherring_up = checks.isChecked
        }else if(checks.text == "Help me improve my habits"){
            MainActivity.theUser.preference.self_improvment = checks.isChecked
        }else if(checks.text == "Sugest me some music"){
            MainActivity.theUser.preference.song_sugestion= checks.isChecked
        }
        println("FEITO")
    }
}