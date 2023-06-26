package com.space.quiz_app.data.mapper.subject

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.QuizQuestionEntity
import com.space.quiz_app.data.local.entity.QuizSubjectEntity
import com.space.quiz_app.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel

class QuizSubjectEntityToDomainMapper (
    val questions:List<QuizQuestionEntity>
    ): Mapper<QuizSubjectEntity, QuizSubjectDomainModel> {
    override fun invoke(model: QuizSubjectEntity): QuizSubjectDomainModel =
        with(model) {
            QuizSubjectDomainModel(
                id = id,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questionsCount = questionsCount,
                question =  questions.map { QuizQuestionEntityToDomainMapper().invoke(it) }
            )
        }
}