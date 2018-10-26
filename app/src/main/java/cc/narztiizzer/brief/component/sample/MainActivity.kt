package cc.narztiizzer.brief.component.sample

import android.annotation.SuppressLint
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var activityViewModel: ActivityViewModel

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fmtOut = SimpleDateFormat("dd-MM-yyyy")
        val result = findViewById<TextView>(R.id.result)

        this.activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel::class.java)
        this.activityViewModel.changeCreateTimeEvent.observe(this, Observer {
            val dateString = it?.let { fmtOut.format(Date(it)) }
            result.text = dateString
        })

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, SampleComponent())
        transaction.commit()

        println()
    }
}
