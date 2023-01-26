package com.example.tictac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {

        val btnSelect = view as Button
        var cellId  = 0
        when(btnSelect.id){
            R.id.btn1 -> cellId=1
            R.id.btn2 -> cellId=2
            R.id.btn3 -> cellId=3
            R.id.btn4 -> cellId=4
            R.id.btn5 -> cellId=5
            R.id.btn6 -> cellId=6
            R.id.btn7 -> cellId=7
            R.id.btn8 -> cellId=8
            R.id.btn9 -> cellId=9
        }

       // Log.d("BtnClick",btnId.id.toString())
       // Log.d("BtnClick Cellid",cellId.toString())

        playGame(cellId,btnSelect)
    }

    var actPlay = 1
    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()
    fun playGame(cellId : Int, btnSelect :Button){

        if(actPlay == 1){

            btnSelect.text="X"
            btnSelect.setBackgroundResource(R.color.red)
            player1.add(cellId)
            actPlay=2
        }else{
            btnSelect.text="O"
            btnSelect.setBackgroundResource(R.color.green)
            player2.add(cellId)
            actPlay=1
        }

        btnSelect.isEnabled = false   //To ensure button not click again
        checkWinner()
    }

    fun checkWinner(){

        var winner = -1

        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }

        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }

        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }

        //col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(6)){
            winner=2
        }

        //col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }

        //col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        //d1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }

        //d2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner=1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner=2
        }

        if(winner==1){
            Toast.makeText(this,"Player 1 is Winner",Toast.LENGTH_LONG).show()
            reStart()
            player1Win++
        }else if(winner==2){
            Toast.makeText(this,"Player 2 is Winner",Toast.LENGTH_LONG).show()
            reStart()
            player2Win++
        }else{

            var emptyCell = arrayListOf<Int>()
            for(cellId in 1..9){
                if(!(player1.contains(cellId) || player2.contains(cellId))){
                    emptyCell.add(cellId)
                }
            }

            if(emptyCell.size == 0){
                reStart()
            }
        }
    }

    var player1Win = 0
    var player2Win = 0



    fun reStart(){

        actPlay=1
        player1.clear()
        player2.clear()

        for(cellId  in 1..9){

            var btnSelect:Button?
            btnSelect = when(cellId){

                1 -> btn1
                2 -> btn2
                3 -> btn3
                4 -> btn4
                5 -> btn5
                6 -> btn6
                7 -> btn7
                8 -> btn8
                9 -> btn9
               else ->{btn1}
            }

            btnSelect!!.text=""
            btnSelect!!.setBackgroundResource(R.color.white)
            btnSelect!!.isEnabled = true
        }
    }
}