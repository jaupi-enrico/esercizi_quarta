import json
import requests
import os
import matplotlib.pyplot as plt
import folium


os.environ["HTTP_PROXY"]  = "http://127.0.0.1:8888"
os.environ["HTTPS_PROXY"] = "http://127.0.0.1:8888"


url = "https://raw.githubusercontent.com/cristianst85/GeoNuclearData/master/data/json/denormalized/nuclear_power_plants.json"
response = requests.get(url)
dati = response.json()

def elenca_nomi(datas):
    for d in datas:
        print(d["Name"])

def elenca_operativi(datas):
    for d in datas:
        if d["Status"] == "Operational":
            print(d["Name"])

def percentuale_operativi(datas):
    tot = len(datas)
    op = sum(1 for d in datas if d["Status"] == "Operational")
    perc = op / tot * 100
    print(f"Reattori operativi: {op}/{tot} ({perc:.2f}%)")

def conta_status(datas):
    stati = {}
    for d in datas:
        stati[d["Status"]] = stati.get(d["Status"], 0) + 1
    return stati

def grafico_status(datas):
    stati = conta_status(datas)
    plt.bar(stati.keys(), stati.values())
    plt.xticks(rotation=45)
    plt.title("Numero di reattori per status")
    plt.ylabel("Numero reattori")
    plt.tight_layout()
    plt.show()

def cerca_per_id(datas):
    id_cercato = input("Inserisci ID del reattore: ")
    for d in datas:
        if str(d["Id"]) == id_cercato:
            print(json.dumps(d, indent=2))
            return
    print("Reattore non trovato.")

def mappa_operativi(datas):
    operativi = []
    nonOperativi = []

    for d in datas:
        if d["Latitude"] is None or d["Longitude"] is None:
            continue
        if d["Status"] == "Operational":
            operativi.append(d)
        else:
            nonOperativi.append(d)
    
    print("Operative:", len(operativi))
    print("Non operative:", len(nonOperativi))

    avg_lat = sum(d["Latitude"] for d in operativi) / len(operativi)
    avg_lon = sum(d["Longitude"] for d in operativi) / len(operativi)

    m = folium.Map(location=[avg_lat, avg_lon], zoom_start=2)

    fg_op = folium.FeatureGroup(name="Operative")
    fg_nop = folium.FeatureGroup(name="Non operative")

    for d in operativi:
        folium.Marker(
            [d["Latitude"], d["Longitude"]],
            popup=f"{d['Name']} ({d['Country']})",
            icon=folium.Icon(color="green", icon="flash")
        ).add_to(fg_op)

    for d in nonOperativi:
        folium.Marker(
            [d["Latitude"], d["Longitude"]],
            popup=f"{d['Name']} ({d['Country']})",
            icon=folium.Icon(color="red", icon="remove-sign")
        ).add_to(fg_nop)

    fg_op.add_to(m)
    fg_nop.add_to(m)
    folium.LayerControl().add_to(m)

    m.save("mappa.html")
    print("Mappa salvata come mappa.html")

def menu():
    while True:
        print("\n===== MENU =====")
        print("1 - Elenca tutti i reattori")
        print("2 - Elenca reattori operativi")
        print("3 - Percentuale reattori operativi")
        print("4 - Grafico reattori per status")
        print("5 - Cerca reattore per ID")
        print("6 - Mappa centrali operative")
        print("0 - Esci")

        scelta = input("Scelta: ")

        if scelta == "1":
            elenca_nomi(dati)
        elif scelta == "2":
            elenca_operativi(dati)
        elif scelta == "3":
            percentuale_operativi(dati)
        elif scelta == "4":
            grafico_status(dati)
        elif scelta == "5":
            cerca_per_id(dati)
        elif scelta == "6":
            mappa_operativi(dati)
        elif scelta == "0":
            print("Uscita dal programma.")
            break
        else:
            print("Scelta non valida.")

menu()