package com.data.remote.mapper

import com.mapper.Mapper
import com.data.remote.model.QuizQuestionsDTO
import com.domain.model.questions.QuizQuestionsDomainModel

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