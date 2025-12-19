def elabora(lista):
    if (len(lista) == 0):
        return (None, None, None)
    massimo = max(lista)
    minimo = min(lista)
    media = round(sum(lista) / len(lista), 2)

    return (massimo, minimo, media)


print(elabora([2, 3]))