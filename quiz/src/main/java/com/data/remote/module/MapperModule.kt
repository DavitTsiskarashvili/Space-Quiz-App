package com.data.remote.module

import com.data.remote.mapper.QuizAnswersDTOMapper
import com.data.remote.mapper.QuizQuestionsDTOMapper
import com.presentation.mapper.question.QuizAnswersDomainMapper
import com.presentation.mapper.question.QuizQuestionDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { QuizAnswersDTOMapper() }
    single { QuizAnswersDomainMapper() }
    single { QuizQuestionsDTOMapper(QuizAnswersDTOMapper()) }
    single { QuizQuestionDomainMapper(QuizAnswersDomainMapper()) }
}