
package encinas.manuel.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    var numero1: Double = 0.0
    var numero2: Double = 0.0
    var operacionEnUso: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cero = findViewById<Button>(R.id.buttonCero)
        val uno = findViewById<Button>(R.id.buttonUno)
        val dos = findViewById<Button>(R.id.buttonDos)
        val tres = findViewById<Button>(R.id.buttonTres)
        val cuatro = findViewById<Button>(R.id.buttonCuatro)
        val cinco = findViewById<Button>(R.id.buttonCinco)
        val seis = findViewById<Button>(R.id.buttonSeis)
        val siete = findViewById<Button>(R.id.buttonSiete)
        val ocho = findViewById<Button>(R.id.buttonOcho)
        val nueve = findViewById<Button>(R.id.buttonNueve)
        val suma = findViewById<Button>(R.id.buttonSuma)
        val resta = findViewById<Button>(R.id.buttonResta)
        val multiplicacion = findViewById<Button>(R.id.buttonMultiplicacion)
        val division = findViewById<Button>(R.id.buttonDivision)
        val resultado = findViewById<Button>(R.id.buttonResultado)
        val borrar = findViewById<Button>(R.id.buttonBorrar)
        val textoResultado = findViewById<TextView>(R.id.textoResultado)
        val textoProblema = findViewById<TextView>(R.id.textViewProblema)

        cero.setOnClickListener  { numeroPresionado("0") }
        uno.setOnClickListener   { numeroPresionado("1") }
        dos.setOnClickListener   { numeroPresionado("2") }
        tres.setOnClickListener  { numeroPresionado("3") }
        cuatro.setOnClickListener{ numeroPresionado("4") }
        cinco.setOnClickListener { numeroPresionado("5") }
        seis.setOnClickListener  { numeroPresionado("6") }
        siete.setOnClickListener { numeroPresionado("7") }
        ocho.setOnClickListener  { numeroPresionado("8") }
        nueve.setOnClickListener { numeroPresionado("9") }

        suma.setOnClickListener           { operacionPresionada(SUMA) }
        resta.setOnClickListener          { operacionPresionada(RESTA) }
        multiplicacion.setOnClickListener { operacionPresionada(MULTIPLICACION) }
        division.setOnClickListener       { operacionPresionada(DIVISION) }

        resultado.setOnClickListener {
            var total = when(operacionEnUso){
                SUMA -> numero1+numero2
                RESTA -> numero1-numero2
                MULTIPLICACION-> numero1*numero2
                DIVISION -> numero1/numero2
                else -> 0
            }
            textoResultado.text = total.toString()
        }

        borrar.setOnClickListener {
            numero1 = 0.0
            numero2 = 0.0
            textoResultado.text = ""
            textoProblema.text = ""
            operacionEnUso = SIN_OPERACION
        }
    }

    //Modificando
    private fun numeroPresionado(numero: String){
        val textoResultado = findViewById<TextView>(R.id.textoResultado)

        //Modificando
        val textoProblema = findViewById<TextView>(R.id.textViewProblema)

        textoResultado.text = "${textoResultado.text}$numero"
        //Modificando
        textoProblema.text = "${textoProblema.text}$numero"

        if (operacionEnUso == SIN_OPERACION){
            numero1 = textoResultado.text.toString().toDouble()
        }else{
            numero2 = textoResultado.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion:Int){
        val resultado = findViewById<TextView>(R.id.textoResultado)
        val textoProblema = findViewById<TextView>(R.id.textViewProblema)

        this.operacionEnUso=operacion
        if (this.operacionEnUso== SUMA){
            textoProblema.text = this.numero1.toString()+"+"
        }else if (this.operacionEnUso== RESTA){
            textoProblema.text = this.numero1.toString()+"-"
        }else if(this.operacionEnUso== MULTIPLICACION){
            textoProblema.text = this.numero1.toString()+"*"
        }else if(this.operacionEnUso== DIVISION){
            textoProblema.text = this.numero1.toString()+"/"
        }

        resultado.text = ""
    }

    companion object {
        val SUMA=1
        val RESTA=2
        val MULTIPLICACION=3
        val DIVISION=4
        val SIN_OPERACION=0
    }




}