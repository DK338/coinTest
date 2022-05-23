package com.example.cointest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.cointest.models.DataModel
import com.example.cointest.repositories.DataRepository
import com.example.cointest.responses.DataResponse

class DataResponseViewModel : ViewModel(){

    var datasRepository: DataRepository = DataRepository()

    fun getDataResponses(): LiveData<List<DataModel>>? = datasRepository.getDataResponses()


}