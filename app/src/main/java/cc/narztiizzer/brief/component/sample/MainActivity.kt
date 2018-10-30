package cc.narztiizzer.brief.component.sample

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import cc.narztiizzer.brief.component.interfaces.OnNotifyComponentData
import java.text.SimpleDateFormat
import java.util.*
import cc.narztiizzer.brief.component.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fmtOut = SimpleDateFormat("dd MMM yyyy")
        val result = findViewById<TextView>(R.id.result)
        val inputMessage = findViewById<EditText>(R.id.message)

        val componentList = findViewById<ComponentContainer>(R.id.component_list)
        val component = SampleComponent()
            component.registerComponentDataNotify(object : OnNotifyComponentData<SampleComponentData>{
                override fun notify(component: SampleComponentData) {
                    result.text = fmtOut.format(Date(component.timestamp))
                }
            })
        componentList.registerComponent(component)
        componentList.create()

        println()
    }
}
