package obs.com.kotlinbaseapp

import android.app.Application
import obs.com.kotlinbaseapp.dependencies.components.AppComponent
import obs.com.kotlinbaseapp.dependencies.components.DaggerAppComponent
import obs.com.kotlinbaseapp.dependencies.modules.ApplicationModule

/**
 * @author Created by vigneshwaran.n on 01-02-2018.
 */

class BaseApp : Application() {
    //change class name as per
    companion object {
        lateinit var app: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        app = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}