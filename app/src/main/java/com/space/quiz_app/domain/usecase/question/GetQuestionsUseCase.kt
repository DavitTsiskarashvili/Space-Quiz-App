package com.space.quiz_app.domain.usecase.question

import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.domain.repository.QuizQuestionsRepository
import com.space.quiz_app.domain.usecase.base.BaseUseCase

class GetQuestionsUseCase(
    private val questionsRepository: QuizQuestionsRepository,

    ): BaseUseCase<String, List<QuizQuestionDomainModel>>() {

    override suspend fun invoke(params: String?): List<QuizQuestionDomainModel> {
        return questionsRepository.getQuestionsByTitle((params!!))

    }
}