def primi(lista):
    primi = []

    if (len(lista) == 0):
        return primi
    
    for e in lista:
        if (e < 2):
            continue
        aggiungi = True
        for i in range(2, int(e**0.5) + 1):
            if (e % i == 0):
                aggiungi = False
        if (aggiungi):
            primi.append(e)


    return primi


print(primi([2, 3, 4]))