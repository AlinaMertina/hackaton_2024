import os
# Imports the Google Cloud client library
from google.cloud import vision
os.environ['GOOGLE_APPLICATION_CREDENTIALS']=r"C:\Users\tendr\OneDrive\Pictures\roads-379007-0ff249e52b7a.json"

# def detect_labels(path):
#     """Detects labels in the file."""
#     from google.cloud import vision

#     client = vision.ImageAnnotatorClient()

#     with open(path, "rb") as image_file:
#         content = image_file.read()

#     image = vision.Image(content=content)

#     response = client.label_detection(image=image)
#     labels = response.label_annotations
#     print("Labels:")

#     for label in labels:
#         print(label.description)

#     if response.error.message:
#         raise Exception(
#             "{}\nFor more info on error messages, check: "
#             "https://cloud.google.com/apis/design/errors".format(response.error.message)
#         )

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

    
# def detect_landmarks(path):
#     """Detects landmarks in the file."""
#     from google.cloud import vision

#     client = vision.ImageAnnotatorClient()

#     with open(path, "rb") as image_file:
#         content = image_file.read()

#     image = vision.Image(content=content)

#     response = client.landmark_detection(image=image)
#     landmarks = response.landmark_annotations
#     print("Landmarks:")

#     for landmark in landmarks:
#         print(landmark.description)
#         for location in landmark.locations:
#             lat_lng = location.lat_lng
#             print(f"Latitude {lat_lng.latitude}")
#             print(f"Longitude {lat_lng.longitude}")

#     if response.error.message:
#         raise Exception(
#             "{}\nFor more info on error messages, check: "
#             "https://cloud.google.com/apis/design/errors".format(response.error.message)
#         )
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

print(detect_labels(r"D:\Pictures\Paris by night.jpeg"))
# print(run_quickstart())
print(detect_landmarks(r"D:\Pictures\download.jpeg"))
