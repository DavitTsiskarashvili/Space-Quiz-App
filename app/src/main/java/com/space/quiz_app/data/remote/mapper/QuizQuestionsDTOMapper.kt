package com.space.quiz_app.data.remote.mapper

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.ListStringConverter
import com.space.quiz_app.data.local.entity.QuizQuestionEntity
import com.space.quiz_app.data.remote.model.QuizSubjectDTO
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel

class QuizQuestionsDTOMapper(
    var subjectTitle: ((QuizSubjectDTO.QuizQuestionDTO) -> String)? = null
) : Mapper<QuizSubjectDTO.QuizQuestionDTO, QuizQuestionEntity> {
    override fun invoke(model: QuizSubjectDTO.QuizQuestionDTO): QuizQuestionEntity =
        with(model) {
            QuizQuestionEntity(
                questionTitle = questionTitle,
                questionIndex = questionIndex,
                subjectId = subjectId,
                isAnswered = false,
                isLastQuestion = false,
                subjectTitle = subjectTitle?.invoke(this) ?: "",
                correctAnswer = correctAnswer,
                answers = ListStringConverter().fromList(answers)
            )
        }
}