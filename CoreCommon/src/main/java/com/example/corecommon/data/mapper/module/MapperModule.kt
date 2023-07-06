package com.example.corecommon.data.mapper.module

import com.example.corecommon.data.local.entity.QuizQuestionEntity
import com.example.corecommon.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.example.corecommon.data.mapper.subject.QuizSubjectDomainToEntityMapper
import com.example.corecommon.data.mapper.subject.QuizSubjectEntityToDomainMapper
import com.example.corecommon.data.mapper.user.QuizUserDomainToEntityMapper
import com.example.corecommon.data.mapper.user.QuizUserEntityToDomainMapper
import com.example.corecommon.data.mapper.user.QuizUserSubjectsEntityToDomainMapper
import com.example.corecommon.data.remote.mapper.QuizQuestionsDTOMapper
import com.example.corecommon.data.remote.mapper.QuizSubjectDTOMapper
import org.koin.dsl.module

val databaseMapperModule = module {
    single { QuizUserEntityToDomainMapper() }
    single { QuizUserDomainToEntityMapper() }
    single { QuizSubjectDomainToEntityMapper() }
    single { QuizSubjectEntityToDomainMapper(get()) }
    factory<List<QuizQuestionEntity>> { emptyList() }
    single { QuizQuestionEntityToDomainMapper() }
    single { QuizSubjectDTOMapper() }
    single { QuizQuestionsDTOMapper() }
    single { QuizUserSubjectsEntityToDomainMapper() }
}