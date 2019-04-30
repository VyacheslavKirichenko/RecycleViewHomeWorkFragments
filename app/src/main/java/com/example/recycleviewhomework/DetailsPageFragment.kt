package com.example.recycleviewhomework

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_details_page.*

class DetailsPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity?.intent?.extras != null ) {
            var id = activity!!.intent.getStringExtra("id")
            displayContact(id)
        } else {
            displayContact("0")                 // Default value - pozition = 0, run on the create in landscape mode
        }
    }
    fun displayContact (id: String){
        var employe2 = MainActivityFragment.result[(id).toInt()]
            lbl_name.text = employe2.emp_name
            lbl_designation.text = employe2.emp_designation
            lbl_salary.text = employe2.emp_salary
            image_fotoDetail_laout.setImageResource(employe2.emp_photo!!)
    }
}
