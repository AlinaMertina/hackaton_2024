# from flask import Flask

# app = Flask(__name__)

# @app.route("/")
# def hello_world():
#     return "<p>Hello, World!</p>"
import os
# Imports the Google Cloud client library
from google.cloud import vision
from flask import Flask, request, jsonify
from google.cloud import vision
import base64
from google.cloud import language_v1

os.environ['GOOGLE_APPLICATION_CREDENTIALS']=r"C:\Users\tendr\OneDrive\Pictures\roads-379007-0ff249e52b7a.json"


def image_to_base64_and_save(image_path, output_file):
    """Converts an image file to base64 and saves it to a file."""
    with open(image_path, "rb") as image_file:
        base64_data = base64.b64encode(image_file.read()).decode('utf-8')
    
    with open(output_file, "w") as file:
        file.write(base64_data)

# Exemple d'utilisation
image_path = r"D:\Pictures\download.jpeg"
output_file = r"C:\Users\tendr\OneDrive\Pictures\base64image2.txt"
image_to_base64_and_save(image_path, output_file)
print(f"Fichier base64 enregistré sous {output_file}")


def detect_labels(path):
    """Detects labels in the file and returns a JSON object."""
    from google.cloud import vision
    import json

    client = vision.ImageAnnotatorClient()

    with open(path, "rb") as image_file:
        content = image_file.read()

    image = vision.Image(content=content)

    response = client.label_detection(image=image)
    labels = response.label_annotations
    labels_data = []

    for label in labels:
        labels_data.append(label.description)

    if response.error.message:
        raise Exception(
            "{}\nFor more info on error messages, check: "
            "https://cloud.google.com/apis/design/errors".format(response.error.message)
        )

    return json.dumps(labels_data)

    

def detect_landmarks(path):
    """Detects landmarks in the file and returns a JSON object."""
    from google.cloud import vision
    import json

    client = vision.ImageAnnotatorClient()

    with open(path, "rb") as image_file:
        content = image_file.read()

    image = vision.Image(content=content)

    response = client.landmark_detection(image=image)
    landmarks = response.landmark_annotations
    landmarks_data = []

    for landmark in landmarks:
        landmark_info = {
            "description": landmark.description,
            "locations": []
        }
        for location in landmark.locations:
            lat_lng = location.lat_lng
            landmark_info["locations"].append({
                "latitude": lat_lng.latitude,
                "longitude": lat_lng.longitude
            })
        landmarks_data.append(landmark_info)

    if response.error.message:
        raise Exception(
            "{}\nFor more info on error messages, check: "
            "https://cloud.google.com/apis/design/errors".format(response.error.message)
        )

    return json.dumps(landmarks_data)


def detect_landmarks_base64(image_base64):
    """Detects landmarks in the base64 image and returns a JSON object."""
    from google.cloud import vision
    import base64
    import json

    client = vision.ImageAnnotatorClient()

    # Décodez l'image base64
    image_bytes = base64.b64decode(image_base64)

    image = vision.Image(content=image_bytes)

    response = client.landmark_detection(image=image)
    landmarks = response.landmark_annotations
    landmarks_data = []

    for landmark in landmarks:
        landmark_info = {
            "description": landmark.description,
            "locations": []
        }
        for location in landmark.locations:
            lat_lng = location.lat_lng
            landmark_info["locations"].append({
                "latitude": lat_lng.latitude,
                "longitude": lat_lng.longitude
            })
        landmarks_data.append(landmark_info)

    if response.error.message:
        raise Exception(
            "{}\nFor more info on error messages, check: "
            "https://cloud.google.com/apis/design/errors".format(response.error.message)
        )

    return json.dumps(landmarks_data)




app = Flask(__name__)

def detect_labels_from_base64(image_base64):
    """Detects labels from a base64 encoded image."""
    client = vision.ImageAnnotatorClient()

    content = base64.b64decode(image_base64)

    image = vision.Image(content=content)

    response = client.label_detection(image=image)
    labels = response.label_annotations
    labels_data = []

    for label in labels:
        labels_data.append(label.description)

    if response.error.message:
        raise Exception(
            "{}\nFor more info on error messages, check: "
            "https://cloud.google.com/apis/design/errors".format(response.error.message)
        )

    return labels_data



from google.cloud import language_v1

def analyze_text_sentiment(text_content):
    client = language_v1.LanguageServiceClient()
    document = language_v1.Document(content=text_content, type_=language_v1.Document.Type.PLAIN_TEXT)
    response = client.analyze_sentiment(request={'document': document})
    sentiment = response.document_sentiment

    return sentiment.score, sentiment.magnitude

# Exemple d'utilisation
text_to_analyze = "Cet article est vraiment merdique "
score, magnitude = analyze_text_sentiment(text_to_analyze)
print(f"Score de sentiment : {score}, Magnitude : {magnitude}")




@app.route("/getlabel", methods=["POST"])
def hello_world():
    data = request.json
    if "image_base64" not in data:
        return jsonify({"error": "Image base64 data not found"}), 400

    image_base64 = data["image_base64"]
    labels = detect_labels_from_base64(image_base64)
    return jsonify({"labels": labels})

@app.route("/landmarks", methods=["POST"])
def getlandmark():
    print("hhhhhhhhh")
    data = request.json
    if "image_base64" not in data:
        return jsonify({"error": "Image base64 data not found"}), 400
    image_base64 = data["image_base64"]
    labels =  detect_landmarks_base64(image_base64)
    return jsonify({"labels": labels})

if __name__ == "__main__":
    app.run()
