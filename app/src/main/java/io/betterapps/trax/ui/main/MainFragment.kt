package io.betterapps.trax.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.betterapps.trax.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel


        request_button.setOnClickListener {
            // Do something in response to button click
            request()
        }
    }

    public fun request(): Unit {
//        CustomCertClient().run()
        viewModel.getMoviesResponse().observe(this, Observer { it ->
            handleResponse(it)
        })
    }

    private fun handleResponse(response: String) {

        Toast.makeText(context, "Message ${response}", Toast.LENGTH_SHORT).show()
    }

}
