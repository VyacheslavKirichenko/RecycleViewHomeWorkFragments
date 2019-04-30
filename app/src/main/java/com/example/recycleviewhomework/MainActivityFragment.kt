package com.example.recycleviewhomework


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_activity.*

class MainActivityFragment : Fragment() {
    companion object {
        lateinit var result: ArrayList<Employe>
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_activity, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var adapter: EmplyeAdapter? = null
        var empList: ArrayList<Employe>
        empList = generateEmployeeData()
        adapter = EmplyeAdapter(context!!, empList)
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) ///this ->context
        rv_emp.setLayoutManager(layoutManager)
        adapter.setListener(object : EmplyeAdapter.Listener {
            override fun onClick(position: Int) {
                empClick(position)
            }
        } )
        rv_emp.adapter = adapter
    }

    fun empClick(id:Int){
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val intent = Intent(activity, DetailPage::class.java)
            intent.putExtra("id",id.toString() )
            startActivity(intent)

        }else{
            val detailsPageFragmentVariable = fragmentManager!!.findFragmentById(R.id.details_fragment) as DetailsPageFragment
            detailsPageFragmentVariable.displayContact(id.toString())
        }
    }

    fun generateEmployeeData(): ArrayList<Employe> {
        MainActivityFragment.result = ArrayList<Employe>()
        var emp: Employe = Employe()
        emp.emp_id = 1
        emp.emp_name = "Patric Kopitov"
        emp.emp_designation = "President"
        emp.emp_salary = "USD ------$"
        emp.emp_photo = R.drawable.b1
        MainActivityFragment.result.add(emp)

        emp = Employe()
        emp.emp_id = 2
        emp.emp_name = "Arnold Greeder"
        emp.emp_designation = "Developer"
        emp.emp_salary = "USD 18000$"
        emp.emp_photo = R.drawable.b2
        MainActivityFragment.result.add(emp)

        emp = Employe()
        emp.emp_id = 3
        emp.emp_name = "Oksana Kobylko"
        emp.emp_designation = "Manager"
        emp.emp_salary = "USD 3000$"
        emp.emp_photo = R.drawable.b3
        MainActivityFragment.result.add(emp)

        emp = Employe()
        emp.emp_id = 4
        emp.emp_name = "Petro Mogila"
        emp.emp_designation = "Developer"
        emp.emp_salary = "USD 3100$"
        emp.emp_photo = R.drawable.b4
        MainActivityFragment.result.add(emp)

        emp = Employe()
        emp.emp_id = 5
        emp.emp_name = "Sergey Gavrilov"
        emp.emp_designation = "Driver"
        emp.emp_salary = "USD 1200$"
        emp.emp_photo = R.drawable.b5
        MainActivityFragment.result.add(emp)

        emp = Employe()
        emp.emp_id = 6
        emp.emp_name = "Masha Malina"
        emp.emp_designation = "Singer"
        emp.emp_salary = "USD 2000$"
        emp.emp_photo = R.drawable.g1
        MainActivityFragment.result.add(emp)

        emp = Employe()
        emp.emp_id = 7
        emp.emp_name = "Petya Gdanov"
        emp.emp_designation = "Teacher"
        emp.emp_salary = "USD 1000$"
        emp.emp_photo = R.drawable.b6
        MainActivityFragment.result.add(emp)

        emp = Employe()
        emp.emp_id = 8
        emp.emp_name = "Natasha Ponkova"
        emp.emp_designation = "Model"
        emp.emp_salary = "USD 3000$"
        emp.emp_photo = R.drawable.g2
        MainActivityFragment.result.add(emp)

        emp = Employe()
        emp.emp_id = 9
        emp.emp_name = "Yana Curkchi"
        emp.emp_designation = "Freelancer"
        emp.emp_salary = "USD 2000$"
        emp.emp_photo = R.drawable.g3
        MainActivityFragment.result.add(emp)

        return result
    }
}
