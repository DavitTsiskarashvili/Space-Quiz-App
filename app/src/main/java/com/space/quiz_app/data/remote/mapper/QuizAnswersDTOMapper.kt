package com.space.quiz_app.data.remote.mapper

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import com.space.quiz_app.domain.model.questions.QuizQuestionsDomainModel

class QuizAnswersDTOMapper : Mapper<QuizQuestionsDTO.Answer, QuizQuestionsDomainModel.Answer> {
    override fun invoke(model: QuizQuestionsDTO.Answer): QuizQuestionsDomainModel.Answer =
        with(model) {
            QuizQuestionsDomainModel.Answer(
                answers = answers,
                correctAnswer = correctAnswer,
                questionIndex = questionIndex,
                questionTitle = questionTitle,
                subjectId = subjectId
            )
        }
}