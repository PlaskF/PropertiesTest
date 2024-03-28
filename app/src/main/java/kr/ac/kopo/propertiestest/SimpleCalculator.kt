package kr.ac.kopo.propertiestest

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
    lateinit var textResult:TextView
    var result: Int? = null

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
        textResult = findViewById<TextView>(R.id.textResult)

        btnPlus.setOnClickListener {
            val num1 = edit1.text.toString().toInt()
            val num2 = edit2.text.toString().toInt()
            result = num1 + num2
            textResult.text = "계산 결과: " + result
        }
        btnMinus.setOnClickListener {
            val num1 = edit1.text.toString().toInt()
            val num2 = edit2.text.toString().toInt()
            result = num1 - num2
            textResult.text = "계산 결과: " + result
        }
        btnMultiply.setOnClickListener {
            val num1 = edit1.text.toString().toInt()
            val num2 = edit2.text.toString().toInt()
            result = num1 * num2
            textResult.text = "계산 결과: " + result
        }
        btnDivide.setOnClickListener {
            val num1 = edit1.text.toString().toInt()
            val num2 = edit2.text.toString().toInt()
            result = num1 / num2
            textResult.text = "계산 결과: " + result
        }
    }
}