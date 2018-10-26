package cc.narztiizzer.brief.component.sample

import android.arch.lifecycle.ViewModel
import cc.narztiizzer.brief.component.helper.SingleLiveEvent

class ActivityViewModel: ViewModel() {
    val changeCreateTimeEvent = SingleLiveEvent<Long>()

    fun setCreatedDate(timestamp: Long){
        this.changeCreateTimeEvent.value = timestamp
    }
}