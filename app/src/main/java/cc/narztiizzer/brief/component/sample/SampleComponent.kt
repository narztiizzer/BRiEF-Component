package cc.narztiizzer.brief.component.sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import cc.narztiizzer.brief.component.Component
import android.app.DatePickerDialog
import java.util.*


class SampleComponent: Component<SampleComponentViewModel>() {
    private var button: Button? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.sample_component, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.button = view.findViewById(R.id.button)
        this.button?.setOnClickListener { datePicker().show() }
    }

    private fun datePicker(): DatePickerDialog {
        val startDate = Calendar.getInstance()
        return DatePickerDialog(context!!,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                val selectDate = Calendar.getInstance()
                selectDate.set(year, month, dayOfMonth, 0, 0, 0)
                getComponentViewModel()?.updateTimestamp(selectDate.time.time)
            }, startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH), startDate.get(Calendar.DAY_OF_MONTH))
    }
}