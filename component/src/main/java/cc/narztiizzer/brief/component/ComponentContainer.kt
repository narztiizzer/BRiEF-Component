package cc.narztiizzer.brief.component

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet

class ComponentContainer: RecyclerView {

    private val componentAdapter = ComponentAdapter()

    constructor(context: Context): super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int): super(context, attrs, defStyle)

    init { layoutManager = LinearLayoutManager(context) }

    fun registerComponent(component: Component<out ComponentData>) {
        if(ComponentPool.instance.getComponentType(component.typeId) == null)
            ComponentPool.instance.registerComponent(component)
        this.componentAdapter.component.add(component)
    }

    fun create(){ adapter = this.componentAdapter }

    fun getComponent() = this.componentAdapter.component

}