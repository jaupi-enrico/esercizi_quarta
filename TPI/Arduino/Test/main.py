import serial
import time


ser = serial.Serial("COM5", 9600, timeout=1)
sum = 0
conteggio = 0
soglia = 10

file = open("dati.csv", "w")
try:
    while True:
        raw = ser.readline()
        if not raw:
            continue
        data = raw.decode('utf-8', errors='replace').strip()
        if data == "":
            continue

        valore = int(data)
        conteggio += 1
        sum += valore
        media = sum/conteggio
        orario = time.strftime("%H:%M:%S")
        file.write(f"{orario},{valore}\n")
        file.flush()

        if valore > soglia:
            print(f"Soglia superata, valore: {valore}")

        #print(f"valore: {valore} | sum: {sum} | media: {media: .2f} | orario = {orario}")
finally:
    ser.close()