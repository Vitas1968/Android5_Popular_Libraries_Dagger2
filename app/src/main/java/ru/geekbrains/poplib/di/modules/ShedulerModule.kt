package ru.geekbrains.poplib.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Named


@Module
class SchedulerModule {

    @Named("androidSheduler")
    @Provides
    fun provideAndroidSheduler(): Scheduler {
        return AndroidSchedulers.mainThread()

    }
}