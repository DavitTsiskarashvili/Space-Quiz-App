package com.space.quiz_app.presentation.feature.module


import com.example.corecommon.model.mapper.question.QuizQuestionDomainMapper
import com.example.corecommon.model.mapper.question.QuizQuestionUIToDomainMapper
import com.example.corecommon.model.mapper.subject.QuizSubjectDomainMapper
import com.example.corecommon.model.mapper.subject.QuizSubjectUIToDomainMapper
import com.example.corecommon.model.mapper.user.QuizUserDomainToUIMapper
import com.example.corecommon.model.mapper.user.QuizUserSubjectDomainToUIMapper
import com.example.corecommon.model.mapper.user.QuizUserUIToDomainMapper
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