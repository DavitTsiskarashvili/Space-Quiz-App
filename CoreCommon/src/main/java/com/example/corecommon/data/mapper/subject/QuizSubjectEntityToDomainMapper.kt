package com.example.corecommon.data.mapper.subject

import com.example.corecommon.data.local.entity.QuizQuestionEntity
import com.example.corecommon.data.local.entity.QuizSubjectEntity
import com.example.corecommon.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel

class QuizSubjectEntityToDomainMapper(
    private val questions: List<QuizQuestionEntity>
) : com.example.corecommon.common.mapper.Mapper<QuizSubjectEntity, QuizSubjectDomainModel> {
    override fun invoke(model: QuizSubjectEntity): QuizSubjectDomainModel =
        with(model) {
            QuizSubjectDomainModel(
                id = id,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questionsCount = questionsCount,
                question = questions.map { QuizQuestionEntityToDomainMapper().invoke(it) }
            )
        }
}