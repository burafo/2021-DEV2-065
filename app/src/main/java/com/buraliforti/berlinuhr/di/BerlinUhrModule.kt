package com.buraliforti.berlinuhr.di

import com.buraliforti.berlinuhr.data.SystemCalendarWrapper
import com.buraliforti.berlinuhr.data.SystemCalendarWrapperImpl
import com.buraliforti.berlinuhr.data.TimeProvider
import com.buraliforti.berlinuhr.data.TimeProviderImpl
import com.buraliforti.berlinuhr.data.TimeRepositoryImpl
import com.buraliforti.berlinuhr.domain.BerlinUhrInteractor
import com.buraliforti.berlinuhr.domain.BerlinUhrInteractorImpl
import com.buraliforti.berlinuhr.domain.TimeRepository
import com.buraliforti.berlinuhr.domain.converters.BerlinUhrModelToBerlinUhrShapeColorModelConverter
import com.buraliforti.berlinuhr.domain.converters.BerlinUhrModelToBerlinUhrShapeColorModelConverterImpl
import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsEntityToModelConverter
import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsEntityToModelConverterImpl
import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsToBerlinUhrModelConverter
import com.buraliforti.berlinuhr.domain.converters.HoursMinutesSecondsToBerlinUhrModelConverterImpl
import com.buraliforti.berlinuhr.utils.RxSchedulers
import com.buraliforti.berlinuhr.utils.RxSchedulersImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
//ToDo Refactor for scalability
abstract class BerlinUhrModule {

    @Binds
    abstract fun bindTimeProvider(
        provider: TimeProviderImpl,
    ): TimeProvider

    @Binds
    abstract fun bindBerlinUhrModelToBerlinUhrShapeColorModel(
        converter: BerlinUhrModelToBerlinUhrShapeColorModelConverterImpl,
    ): BerlinUhrModelToBerlinUhrShapeColorModelConverter

    @Binds
    abstract fun bindHoursMinutesSecondsEntityToModelConverter(
        converter: HoursMinutesSecondsEntityToModelConverterImpl,
    ): HoursMinutesSecondsEntityToModelConverter

    @Binds
    abstract fun bindBerlinUhrInteractor(
        interactor: BerlinUhrInteractorImpl,
    ): BerlinUhrInteractor

    @Binds
    abstract fun bindSystemTimeProvider(
        provider: SystemCalendarWrapperImpl,
    ): SystemCalendarWrapper

    @Binds
    abstract fun bindHoursMinutesSecondsToBerlinUhrModelConverter(
        converter: HoursMinutesSecondsToBerlinUhrModelConverterImpl,
    ): HoursMinutesSecondsToBerlinUhrModelConverter

    @Binds
    abstract fun bindTimeRepository(
        repository: TimeRepositoryImpl,
    ): TimeRepository

    @Binds
    abstract fun bindRxSchedulers(
        rxSchedulers: RxSchedulersImpl,
    ): RxSchedulers
}