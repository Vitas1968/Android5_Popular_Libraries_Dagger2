package ru.geekbrains.poplib.di.modules
import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.geekbrains.poplib.mvp.model.cache.image.IImageCache
import ru.geekbrains.poplib.mvp.model.cache.image.room.RoomImageCache
import ru.geekbrains.poplib.mvp.model.entity.room.db.Database
import ru.geekbrains.poplib.mvp.model.image.IImageLoader
import ru.geekbrains.poplib.mvp.model.network.NetworkStatus
import ru.geekbrains.poplib.ui.App

import ru.geekbrains.poplib.ui.image.GlideImageLoader
import java.io.File
import javax.inject.Singleton

//Реализовать модуль и внедрение всего, что касается картинок. Кэш тоже сюда.
@Module(
    includes = [
        CacheModule::class,
        ApiModule::class
    ]
)
open class ImageModule{

    @Singleton
    @Provides
    open fun getImageLoader(imageCache: IImageCache,networkStatus: NetworkStatus): IImageLoader<ImageView> {
        return GlideImageLoader(imageCache,networkStatus)
    }

    @Provides
    fun getImageCache(app:App,database: Database): IImageCache{
        val path = (
                app.externalCacheDir?.path
                    ?: app.getExternalFilesDir(null)?.path
                    ?: app.filesDir.path
                ) + File.separator + "image_cache"
        return RoomImageCache(database, File(path))

    }

}