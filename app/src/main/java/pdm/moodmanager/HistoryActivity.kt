package pdm.moodmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pdm.moodmanager.http.user.UserRequest

class HistoryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("ENTROU NO ONCREATE DO history")
        setContentView(R.layout.history_activity)
    }
}