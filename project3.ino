#include <Wire.h>
#include "Adafruit_MPR121.h"

#ifndef bitval                    //Bitvalue for each pin
#define bitval(bit) (1 << (bit))  //Initialize
#endif

/**
 * @Author Javier Falca
 * The following code is written to check if the pins are being touched or not
 * Code is written with the help of the MPR121 library and based on the test code provided by Adafruit
 */
Adafruit_MPR121 cap = Adafruit_MPR121();

// Keeps track of the last pin number touched
uint16_t lastTouched = 0;
//  Whether the pin is being touched or not
uint16_t isTouched = 0;

void setup() {
  Serial.begin(9600);

  while (!Serial) { // Otherwise Metro will start too fast
    delay(10);
  }

}

void loop() {
  // Get the currently touched pads
  isTouched = cap.touched();
  
  for (uint8_t i=0; i<12; i++) {
    // Check if it's touched and wasn't touched before
    if ((isTouched & bitval(i)) && !(lastTouched & bitval(i)) ) {
      Serial.print(i); 
      Serial.println(" touched");
    }
  }

  // reset our state
  lastTouched = isTouched;

  
}
