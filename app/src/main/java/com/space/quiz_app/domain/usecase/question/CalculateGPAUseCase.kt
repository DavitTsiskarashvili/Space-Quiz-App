package com.space.quiz_app.domain.usecase.question

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.common.extensions.roundToSingleDecimal
import com.example.corecommon.domain.repository.QuizUserRepository
import com.example.corecommon.domain.repository.QuizUserSubjectsRepository

class CalculateGPAUseCase(
    private val quizUserSubjectsRepository: QuizUserSubjectsRepository,
    private val quizUserRepository: QuizUserRepository
): BaseUseCase<String, Unit>() {

    override suspend fun invoke(params: String?) {
        val userSubjectPercentages = mutableListOf<Float>()
        quizUserSubjectsRepository.getUserSubjects(params!!).forEach {
            userSubjectPercentages.add(it.score.toFloat() / it.questionsCount)
        }
        val gpa = userSubjectPercentages.average() * 4
        quizUserRepository.saveGPA(params, gpa.toFloat().roundToSingleDecimal())
    }
}