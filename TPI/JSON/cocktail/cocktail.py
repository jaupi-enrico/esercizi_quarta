import requests
import os
from flask import Flask, jsonify, render_template

os.environ["HTTP_PROXY"]  = "http://127.0.0.1:8888"
os.environ["HTTPS_PROXY"] = "http://127.0.0.1:8888"

base_url = "https://www.thecocktaildb.com/api/json/v1/1/"

def search_name(name):
    url = base_url + "search.php?s=" + name
    response = requests.get(url)
    dati = response.json()
    return dati

def search_letter(letter):
    url = base_url + "search.php?f=" + letter
    response = requests.get(url)
    dati = response.json()
    return dati

def search_ingredient_name(name):
    url = base_url + "search.php?i=" + name
    response = requests.get(url)
    dati = response.json()
    return dati

def search_cocktail_id(id):
    url = base_url + "lookup.php?i=" + id
    response = requests.get(url)
    dati = response.json()
    return dati

def search_ingredient_id(id):
    url = base_url + "lookup.php?iid=" + id
    response = requests.get(url)
    dati = response.json()
    return dati

def random_cocktail():
    url = base_url + "random.php"
    response = requests.get(url)
    dati = response.json()
    return dati

def get_alcoholic():
    url = base_url + "filter.php?a=Alcoholic"
    response = requests.get(url)
    dati = response.json()
    return dati

def get_not_alcoholic():
    url = base_url + "filter.php?a=Non_Alcoholic"
    response = requests.get(url)
    dati = response.json()
    return dati

def get_filtered_category(category):
    url = base_url + "filter.php?c=" + category
    response = requests.get(url)
    dati = response.json()
    return dati

def get_filtered_glass(glass):
    url = base_url + "filter.php?g=" + glass
    response = requests.get(url)
    dati = response.json()
    return dati

def get_categories_list():
    url = base_url + "list.php?c=list"
    response = requests.get(url)
    dati = response.json()
    return dati

def get_glasses_list():
    url = base_url + "list.php?g=list"
    response = requests.get(url)
    dati = response.json()
    return dati

def get_ingredients_list():
    url = base_url + "list.php?i=list"
    response = requests.get(url)
    dati = response.json()
    return dati

def get_alcoholic_list():
    url = base_url + "list.php?a=list"
    response = requests.get(url)
    dati = response.json()
    return dati

def get_drink_image_url(name, dimension):
    url = "https://www.thecocktaildb.com/images/media/drink/" + name + "/" + dimension
    return url

def get_ingredient_image_url(name, dimension):
    url = "https://www.thecocktaildb.com/images/ingredients/" + dimension
    return url

app = Flask(__name__)

@app.route("/")
def index():
    return "<h1>Cocktail API is running</h1>"

@app.route("/random")
def random_route():
    return jsonify(random_cocktail())

@app.route("/search/<name>")
def search_route(name):
    if len(name) == 1:
        dati = search_letter(name)
    else:
        dati = search_name(name)
    return render_template("search.html", drinks=dati)

@app.route("/search/id/<id>")
def search_id_route(id):
    dati = search_cocktail_id(id)
    return render_template("search.html", drinks=dati)

@app.route("/search/ingredient/id/<id>")
def search_ingredient_id_route(id):
    dati = search_ingredient_id(id)
    return render_template("search_ingredient.html", ingredients=dati)

@app.route("/search/ingredient/<name>")
def search_ingredient_route(name):
    dati = search_ingredient_name(name)
    print(dati)
    return render_template("search_ingredient.html", ingredients=dati)

if __name__ == "__main__":
    app.run(debug=True)