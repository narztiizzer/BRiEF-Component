package cc.narztiizzer.brief.component.sample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ActivityViewModel: ViewModel() {
    val changeCreateTimeEvent = MutableLiveData<Long>()



}