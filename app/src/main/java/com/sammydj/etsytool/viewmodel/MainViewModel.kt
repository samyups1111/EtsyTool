package com.sammydj.etsytool.viewmodel

import androidx.lifecycle.*
import com.sammydj.etsytool.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository): ViewModel() {

    private val _wordToSearch = MutableLiveData<String>()
    val wordToSearch : LiveData<String>
        get() = _wordToSearch

    private val start = 1

    fun isLastPage(): Boolean {
        return repository.networkListSize <= start
    }

    fun loadData(start: Int) {
        viewModelScope.launch {
            refreshNetworkCall(wordToSearch.value ?: "", start)
        }
    }

    fun setWordToSearch(word: String? = "") {
        _wordToSearch.value = word ?: ""
    }

    fun refreshNetworkCall(word: String = "", start: Int) = viewModelScope.launch {
        repository.refreshShopList(word, start)
    }

    var list = repository.getListFromDatabase()

    fun clearDatabase() = viewModelScope.launch {
        repository.clearDatabase()
    }

    class MainViewModelFactory(private val repository: MainRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}