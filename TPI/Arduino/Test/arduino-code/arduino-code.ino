const int LED = 13;

const int DOT = 200;
const int DASH = 600;
const int SYMBOL_PAUSE = 200;
const int LETTER_PAUSE = 600;
const int WORD_PAUSE = 1400;

void dot() {
  digitalWrite(LED, HIGH);
  delay(DOT);
  digitalWrite(LED, LOW);
  delay(SYMBOL_PAUSE);
}

void dash() {
  digitalWrite(LED, HIGH);
  delay(DASH);
  digitalWrite(LED, LOW);
  delay(SYMBOL_PAUSE);
}

void sendChar(char c) {
  switch (c) {
    case 'A': dot(); dash(); break;
    case 'B': dash(); dot(); dot(); dot(); break;
    case 'C': dash(); dot(); dash(); dot(); break;
    case 'D': dash(); dot(); dot(); break;
    case 'E': dot(); break;
    case 'F': dot(); dot(); dash(); dot(); break;
    case 'G': dash(); dash(); dot(); break;
    case 'H': dot(); dot(); dot(); dot(); break;
    case 'I': dot(); dot(); break;
    case 'J': dot(); dash(); dash(); dash(); break;
    case 'K': dash(); dot(); dash(); break;
    case 'L': dot(); dash(); dot(); dot(); break;
    case 'M': dash(); dash(); break;
    case 'N': dash(); dot(); break;
    case 'O': dash(); dash(); dash(); break;
    case 'P': dot(); dash(); dash(); dot(); break;
    case 'Q': dash(); dash(); dot(); dash(); break;
    case 'R': dot(); dash(); dot(); break;
    case 'S': dot(); dot(); dot(); break;
    case 'T': dash(); break;
    case 'U': dot(); dot(); dash(); break;
    case 'V': dot(); dot(); dot(); dash(); break;
    case 'W': dot(); dash(); dash(); break;
    case 'X': dash(); dot(); dot(); dash(); break;
    case 'Y': dash(); dot(); dash(); dash(); break;
    case 'Z': dash(); dash(); dot(); dot(); break;
    case ' ':
      delay(WORD_PAUSE);
      return;
  }
  delay(LETTER_PAUSE);
}

void sendMessage(const char* msg) {
  while (*msg) {
    sendChar(toupper(*msg));
    msg++;
  }
}

void setup() {
  pinMode(LED, OUTPUT);
}

void loop() {
  sendMessage("SOS");
  delay(10 * 1000);
}
