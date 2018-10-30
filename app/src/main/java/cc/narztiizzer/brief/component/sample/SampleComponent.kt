package cc.narztiizzer.brief.component.sample

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import cc.narztiizzer.brief.component.Component
import java.util.*

class SampleComponent : Component<SampleComponentData>() {

    override fun setComponentTypeId(): Int {
        var tempId = 0
        this::class.java.name.toCharArray().forEach { tempId += it.toInt() }
        return tempId
    }

    override fun onCreateComponentView(context: Context, viewGroup: ViewGroup): View? {
        return LayoutInflater.from(context).inflate(R.layout.sample_component, viewGroup, false)
    }

    override fun onComponentViewCreated(view: View) {
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            datePicker().show()
        }
    }

    private fun datePicker(): DatePickerDialog {
        val current = Calendar.getInstance()
        return DatePickerDialog(context!!, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val selected = Calendar.getInstance()
            selected.set(year, month, dayOfMonth, 0, 0, 0)
            this.data?.timestamp = selected.time.time
            getComponentDataNotify()?.notify(data!!)
        }, current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.get(Calendar.DAY_OF_MONTH))
    }

}