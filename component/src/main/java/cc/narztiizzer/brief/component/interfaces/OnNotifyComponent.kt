package cc.narztiizzer.brief.component.interfaces

import cc.narztiizzer.brief.component.ComponentData

interface OnNotifyComponentData<T: ComponentData> {
    fun notify(component: T)
}