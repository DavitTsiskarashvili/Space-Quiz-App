package com.space.quiz_app.presentation.module

import com.space.quiz_app.presentation.mapper.answer.QuizAnswerDomainMapper
import com.space.quiz_app.presentation.mapper.answer.QuizAnswerUIToDomainMapper
import com.space.quiz_app.presentation.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.mapper.question.QuizQuestionUIToDomainMapper
import com.space.quiz_app.presentation.mapper.subject.QuizSubjectDomainMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserUIToDomainMapper
import org.koin.dsl.module

val UIModule = module {
    single { QuizUserDomainToUIMapper() }
    single { QuizUserUIToDomainMapper() }
    single { QuizQuestionDomainMapper() }
    single { QuizQuestionUIToDomainMapper() }
    single { QuizAnswerDomainMapper() }
    single { QuizAnswerUIToDomainMapper() }
    single { QuizSubjectDomainMapper() }
}