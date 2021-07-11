package pdm.moodmanager

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.history_activity.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class HistoryActivity: AppCompatActivity() {

    lateinit var linelist:ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData:LineData
    lateinit var tip:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("ENTROU NO ONCREATE DO history")
        setContentView(R.layout.history_activity)
        println("NO HISTORY ACTIVITY")
        println(MainActivity.theUser)

        var regs = MainActivity.theUser.registers

        var limit = 0
        if(regs.size<6)
            limit = regs.size
        else
            limit = 6

        println("QTDE DE REGS: ${regs.size}")
        linelist = ArrayList()
//        var i:Int = 1
        for(i in 1..(limit)){
            println("i: ${i}, limit: ${limit}, regsize: ${regs.size}, invert: ${regs.size - i}")
            linelist.add(Entry(i.toFloat(),regs.get(regs.size-i).score.toFloat()))
            println("Adicionando: ${regs.get(regs.size-i).score.toFloat()}")
        }
//        linelist.add(Entry(01f,2f))
//        linelist.add(Entry(02f,-1f))
//        linelist.add(Entry(03f,-3f))
//        linelist.add(Entry(04f,-1f))
//        linelist.add(Entry(05f,4f))
//        linelist.add(Entry(06f,2f))

        lineDataSet = LineDataSet(linelist,"Count")
        lineData = LineData(lineDataSet)
        lineChart.data = lineData
//        lineDataSet.color = Color.BLACK
        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet.valueTextColor= Color.YELLOW
        lineDataSet.valueTextSize = 20f
        lineDataSet.setDrawFilled(true)

        MainActivity.phrases.forEach {
            println(it)
        }

        val nextValues = Random.nextInt(0, MainActivity.phrases.size)


        tip = findViewById(R.id.txtTip)
        tip.text = MainActivity.phrases.get(nextValues).content

    }
}