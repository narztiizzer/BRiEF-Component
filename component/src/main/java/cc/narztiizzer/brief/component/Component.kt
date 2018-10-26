package cc.narztiizzer.brief.component

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

abstract class Component<T: ComponentRepository>: Fragment() {

   private lateinit var repository: T

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      this.repository = this.registerComponentRepository()
      this.repository.prepare(context!!)
      this.repository.putBundle(arguments)
   }

   abstract fun registerComponentRepository(): T

   abstract fun onViewCreated(view: View, savedInstanceState: Bundle?, repository: T)

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)
      this.onViewCreated(view, savedInstanceState, this.repository)
   }
}