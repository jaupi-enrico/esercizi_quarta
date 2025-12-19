def elabora(lista):
    if (len(lista) == 0):
        return "non esitono valori"
    massimo = max(lista)
    minimo = min(lista)
    media = sum(lista) / len(lista)

    return massimo, minimo, media

print(elabora([2, 3]))