package cc.narztiizzer.brief.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class SampleComponent: Component<SampleComponentRepository>(){

    override fun registerComponentRepository(): SampleComponentRepository {
        return SampleComponentRepository()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?, repository: SampleComponentRepository) {

    }

}