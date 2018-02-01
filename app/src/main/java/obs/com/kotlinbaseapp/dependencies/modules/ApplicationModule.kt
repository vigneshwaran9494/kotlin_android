package obs.com.kotlinbaseapp.dependencies.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import obs.com.kotlinbaseapp.BaseApp
import javax.inject.Singleton

/**
 * @author Created by vigneshwaran.n on 01-02-2018.
 */
@Module
class ApplicationModule(val app: BaseApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app

}
