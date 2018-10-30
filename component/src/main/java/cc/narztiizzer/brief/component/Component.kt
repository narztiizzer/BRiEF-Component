package cc.narztiizzer.brief.component

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import cc.narztiizzer.brief.component.interfaces.OnNotifyComponentData
import java.lang.reflect.ParameterizedType

abstract class Component<T: ComponentData> {
    private var notifyListener: OnNotifyComponentData<T>? = null

    var data: T? = null
        private set

    var typeId: Int
        private set

    var view: ViewHolder? = null
        private set

    var context: Context? = null
        private set

    init {
        @Suppress("UNCHECKED_CAST")
        val genericClass = (this::class.java.genericSuperclass as ParameterizedType).
            actualTypeArguments[0] as Class<T>
        var tempId = 0
        this::class.java.name.toCharArray().forEach { tempId += it.toInt() }
        this.typeId = tempId
        this.data = genericClass.newInstance()
    }

    internal fun create(viewGroup: ViewGroup){
        this.context = viewGroup.context
        this.view = ViewHolder(onCreateComponentView(this.context!!, viewGroup)!!)
    }

    internal fun bind(view: View){ onComponentViewCreated(view) }

    protected open fun setComponentTypeId() = this.typeId

    protected abstract fun onCreateComponentView(context: Context, viewGroup: ViewGroup): View?

    protected abstract fun onComponentViewCreated(view: View)

    protected fun <T: View> findViewById(resId: Int): T = this.view?.itemView!!.findViewById(resId)

    fun registerComponentDataNotify(component: OnNotifyComponentData<T>) {
        this.notifyListener = component
    }

    fun removeComponentDataNotify(){
        this.notifyListener = null
    }

    fun getComponentDataNotify() = this.notifyListener

    class ViewHolder(private val view: View): RecyclerView.ViewHolder(view)
}
