package obs.com.kotlinbaseapp.dependencies.components

import dagger.Component
import obs.com.kotlinbaseapp.dependencies.modules.AppContainerModule
import obs.com.kotlinbaseapp.dependencies.modules.ApplicationModule
import obs.com.kotlinbaseapp.dependencies.modules.NetworkModule
import obs.com.kotlinbaseapp.utills.RequestCallback
import obs.com.kotlinbaseapp.views.activities.MainActivity
import javax.inject.Singleton

/**
 * @author Created by vigneshwaran.n on 01-02-2018.
 */

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, AppContainerModule::class, NetworkModule::class))
interface AppComponent {

    fun inject(mainActivity: MainActivity) {}
    fun inject(requestCallback: RequestCallback) {}

}