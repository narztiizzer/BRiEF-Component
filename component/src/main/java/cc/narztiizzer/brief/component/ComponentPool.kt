package cc.narztiizzer.brief.component

class ComponentPool private constructor(){

    private val component = HashMap<Int, Component<out ComponentData>>()

    companion object {
        val instance: ComponentPool by lazy { ComponentPool() }
    }

    fun registerComponent(component: Component<out ComponentData>) { this.component[component.typeId] = component }

    fun removeComponent(component: Component<out ComponentData>) { this.component.remove(component.typeId) }

    fun getComponentType(typeId: Int) = this.component[typeId]
}