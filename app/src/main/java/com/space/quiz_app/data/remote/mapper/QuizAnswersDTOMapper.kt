package com.space.quiz_app.data.remote.mapper

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import com.space.quiz_app.domain.model.questions.QuizQuestionsDomainModel

class QuizAnswersDTOMapper : Mapper<QuizQuestionsDTO.AnswerDTO, QuizQuestionsDomainModel.AnswerDomain> {
    override fun invoke(model: QuizQuestionsDTO.AnswerDTO): QuizQuestionsDomainModel.AnswerDomain =
        with(model) {
            QuizQuestionsDomainModel.AnswerDomain(
                answers = answers,
                correctAnswer = correctAnswer,
                questionIndex = questionIndex,
                questionTitle = questionTitle,
                subjectId = subjectId
            )
        }
}