package com.space.quiz_app.data.local.module

import com.space.quiz_app.data.mapper.question.QuizQuestionDomainToEntityMapper
import com.space.quiz_app.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.space.quiz_app.data.mapper.subject.QuizSubjectDomainToEntityMapper
import com.space.quiz_app.data.mapper.subject.QuizSubjectEntityToDomainMapper
import com.space.quiz_app.data.mapper.user.QuizUserDomainToEntityMapper
import com.space.quiz_app.data.mapper.user.QuizUserEntityToDomainMapper
import org.koin.dsl.module

val databaseMapperModule =  module {
    single { QuizUserEntityToDomainMapper() }
    single { QuizUserDomainToEntityMapper() }
    single { QuizSubjectDomainToEntityMapper() }
    single { QuizSubjectEntityToDomainMapper() }
    single { QuizQuestionDomainToEntityMapper() }
    single { QuizQuestionEntityToDomainMapper() }
}