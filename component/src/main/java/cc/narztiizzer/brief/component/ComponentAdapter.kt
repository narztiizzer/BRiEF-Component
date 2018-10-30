package cc.narztiizzer.brief.component

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

class ComponentAdapter: RecyclerView.Adapter<Component.ViewHolder>() {

    val component = ArrayList<Component<out ComponentData>>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Component.ViewHolder {
        val component = ComponentPool.instance.getComponentType(viewType)
        component!!.create(viewGroup)
        return component.view!!
    }

    override fun getItemCount() = this.component.size

    override fun getItemViewType(position: Int) = this.component[position].typeId

    override fun onBindViewHolder(viewHolder: Component.ViewHolder, index: Int) {
        this.component[index].bind(viewHolder.itemView)
    }

}
