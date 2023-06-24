package com.space.quiz_app.common.mapper

import com.space.quiz_app.presentation.mapper.answer.QuizAnswerDomainMapper
import com.space.quiz_app.presentation.mapper.answer.QuizAnswerUIToDomainMapper
import com.space.quiz_app.presentation.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.mapper.question.QuizQuestionUIToDomainMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserUIToDomainMapper
import org.koin.dsl.module

val uiMapperModule = module {
    single { QuizUserDomainToUIMapper() }
    single { QuizUserUIToDomainMapper() }
    single { QuizQuestionDomainMapper() }
    single { QuizQuestionUIToDomainMapper() }
    single { QuizAnswerDomainMapper() }
    single { QuizAnswerUIToDomainMapper() }
}