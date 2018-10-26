package cc.narztiizzer.brief.component.sample

import android.arch.lifecycle.ViewModel
import cc.narztiizzer.brief.component.helper.SingleLiveEvent

class SampleComponentViewModel: ViewModel(){
    val timestampChangeEvent = SingleLiveEvent<Long>()

    fun updateTimestamp(timestamp: Long) { this.timestampChangeEvent.value = timestamp }
}