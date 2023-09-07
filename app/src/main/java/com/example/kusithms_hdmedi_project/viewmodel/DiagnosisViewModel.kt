package com.example.kusithms_hdmedi_project.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DiagnosisViewModel: ViewModel() {
    private val _questionList = MutableStateFlow<List<String>>(emptyList())
    val questionList = _questionList.asStateFlow()    // 전체 문항들

    private val _nowQuestion = MutableStateFlow<String>("")
    val nowQuestion = _nowQuestion.asStateFlow()     // 현재 사용자가 보고 있는 문항

    val pbStepSize = MutableLiveData<Int>(0)

    fun nextQuestion(nextIndex : Int) {
        _nowQuestion.value = questionList.value[nextIndex]

        pbStepSize.value = pbStepSize.value?.plus(100 / questionList.value.size)
    }

    fun prevQuestion(prevIndex: Int) {
        _nowQuestion.value = questionList.value[prevIndex]

        pbStepSize.value = pbStepSize.value?.minus(100 / questionList.value.size)
    }

    fun getQuestionList() {
        val testList = mutableListOf<String>()
        testList.add("첫번째 문항")
        testList.add("두번째 문항")
        testList.add("세번째 문항 3333")
        testList.add("네번째 문항")
        testList.add("다섯번째 문항")
        testList.add("여섯번째 문항 666666666666666666666")
        testList.add("일곱번째 문항")
        testList.add("여덟번째 문항 마지막입니다~")

        _questionList.update { testList }
    }
}