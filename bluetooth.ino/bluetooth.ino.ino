char rxChar;    // Variable para recibir datos del puerto serie
int analogPin1 = 3;
int analogPin2 = 5;
int analogPin3 =6;
String color ="";
int cont = 0;
int i =0;
String msj = "";
// Configurar el arduino
void setup()
{
  // Pin 13 como salida
 
  // Comunicación serie a 9600 baudios
  Serial.begin(9600);
}

// Ciclo infinito, programa principal
void loop()
{
  // Si hay datos disponibles en el buffer
  
  if( Serial.available() )
  {
    // Leer un byte y colocarlo en variable
    rxChar=' ';
    msj="";
    color="";
    while (rxChar!='/'){
      rxChar = Serial.read();
      msj.concat(rxChar);
      Serial.print(rxChar);
      
    }
    int indexn = msj.indexOf("/");
   color=msj.substring(11,indexn);
    Serial.println("mensaje");
    Serial.println(msj);
    Serial.println("color");
    Serial.println(color);
    Serial.println("  ");
    //Serial.flush();
    if (color=="Rojo") {
      analogWrite(analogPin1,255);
      analogWrite(analogPin2,0);
      analogWrite(analogPin3,0);
    }
    if(color=="Verde"){
      analogWrite(analogPin1,0);
      analogWrite(analogPin2,255);
      analogWrite(analogPin3,0);
    }
    if(color=="Azul"){
      analogWrite(analogPin1,0);
      analogWrite(analogPin2,0);
      analogWrite(analogPin3,255);
    }
    if(color=="Ninguno"){
      analogWrite(analogPin1,0);
      analogWrite(analogPin2,0);
      analogWrite(analogPin3,0);
    }
    if(color=="Amarillo"){
      analogWrite(analogPin1,255);
      analogWrite(analogPin2,150);
      analogWrite(analogPin3,0);
    }
    if(color=="Celeste"){
      analogWrite(analogPin1,0);
      analogWrite(analogPin2,255);
      analogWrite(analogPin3,255);
    }
    if(color=="Violeta"){
      analogWrite(analogPin1,255);
      analogWrite(analogPin2,0);
      analogWrite(analogPin3,255);
    }
    
  
  }
  

  // Podemos hacer otras cosas aquí
  delay(100);
}
