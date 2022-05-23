package com.example.cointest.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cointest.R
import com.example.cointest.adapter.DataAdapter
import com.example.cointest.databinding.ActivityMainBinding
import com.example.cointest.models.DataModel
import com.example.cointest.responses.DataResponse
import com.example.cointest.viewmodels.DataResponseViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: DataResponseViewModel
    private var dataModels: MutableList<DataModel> = mutableListOf<DataModel>()
    private lateinit var dataAdapter: DataAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(DataResponseViewModel::class.java)

        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        dataAdapter = DataAdapter(dataModels)
        binding.recyclerView.layoutManager = linearLayoutManager
        binding.recyclerView.adapter = dataAdapter
        binding.recyclerView.setHasFixedSize(true)

        getDataResponses()

    }






    fun getDataResponses() {
        var dataResponse: Observer<List<DataModel>> = Observer<List<DataModel>> {
//            Toast.makeText(this,"測試:"+it.get(0).nowID,Toast.LENGTH_LONG).show()
            dataModels.addAll(it)
            dataAdapter.notifyDataSetChanged()
        }
        viewModel.getDataResponses()?.observe(this, dataResponse)
    }
}