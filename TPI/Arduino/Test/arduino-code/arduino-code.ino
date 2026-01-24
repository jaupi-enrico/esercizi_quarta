int valore = 0;

void setup() {
  Serial.begin(9600);
}

void loop() {
  valore++;
  Serial.println(valore);
  delay(1 * 1000);
}
