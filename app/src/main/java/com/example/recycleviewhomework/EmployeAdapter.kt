package com.example.recycleviewhomework

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class EmplyeAdapter(context: Context, emps: List<Employe>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context
    var pozId: Int = 0
    var employes: List<Employe>

    init {
        this.context = context
        this.employes = emps
    }

    private lateinit var listener: Listener
    interface Listener {
        fun onClick(position: Int)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return EmployeHolder(inflater.inflate(R.layout.cell_layout, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        pozId = position
        val employe = employes[position]
        val eh = holder as EmployeHolder
        eh.lbl_designation.setText(employe.emp_designation)
        eh.lbl_name.setText(employe.emp_name)
        eh.lbl_salary.setText(employe.emp_salary)
        eh.img_emp.setImageResource(employe.emp_photo!!)
        eh.itemView.setOnClickListener {
            listener.onClick(position)
        }
    }
    override fun getItemCount(): Int {
        return employes.size
    }

    internal class EmployeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var lbl_name: TextView
        var img_emp: ImageView
        var lbl_designation: TextView
        var lbl_salary: TextView

        init {
            lbl_name = itemView.findViewById(R.id.lbl_name) as TextView
            img_emp = itemView.findViewById(R.id.image_fotoDetail_laout) as ImageView
            lbl_designation = itemView.findViewById(R.id.lbl_designation) as TextView
            lbl_salary = itemView.findViewById(R.id.lbl_salary) as TextView
        }
    }
}