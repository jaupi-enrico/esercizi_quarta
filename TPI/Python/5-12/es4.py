def somma_quad(n):
    somma = 0
    for i in range(1, n + 1):
        somma += i * i
    return somma


def somma_quad_fatta_bene(n):
    return n*(n + 1)*(2*n + 1) / 6


print(somma_quad(4))
print(somma_quad_fatta_bene(4))