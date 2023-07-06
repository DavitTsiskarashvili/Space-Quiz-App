package com.space.quiz_app.presentation.feature.module


import com.space.quiz_app.presentation.feature.model.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.feature.model.mapper.question.QuizQuestionUIToDomainMapper
import com.space.quiz_app.presentation.feature.model.mapper.subject.QuizSubjectDomainMapper
import com.space.quiz_app.presentation.feature.model.mapper.subject.QuizSubjectUIToDomainMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserSubjectDomainToUIMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserUIToDomainMapper
import org.koin.dsl.module

val UIModule = module {
    single { QuizUserDomainToUIMapper() }
    single { QuizUserUIToDomainMapper() }
    single { QuizQuestionDomainMapper() }
    single { QuizQuestionUIToDomainMapper() }
    single { QuizSubjectDomainMapper() }
    single { QuizSubjectUIToDomainMapper() }
    single { QuizUserSubjectDomainToUIMapper() }
}