package com.example.lifeline.presentation

import android.app.Application
import android.content.Context
import com.example.lifeline.data.api.NetworkModule
import com.example.lifeline.data.mappers.AuthApiResponseMapper
import com.example.lifeline.data.mappers.ConstantsApiMapper
import com.example.lifeline.data.mappers.UsersApiMapper
import com.example.lifeline.data.repositories.AuthRepositoryImpl
import com.example.lifeline.data.repositories.ConstantsRepositoryImpl
import com.example.lifeline.data.repositories.UsersRepositoryImpl
import com.example.lifeline.domain.repositories.AuthRepository
import com.example.lifeline.domain.repositories.ConstantsRepository
import com.example.lifeline.domain.repositories.UsersRepository
import com.example.lifeline.domain.usecases.auth.SignInUseCase
import com.example.lifeline.domain.usecases.auth.SignUpUseCase
import com.example.lifeline.domain.usecases.constants.*
import com.example.lifeline.domain.usecases.users.GetParametersUseCase
import com.example.lifeline.domain.usecases.users.GetPersonalUseCase
import com.example.lifeline.domain.usecases.users.SaveParametersUseCase
import com.example.lifeline.domain.usecases.users.SavePersonalUseCase
import com.example.lifeline.presentation.ui.fill.FillViewModel
import com.example.lifeline.presentation.ui.sign_in.SignInViewModel
import com.example.lifeline.presentation.ui.sign_up.SignUpViewModel
import com.example.lifeline.presentation.ui.statistics.StatisticsViewModel
import com.example.lifeline.services.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class LifelineApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree());
        startKoin {
            androidContext(this@LifelineApplication)
            modules(appModule)
        }
    }

    private val appModule = module {
        // View-models
        viewModel { SignInViewModel(get(), get(), get()) }
        viewModel { SignUpViewModel(get(), get(), get()) }
        viewModel { FillViewModel(get(), get()) }
        viewModel { StatisticsViewModel(get(), get())}

        // API
        single { NetworkModule() }

        // Mappers
        single { AuthApiResponseMapper() }
        single { UsersApiMapper() }
        single { ConstantsApiMapper() }

        // Repository implementations
        single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
        single<UsersRepository> { UsersRepositoryImpl(get(), get()) }
        single<ConstantsRepository> { ConstantsRepositoryImpl(get(), get()) }

        // Use-cases
        // Auth
        single { SignInUseCase(get()) }
        single { SignUpUseCase(get()) }
        // Users
        single { GetParametersUseCase(get()) }
        single { GetPersonalUseCase(get()) }
        single { SaveParametersUseCase(get()) }
        single { SavePersonalUseCase(get()) }
        //Constants GET
        single { GetPulseUseCase(get()) }
        single { GetPressureUseCase(get()) }
        single { GetTemperatureUseCase(get()) }
        single { GetSleepUseCase(get()) }
        //ConstantsPUT
        single { SavePulseUseCase(get()) }
        single { SavePressureUseCase(get()) }
        single { SaveTemperatureUseCase(get()) }
        single { SaveSleepUseCase(get()) }

        //Services
        single { CurrentUserService() }
        single { AuthService(get(), get()) }
        single { TokenService(getTokenSharedPreferences()) }
        single { UsersService(get(), get(), get(), get()) }
        single { GetConstantsService(get(), get(), get(), get()) }
        single { SaveConstantsService(get(), get(), get(), get()) }
        single { ChartService()}
    }

    private fun getTokenSharedPreferences() = getSharedPreferences("token", Context.MODE_PRIVATE)
}