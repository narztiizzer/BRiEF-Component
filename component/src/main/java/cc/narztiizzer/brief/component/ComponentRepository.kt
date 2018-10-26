package cc.narztiizzer.brief.component

import android.content.Context
import android.os.Bundle

abstract class ComponentRepository {
    var bundle: Bundle? = null
        private set

    abstract fun prepare(context: Context)

    internal fun putBundle(bundle: Bundle?){
        this.bundle = bundle
    }
}