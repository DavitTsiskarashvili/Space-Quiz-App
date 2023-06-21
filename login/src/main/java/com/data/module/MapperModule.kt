package com.data.module

import com.data.mapper.QuizUserDomainToEntityMapper
import com.data.mapper.QuizUserEntityToDomainMapper
import com.presentation.mapper.QuizUserDomainToUIMapper
import com.presentation.mapper.QuizUserUIToDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { QuizUserDomainToUIMapper() }
    single { QuizUserUIToDomainMapper() }
    single { QuizUserEntityToDomainMapper() }
    single { QuizUserDomainToEntityMapper() }

}