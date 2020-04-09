package ru.geekbrains.poplib.di.modules

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Scheduler
import ru.geekbrains.poplib.mvp.presenter.RepositoriesPresenter
import javax.inject.Named
import javax.inject.Singleton


@Module(
    includes = [
        SchedulerModule::class]
)

class PresenterModule {
    @Singleton
    @Provides
    fun providePresenter(@Named("androidSheduler") scheduler: Scheduler): RepositoriesPresenter{
        return RepositoriesPresenter(scheduler)
    }
}