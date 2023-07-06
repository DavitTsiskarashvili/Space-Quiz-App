package com.example.corecommon.data.remote.mapper

import com.example.corecommon.data.local.entity.QuizQuestionEntity
import com.example.corecommon.data.remote.model.QuizSubjectDTO

class QuizQuestionsDTOMapper(
    var subjectTitle: (() -> String)? = null
) : com.example.corecommon.common.mapper.Mapper<QuizSubjectDTO.QuizQuestionDTO, QuizQuestionEntity> {
    override fun invoke(model: QuizSubjectDTO.QuizQuestionDTO): QuizQuestionEntity =
        with(model) {
            QuizQuestionEntity(
                questionTitle = questionTitle,
                questionIndex = questionIndex,
                subjectId = subjectId,
                isAnswered = false,
                isLastQuestion = false,
                subjectTitle = subjectTitle?.invoke() ?: "",
                correctAnswer = correctAnswer,
                answers = answers
            )
        }
}