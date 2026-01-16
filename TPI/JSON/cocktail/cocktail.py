import time
import requests
from flask import Flask, jsonify, render_template, request
from flask_socketio import SocketIO, emit
import threading
import os


# Settings per il proxy con fiddler
os.environ["HTTP_PROXY"]  = "http://127.0.0.1:8888"
os.environ["HTTPS_PROXY"] = "http://127.0.0.1:8888"

base_url = "https://www.thecocktaildb.com/api/json/v1/1/"

# Inizializzazione Flask e SocketIO
app = Flask(__name__)
app.config['SECRET_KEY'] = 'SalveProfCheAnalizzaIlMioCodice'
socketio = SocketIO(app)

stats = {}
stats = {}
stats_running = False
stats_lock = threading.Lock()


# Funzione per cercare cocktail per nome
def search_name(name):
    url = base_url + "search.php?s=" + name
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per cercare cocktail per lettera
def search_letter(letter):
    url = base_url + "search.php?f=" + letter
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per cercare cocktail per ID
def search_cocktail_id(id):
    url = base_url + "lookup.php?i=" + id
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per cercare ingrediente per nome
def search_ingredient_name(name):
    url = base_url + "search.php?i=" + name
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per cercare ingrediente per ID
def search_ingredient_id(id):
    url = base_url + "lookup.php?iid=" + id
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per ottenere un cocktail random
def random_cocktail():
    url = base_url + "random.php"
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per filtrare cocktail per ingrediente
def search_cocktail_by_ingredient(ingredient):
    url = base_url + "filter.php?i=" + ingredient
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per filtrare cocktail per tipo di alcolico
def get_filtered_alcoholic(alcoholic):
    url = base_url + "filter.php?a=" + alcoholic
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per filtrare cocktail per categoria
def get_filtered_category(category):
    url = base_url + "filter.php?c=" + category
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per filtrare cocktail per tipo di bicchiere
def get_filtered_glass(glass):
    url = base_url + "filter.php?g=" + glass
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per ottenere la lista delle categorie
def get_categories_list():
    url = base_url + "list.php?c=list"
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per ottenere la lista dei bicchieri
def get_glasses_list():
    url = base_url + "list.php?g=list"
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per ottenere la lista degli ingredienti
def get_ingredients_list():
    url = base_url + "list.php?i=list"
    response = requests.get(url)
    dati = response.json()
    return dati

# Funzione per ottenere la lista dei tipi di alcolici
def get_alcoholic_list():
    url = base_url + "list.php?a=list"
    response = requests.get(url)
    dati = response.json()
    return dati

# Route per la pagina principale
@app.route("/")
def index():
    categories = get_categories_list()
    glasses = get_glasses_list()
    ingredients = get_ingredients_list()
    alcoholic = get_alcoholic_list()

    return render_template(
        "index.html",
        categories=categories,
        glasses=glasses,
        ingredients=ingredients,
        alcoholic=alcoholic
    )


# Route per cocktail random
@app.route("/random")
def random_route():
    return render_template("search.html", drinks=random_cocktail())

# Route per ricerca cocktail per nome o lettera
@app.route("/search")
def search_route():
    name = request.args.get("q", "")
    if len(name) == 0:
        dati = {"drinks": []}
    elif len(name) == 1:
        dati = search_letter(name)
    else:
        dati = search_name(name)

    if dati["drinks"] == "no data found":
        dati = {"drinks": []}
    return render_template("search.html", drinks=dati)

# Route per ricerca cocktail per ID
@app.route("/search/id")
def search_id_route():
    id = request.args.get("q", "")
    if len(id) == 0:
        dati = {"drinks": []}
    else:
        dati = search_cocktail_id(id)

    if dati["drinks"] == "no data found":
        dati = {"drinks": []}
    return render_template("search.html", drinks=dati)

