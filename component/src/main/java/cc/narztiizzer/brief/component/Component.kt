package cc.narztiizzer.brief.component

import android.arch.lifecycle.ViewModel
import android.support.v4.app.Fragment
import java.lang.reflect.ParameterizedType

open class Component<T: ViewModel>: Fragment() {
   private var vmComponent: T? = null

   @Suppress("UNCHECKED_CAST")
   private var viewModelClass: Class<T> = (this::class.java.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>

   protected fun getComponentViewModel() = this.vmComponent
}
