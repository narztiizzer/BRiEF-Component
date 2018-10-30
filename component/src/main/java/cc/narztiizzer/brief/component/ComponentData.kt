package cc.narztiizzer.brief.component

open class ComponentData {
    interface Observe<T: ComponentData>{
        fun notify(data: T)
    }
}