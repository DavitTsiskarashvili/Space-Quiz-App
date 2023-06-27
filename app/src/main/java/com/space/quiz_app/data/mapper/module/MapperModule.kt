package com.space.quiz_app.data.mapper.module

import com.space.quiz_app.data.local.entity.QuizQuestionEntity
import com.space.quiz_app.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.space.quiz_app.data.mapper.subject.QuizSubjectDomainToEntityMapper
import com.space.quiz_app.data.mapper.subject.QuizSubjectEntityToDomainMapper
import com.space.quiz_app.data.mapper.user.QuizUserDomainToEntityMapper
import com.space.quiz_app.data.mapper.user.QuizUserEntityToDomainMapper
import com.space.quiz_app.data.remote.mapper.QuizQuestionsDTOMapper
import com.space.quiz_app.data.remote.mapper.QuizSubjectDTOMapper
import com.space.quiz_app.presentation.mapper.subject.QuizSubjectDomainMapper
import org.koin.dsl.module

val databaseMapperModule =  module {
    single { QuizUserEntityToDomainMapper() }
    single { QuizUserDomainToEntityMapper() }
    single { QuizSubjectDomainToEntityMapper() }
    single { QuizSubjectEntityToDomainMapper( get()) }
    factory<List<QuizQuestionEntity>> { emptyList() }
    single { QuizQuestionEntityToDomainMapper() }
    single { QuizSubjectDTOMapper() }
    single { QuizQuestionsDTOMapper() }
}