# Route per ricerca ingrediente per ID
@app.route("/search/ingredient/id")
def search_ingredient_id_route():
    id = request.args.get("q", "")
    if len(id) == 0:
        dati = {"ingredients": []}
    else:
        dati = search_ingredient_id(id)
    return render_template("search_ingredient.html", ingredients=dati)

# Route per ricerca ingrediente per nome
@app.route("/search/ingredient")
def search_ingredient_route():
    name = request.args.get("q", "")
    if len(name) == 0:
        dati = {"ingredients": []}
    else:
        dati = search_ingredient_name(name)
    return render_template("search_ingredient.html", ingredients=dati)

# Route per filtrare cocktail per tipo di alcolico
@app.route("/alcoholic")
def alcoholic_route():
    alcoholic = request.args.get("q", "")
    if len(alcoholic) == 0:
        dati = {"drinks": []}
    else:
        dati = get_filtered_alcoholic(alcoholic)

    if dati["drinks"] == "no data found":
        dati = {"drinks": []}
    return render_template("drink_list.html", drinks=dati)

# Route per filtrare cocktail per ingrediente
@app.route("/search/by_ingredient")
def search_by_ingredient_route():
    ingredient = request.args.get("q", "")
    if len(ingredient) == 0:
        dati = {"drinks": []}
    else:
        dati = search_cocktail_by_ingredient(ingredient)
    
    if dati["drinks"] == "no data found":
        dati = {"drinks": []}
    return render_template("drink_list.html", drinks=dati)

# Route per ottenere le categorie
@app.route("/categories")
def categories_route():
    dati = get_categories_list()
    return jsonify(dati)

# Route per ottenere i bicchieri
@app.route("/glasses")
def glasses_route():
    dati = get_glasses_list()
    return jsonify(dati)

# Route per ottenere gli ingredienti
@app.route("/ingredients")
def ingredients_route():
    dati = get_ingredients_list()
    return jsonify(dati)

# Route per ottenere i tipi di alcolici
@app.route("/alcoholic_list")
def alcoholic_list_route():
    dati = get_alcoholic_list()
    return jsonify(dati)

# Route per filtrare cocktail per categoria
@app.route("/category")
def search_by_category_route():
    category = request.args.get("q", "")
    if len(category) == 0:
        dati = {"drinks": []}
    else:
        dati = get_filtered_category(category)
    if dati["drinks"] == "no data found":
        dati = {"drinks": []}
    return render_template("drink_list.html", drinks=dati)

# Route per filtrare cocktail per tipo di bicchiere
@app.route("/glass")
def search_by_glass_route():
    glass = request.args.get("q", "")
    if len(glass) == 0:
        dati = {"drinks": []}
    else:
        dati = get_filtered_glass(glass)
    if dati["drinks"] == "no data found":
        dati = {"drinks": []}
    return render_template("drink_list.html", drinks=dati)

# Route per filtri combinati
@app.route("/filter")
def filter_route():
    alcoholic = request.args.get("a", "")
    category = request.args.get("c", "")
    glass = request.args.get("g", "")
    ingredient = request.args.get("i", "")

    result_sets = []

    if alcoholic:
        data = get_filtered_alcoholic(alcoholic)
        if data["drinks"]:
            if data["drinks"] == "no data found":
                data = {"drinks": []}
            result_sets.append({d["idDrink"]: d for d in data["drinks"]})

    if category:
        data = get_filtered_category(category)
        if data["drinks"]:
            if data["drinks"] == "no data found":
                data = {"drinks": []}
            result_sets.append({d["idDrink"]: d for d in data["drinks"]})

    if glass:
        data = get_filtered_glass(glass)
        if data["drinks"]:
            if data["drinks"] == "no data found":
                data = {"drinks": []}
            result_sets.append({d["idDrink"]: d for d in data["drinks"]})

    if ingredient:
        data = search_cocktail_by_ingredient(ingredient)
        if data["drinks"]:
            if data["drinks"] == "no data found":
                data = {"drinks": []}
            result_sets.append({d["idDrink"]: d for d in data["drinks"]})

    if not result_sets:
        return render_template("drink_list.html", error="No filters provided or no results found.")

    common_ids = set(result_sets[0].keys())
    for s in result_sets[1:]:
        common_ids &= set(s.keys())

    final_drinks = [result_sets[0][id] for id in common_ids]

    return render_template(
        "drink_list.html",
        drinks={"drinks": final_drinks}
    )

