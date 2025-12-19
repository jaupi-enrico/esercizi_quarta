import random

secret = random.randint(1, 20)
guess = -1
tentativi = 0

while guess != secret:
    tentativi += 1
    guess = int(input("Indovina il numero (1-20): "))

    if guess < secret:
        print("Troppo basso!")
    elif guess > secret:
        print("Troppo alto!")

print(f"Numero indovinato in {tentativi} tentativi")