package com.space.quiz_app.domain.usecase.question

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.domain.model.questions.QuizQuestionDomainModel
import com.example.corecommon.domain.repository.QuizQuestionsRepository

class GetQuestionsUseCase(
    private val questionsRepository: QuizQuestionsRepository,
) : BaseUseCase<String, List<QuizQuestionDomainModel>>() {

    override suspend fun invoke(params: String?): List<QuizQuestionDomainModel> {
        return questionsRepository.getQuestionsByTitle((params!!))

    }
}