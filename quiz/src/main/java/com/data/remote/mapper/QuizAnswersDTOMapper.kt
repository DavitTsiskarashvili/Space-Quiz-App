package com.data.remote.mapper

import com.data.remote.model.QuizQuestionsDTO
import com.domain.model.questions.QuizQuestionsDomainModel
import com.mapper.Mapper

class QuizAnswersDTOMapper :
    Mapper<QuizQuestionsDTO.AnswerDTO, QuizQuestionsDomainModel.AnswerDomain> {
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