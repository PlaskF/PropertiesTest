package kr.ac.kopo.propertiestest

import android.os.Bundle
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SimpleCalculator : AppCompatActivity() {
    lateinit var edit1:EditText
    lateinit var edit2:EditText
    lateinit var btnPlus:Button
    lateinit var btnMinus:Button
    lateinit var btnMultiply:Button
    lateinit var btnDivide:Button
    lateinit var btnRest:Button
    lateinit var textResult:TextView
    var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_simple_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        위젯 객체의 참조값을 필드로 선언된 참조변수에 대입
        edit1 = findViewById<EditText>(R.id.edit1)
        edit2 = findViewById<EditText>(R.id.edit2)
        btnPlus = findViewById<Button>(R.id.btnPlus)
        btnMinus = findViewById<Button>(R.id.btnMinus)
        btnMultiply = findViewById<Button>(R.id.btnMultiply)
        btnDivide = findViewById<Button>(R.id.btnDivide)
        btnRest = findViewById<Button>(R.id.btnRest)
        textResult = findViewById<TextView>(R.id.textResult)

        btnPlus.setOnClickListener(btnListener)
        btnMinus.setOnClickListener(btnListener)
        btnMultiply.setOnClickListener(btnListener)
        btnDivide.setOnClickListener(btnListener)
        btnRest.setOnClickListener(btnListener)
    }

    var btnListener = OnClickListener{
        val num1Str = edit1.text.toString()
        val num2Str = edit2.text.toString()
//        계산값을 입력하지 않으면 토스트로 오류메시지 반환
        if(num1Str == "" || num2Str == ""){
            Toast.makeText(baseContext, "값을 입력하시오", Toast.LENGTH_LONG).show()
            return@OnClickListener
        }

        val num1 = num1Str.toDouble()
        val num2 = num2Str.toDouble()

//        id값에 따라서 계산
        when(it.id){
            R.id.btnPlus -> result = num1 + num2
            R.id.btnMinus -> result = num1 - num2
            R.id.btnMultiply -> result = num1 * num2
            R.id.btnDivide -> {
                if(num2 == 0.0){
                    Toast.makeText(baseContext, "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show()
//                    계산하지 않고 리턴
                    return@OnClickListener
                }
                result = num1 / num2
            }
            R.id.btnRest -> {
                if(num2 == 0.0){
                    Toast.makeText(baseContext, "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show()
                    return@OnClickListener
                }
                result = num1 % num2
            }
        }

        textResult.text = "계산 결과:" + result
    }
}