# Funzione per aggiornare il caricamento in tempo reale
def update_stats(count, total_items):
    socketio.emit('update_stats', {'percentage': count / total_items * 100})

stats = {}

# Funzione per ottenere le statistiche
def get_stats():
    stats = {}
    count_requests = 0
    conta = 0
    time_start = time.time()
    total_items = (
        len(get_alcoholic_list().get("drinks", [])) +
        len(get_categories_list().get("drinks", [])) +
        len(get_glasses_list().get("drinks", [])) +
        len(get_ingredients_list().get("drinks", []))
    )

    # Funzione interna per gestire le richieste API con il rate limit
    def safe_get_drinks(func, name, total_items, retry=False):
        nonlocal count_requests, time_start, conta
        count_requests += 1
        if not retry:
            conta += 1
        update_stats(conta, total_items)
        if count_requests % 60 == 0 and (time.time() - time_start) < 60:
            while (time.time() - time_start) < 60:
                print("Rate limit reached, waiting... " + str(60 - (time.time() - time_start)) + " seconds remaining.")
                time.sleep(1)
            count_requests = 0
            time_start = time.time()
        try:
            data = func(name)
            drinks = data.get("drinks") or []
            return drinks
        except Exception as e:
            print(f"Errore API per '{name}': {e}")
            return safe_get_drinks(func, name, total_items, retry=True)

    # alcolici
    alcoholic = get_alcoholic_list()
    stats["alcoholic"] = []
    for item in alcoholic.get("drinks", []):
        name = item.get("strAlcoholic")
        count = len(safe_get_drinks(get_filtered_alcoholic, name, total_items))
        if count > 0:
            stats["alcoholic"].append({"name": name, "count": count})

    # categorie
    categories = get_categories_list()
    stats["categories"] = []
    for item in categories.get("drinks", []):
        name = item.get("strCategory")
        count = len(safe_get_drinks(get_filtered_category, name, total_items))
        if count > 0:
            stats["categories"].append({"name": name, "count": count})

    # bicchieri
    glasses = get_glasses_list()
    stats["glasses"] = []
    for item in glasses.get("drinks", []):
        name = item.get("strGlass")
        count = len(safe_get_drinks(get_filtered_glass, name, total_items))
        if count > 0:
            stats["glasses"].append({"name": name, "count": count})

    # ingredienti
    ingredients = get_ingredients_list()
    stats["ingredients"] = []
    for item in ingredients.get("drinks", []):
        name = item.get("strIngredient1")
        count = len(safe_get_drinks(search_cocktail_by_ingredient, name, total_items))
        if count > 0:
            stats["ingredients"].append({"name": name, "count": count})

    return stats

# Route per ottenere le statistiche
@app.route("/stats")
def stats_route():
    return jsonify({
        "alcoholic": stats["alcoholic"],
        "categories": stats["categories"],
        "glasses": stats["glasses"],
        "ingredients": stats.get("ingredients", [])
    })

# Gestione errori 500
@app.errorhandler(500)
def internal_server_error(e):
    return render_template("500.html"), 500

# Gestione errori 404
@app.errorhandler(404)
def page_not_found(e):
    return render_template("404.html"), 404

def stats_worker():
    global stats, stats_running

    with stats_lock:
        stats_running = True

    try:
        result = get_stats()
        with stats_lock:
            stats = result
    finally:
        with stats_lock:
            stats_running = False


# Avvio dell'applicazione
if __name__ == "__main__":
    thread = threading.Thread(target=stats_worker, daemon=True)
    thread.start()
    socketio.run(app, debug=True, port=8080)