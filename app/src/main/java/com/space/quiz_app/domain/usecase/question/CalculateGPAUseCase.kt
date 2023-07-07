package com.space.quiz_app.domain.usecase.question

import com.space.quiz_app.common.extensions.roundToSingleDecimal
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.domain.repository.QuizUserSubjectsRepository
import com.space.quiz_app.domain.usecase.base.BaseUseCase

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