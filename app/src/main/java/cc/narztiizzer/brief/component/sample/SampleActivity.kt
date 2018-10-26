package cc.narztiizzer.brief.component.sample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class SampleActivity: AppCompatActivity() {
    private lateinit var activityViewModel: ActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.activityViewModel = ViewModelProviders.of(this).get(ActivityViewModel::class.java)

        this.activityViewModel.changeCreateTimeEvent.observe(this, Observer {

        })
    }
}