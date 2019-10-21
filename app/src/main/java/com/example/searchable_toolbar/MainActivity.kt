package com.example.searchable_toolbar
// see must comments
//it have menu file also
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.child_hobby.view.*

class MainActivity : AppCompatActivity() {
    val hobby= mutableListOf<String>()
    var displayList:MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyle.layoutManager = LinearLayoutManager(this)
        recyle.adapter  = hobbyAdapter(hobby,this)
        recyle.adapter = hobbyAdapter(displayList,this)
        load()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        val searchItem = menu!!.findItem(R.id.search)
            val searchView = searchItem.actionView as SearchView
//make sure Searchview import header same to our menu line 11 header file otherwise app crashed
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
 //displayList is our second result array
                    displayList.clear()
                    if(newText!!.isNotEmpty()){
                        val search = newText.toLowerCase()
                        hobby.forEach {
                            if(it.toLowerCase().contains(search)){
                                displayList.add(it)
                            }
                        }
                    }else{
                        displayList.addAll(hobby)
                    }
                    recyle.adapter?.notifyDataSetChanged()
                    return true
                }

            })

        return super.onCreateOptionsMenu(menu)
    }
    fun load(){
        hobby.add("Afghanistan")
        hobby.add("Albania")
        hobby.add("Pakistan")
        hobby.add("India")
        hobby.add("England")
        hobby.add("South Africa")
        hobby.add("Australia")
        hobby.add("France")
        hobby.add("China")
        hobby.add("New Zeland")
        hobby.add("Zimbawe")
        hobby.add("Algeria")
        hobby.add("Turkey")
        hobby.add("Albakista")
        hobby.add("California")
        hobby.add("Emestradum")
        hobby.add("HongKong")
        hobby.add("Malayshia")
        hobby.add("Dubai")
        hobby.add("Soudi Arabia")
        hobby.add("Qatar")
        hobby.add("Oman")
        hobby.add("Behrain")
        hobby.add("Bhutan")
        hobby.add("Brazil")
        hobby.add("Canada")
        hobby.add("Colombia")
        hobby.add("Cuba")
        hobby.add("Denmark")
        hobby.add("Egypt")
        hobby.add("Finland")
        hobby.add("Hungri")
        hobby.add("Iceland")
        hobby.add("Indonasia")
        hobby.add("Iraq")
        hobby.add("Iran")
    }
    class hobbyAdapter(items:List<String>,ctx: Context): RecyclerView.Adapter<hobbyAdapter.ViewHolder>(){
        class ViewHolder(v: View) : RecyclerView.ViewHolder(v){
            val name = v.hobby_name
        }
        var list = items
        var context = ctx
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): hobbyAdapter.ViewHolder {
            return ViewHolder(LayoutInflater.from(context).inflate(R.layout.child_hobby,parent,false))
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: hobbyAdapter.ViewHolder, position: Int) {
            holder.name.text=list.get(position)
        }

    }
}
