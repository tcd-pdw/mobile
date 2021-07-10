package pdm.moodmanager

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.history_activity.*
import pdm.moodmanager.http.user.UserRequest

class HistoryActivity: AppCompatActivity() {

    lateinit var linelist:ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData:LineData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("ENTROU NO ONCREATE DO history")
        setContentView(R.layout.history_activity)

        linelist = ArrayList()
        linelist.add(Entry(01f,2f))
        linelist.add(Entry(02f,-1f))
        linelist.add(Entry(03f,-3f))
        linelist.add(Entry(04f,-1f))
        linelist.add(Entry(05f,4f))
        linelist.add(Entry(06f,2f))

        lineDataSet = LineDataSet(linelist,"Count")
        lineData = LineData(lineDataSet)
        lineChart.data = lineData
//        lineDataSet.color = Color.BLACK
        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet.valueTextColor= Color.BLUE
        lineDataSet.valueTextSize = 20f
        lineDataSet.setDrawFilled(true)


    }
}