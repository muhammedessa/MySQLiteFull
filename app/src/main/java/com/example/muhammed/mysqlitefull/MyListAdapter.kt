package com.example.muhammed.mysqlitefull

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

/**
 * Created by muhammed on 11/11/17.
 */
class MyListAdapter(var mCtx :Context , var resource:Int,var items:List<Employee>)
    :ArrayAdapter<Employee>(mCtx , resource, items){

    internal var helper = DatabaseHelper(mCtx)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater :LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resource,null)

        val myid :TextView = view.findViewById(R.id.myid)
        val firstname :TextView = view.findViewById(R.id.firstnameText)
        val lastname :TextView = view.findViewById(R.id.lastnameText)

        val update : Button = view.findViewById(R.id.updateBtn)
        val delete : Button = view.findViewById(R.id.deleteBtn)

        val employee :Employee = items[position]

        myid.text = employee.id
        firstname.text = employee.firstname
        lastname.text = employee.lastname

        update.setOnClickListener {
            updateInfo(employee)
        }

        delete.setOnClickListener {
            delete(employee)
        }

        return  view
    }



   fun updateInfo(employee:Employee){
        val builder = AlertDialog.Builder(mCtx)
       builder.setTitle("Update Info")
       val inflater = LayoutInflater.from(mCtx)
       val view  = inflater.inflate(R.layout.employee_update,null)

       val firstname :EditText = view.findViewById(R.id.firstnameUpdate)
       val lastname :EditText = view.findViewById(R.id.lastnameUpdate)
       val age :EditText = view.findViewById(R.id.ageupdate)
       val address :EditText = view.findViewById(R.id.addressUpdate)
       val department :EditText = view.findViewById(R.id.departmentUpdate)

       firstname.setText(employee.firstname)
       lastname.setText(employee.lastname)
       age.setText(employee.age)
       address.setText(employee.address)
       department.setText(employee.department)


       builder.setView(view)

       builder.setPositiveButton("Update",object :DialogInterface.OnClickListener{
           override fun onClick(dialog: DialogInterface?, which: Int) {

               val isUpdate = helper.updateData(employee.id ,
                       firstname.text.toString().trim(),
                       lastname.text.toString().trim(),
                       age.text.toString().trim(),
                       address.text.toString().trim(),
                       department.text.toString().trim() )
               if (isUpdate==true)
                   Toast.makeText(mCtx,"Updated :)",Toast.LENGTH_LONG).show()
               else
                   Toast.makeText(mCtx,"failed update :(",Toast.LENGTH_LONG).show()

           }

       })

       builder.setNegativeButton("cancel",object :DialogInterface.OnClickListener{
           override fun onClick(dialog: DialogInterface?, which: Int) {

           }

       })



       val alert = builder.create()
       alert.show()
    }

fun delete(employee:Employee){
    helper.deleteData(employee.id)
}

}