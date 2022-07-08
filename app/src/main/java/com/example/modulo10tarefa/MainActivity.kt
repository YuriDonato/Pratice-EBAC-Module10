package com.example.modulo10tarefa

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modulo10.ListAdapter
import com.example.modulo10tarefa.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val itemList: MutableList<ListItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listView = binding.lista

        //Gerador automatico
        var tamanhoLista = 15
        var quantidadeIcones = 5
        var icons: IntArray = intArrayOf(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
        var nomes: Array<String> = arrayOf("0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15")
        var numeros: Array<String> = arrayOf("(89) 98473-6678",
            "(54) 98126-7544",
            "(88) 96763-2225",
            "(83) 99316-1620",
            "(55) 98679-0275",
            "(82) 98445-8418",
            "(74) 97310-6554",
            "(67) 97114-2121",
            "(34) 98635-9451",
            "(21) 98982-7556",
            "(34) 98986-2322",
            "(33) 98752-3793",
            "(68) 98695-1246",
            "(86) 96776-6533",
            "(98) 99467-2964",
            "(44) 98334-2861")
        /*for(i in 0..tamanhoLista){
            nomes[i] = "$i"
            numeros[i] = "$i"
            icons[i] = i
        }*/

        //nomes
        for (i in nomes.indices){
            when((1..tamanhoLista).random()){
                1 -> nomes[i] = "Lex"
                2 -> nomes[i] = "Roma"
                3 -> nomes[i] = "Johnathon"
                4 -> nomes[i] = "Fynley"
                5 -> nomes[i] = "Akeem"
                6 -> nomes[i] = "Maysa"
                7 -> nomes[i] = "Connor"
                8 -> nomes[i] = "Lyra"
                9 -> nomes[i] = "John-Paul"
                10 -> nomes[i] = "Nicole"
                11 -> nomes[i] = "Evangeline"
                12 -> nomes[i] = "Kirstin"
                13 -> nomes[i] = "Fabien"
                14 -> nomes[i] = "Nazifa"
                15 -> nomes[i] = "Jaspal"
                16 -> nomes[i] = "Joana"
            }
        }
        //numeros
            //Deletei pois achei que nao faria sentido pra uma lista de contatos existir numeros repitidos com nomes diferentes

        //icones
       for (i in icons.indices){
           when((1..quantidadeIcones).random()){
                1 -> icons[i] = R.drawable.icone
                2 -> icons[i] = R.drawable.icone_02
                3 -> icons[i] = R.drawable.icone_03
                4 -> icons[i] = R.drawable.icone_04
                5 -> icons[i] = R.drawable.icone_05
               else ->
                   icons[i] = R.drawable.icone
            }
        }

        createMockData(tamanhoLista,nomes,numeros,icons)

        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = ListAdapter(itemList,this)

        //Background Animado
        val constraintLayout = findViewById<ConstraintLayout>(R.id.layout)
        val animationDrawable: AnimationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()
    }

    //Criar a lista na mao
    private fun createMockData(tamanho: Int, nomes: Array<String>,numeros: Array<String>,icons: IntArray){

        for(i in 0..tamanho){
            itemList.add(ListItem(nomes[i],numeros[i],icons[i]))
        }
        /*
        itemList.add(ListItem("Lex","(89) 98473-6678",icons[0]))
        itemList.add(ListItem("Roma","(54) 98126-7544",icons[1]))
        itemList.add(ListItem("Johnathon","(88) 96763-2225",icons[2]))
        itemList.add(ListItem("Fynley","(83) 99316-1620",icons[3]))
        itemList.add(ListItem("Akeem","(55) 98679-0275",icons[4]))
        itemList.add(ListItem("Maysa","(82) 98445-8418",icons[5]))
        itemList.add(ListItem("Connor","(74) 97310-6554",icons[6]))
        itemList.add(ListItem("Lyra","(67) 97114-2121",icons[7]))
        itemList.add(ListItem("John-Paul","(34) 98635-9451",icons[8]))
        itemList.add(ListItem("Nicole","(21) 98982-7556",icons[9]))
        itemList.add(ListItem("Evangeline","(34) 98986-2322",icons[10]))
        itemList.add(ListItem("Kirstin","(33) 98752-3793",icons[11]))
        itemList.add(ListItem("Fabien","(68) 98695-1246",icons[12]))
        itemList.add(ListItem("Nazifa","(86) 96776-6533",icons[13]))
        itemList.add(ListItem("Jaspal","(98) 99467-2964",icons[14]))
        itemList.add(ListItem("Joana","(44) 98334-2861",icons[15]))*/

    }

    fun onItemClicked(content: String){
        Snackbar.make(binding.root,content,Snackbar.LENGTH_SHORT).show()
    }
}