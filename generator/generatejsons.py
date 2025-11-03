import json
import glob
import os

plants = [("artichoke", "artichokes"), ("asparagus", "asparagus"), ("barley", "barley"), ("basil", "basil"),
          ("bellpepper", "bellpeppers"), ("blackbean", "blackbeans"), ("blackberry", "blackberries"),
          ('blueberry', 'blueberries'), ('broccoli', 'broccoli'), ('cabbage', 'cabbage'), ('cantaloupe', 'cantaloupes'),
          ('cauliflower', 'cauliflower'), ('celery', 'celery'), ('chile_pepper', 'chile_peppers'),
          ('coffee_beans', 'coffee_beans'), ('corn', 'corn'), ('cranberry', 'cranberries'), ('cucumber', 'cucumbers'),
          ('currant', 'currants'), ('eggplant', 'eggplants'), ('elderberry', 'elderberries'), ('garlic', 'garlic'),
          ('ginger', 'ginger'), ('grape', 'grapes'), ('greenbean', 'greenbeans'), ('greenonion', 'greenonions'),
          ('honeydew', 'honeydew'), ('hops', 'hops'), ('kale', 'kale'), ('kiwi', 'kiwis'), ('leek', 'leek'),
          ('lettuce', 'lettuce'), ('mustard', 'mustard'), ('oat', 'oat'), ('olive', 'olives'), ('onion', 'onions'),
          ('peanut', 'peanuts'), ('pepper', 'pepper'), ('pineapple', 'pineapples'), ('radish', 'radishes'),
          ('raspberry', 'raspberries'), ('rhubarb', 'rhubarb'), ('rice', 'rice'), ('rutabaga', 'rutabaga'),
          ('saguaro', 'saguaro'), ('soybean', 'soybean'), ('spinach', 'spinach'), ('squash', 'squash'),
          ('strawberry', 'strawberry'), ('sweetpotato', 'sweetpotato'), ('tea_leaves', 'tea_leaves'),
          ('tomatillo', 'tomatillo'), ('tomato', 'tomato'), ('turmeric', 'turmeric'), ('turnip', 'turnip'),
          ('vanilla', 'vanilla'), ('yam', 'yam'), ('zucchini', 'zucchini')]
os.makedirs(os.path.dirname('output/'), exist_ok=True)
os.makedirs(os.path.dirname('input/'), exist_ok=True)
input_files = glob.glob('input/**', recursive=True)

# seeds from plants - cutting
# for plant, plural in plants:
#     seed_recipe = {
#         "type": "farmersdelight:cutting",
#         "ingredients": [
#             {
#                 "item": "croptopia:" + plant
#             }
#         ],
#         "result": [
#             {
#                 "item": "croptopia:" + plant + "_seed"
#             },
#             {
#                 "chance": 0.5,
#                 "count": 1,
#                 "item": "croptopia:" + plant + "_seed"
#             }
#         ],
#         "tool": {
#             "tag": "forge:tools/knives"
#         }
#     }
#     with open("output/" + plant + "_seed.json", "w") as f:
#         json.dump(seed_recipe, f, ensure_ascii=False, indent=2)

#convert croptopia cooking pot recipes to fd pot recipes
# converted_count = 0
# for file in input_files:
#     with open(file, 'r') as f:
#         json_file = json.load(f)
#         if json_file['type'] == 'minecraft:crafting_shapeless':
#             if {'item': 'croptopia:cooking_pot'} in json_file['ingredients']:
#                 if {'item': 'croptopia:food_press'} not in json_file['ingredients']:
#                     json_file['ingredients'].remove({'item': 'croptopia:cooking_pot'})
#                     converted_recipe = {
#                         "type": "farmersdelight:cooking",
#                         "cookingtime": 200,
#                         "experience": 0.8,
#                         "ingredients": json_file['ingredients'],
#                         "result": json_file['result']
#                     }
#                     with open('output/' + file[6:], 'w') as g:
#                         json.dump(converted_recipe, g, ensure_ascii=False, indent=2)
#                     converted_count += 1
#                 else:
#                     print('found hybrid: ' + file)
#         elif json_file['type'] == 'minecraft:crafting_shaped':
#             if {'item': 'croptopia:cooking_pot'} in json_file['key'].values():
#                 print('cooking recipe ' + file + ' is shaped, needs manual conversion')
# print('converted ' + str(converted_count) + ' out of ' + str(len(input_files)) + ' input files')

# convert fd cooking to croptopia cooking pot recipes
# for file in input_files:
#     with open(file, 'r') as f:
#         json_file = json.load(f)
#         if json_file['type'] == "farmersdelight:cooking":
#             json_file['ingredients'].append({'item': 'croptopia:cooking_pot'})
#             json_file['ingredients'].append({'item': 'minecraft:bowl'})
#             converted_recipe = {
#                 "type": "minecraft:crafting_shapeless",
#                 "ingredients": json_file['ingredients'],
#                 "category": "misc",
#                 "result": json_file['result']
#             }
#             with open('output/' + file[6:], 'w') as g:
#                 json.dump(converted_recipe, g, ensure_ascii=False, indent=2)

# create advancements for all recipes
# for file in input_files:
#     in_namespace = 'croptopia'  # the namespace you want to check recipe for
#     in_prepend = ''  # extra stuff before actual name
#     out_prepend = 'croptopia_cooking/'  # extra stuff before the actual name
#     with open(file, 'r') as f:
#         advancement_json = {
#             "parent": "minecraft:recipes/root",
#             "rewards": {
#                 "recipes": [
#                     'farmerscroptopia:' + out_prepend + file[6:-5]
#                 ]
#             },
#             "criteria": {
#                 "has_the_recipe": {
#                     "trigger": "minecraft:recipe_unlocked",
#                     "conditions": {
#                         "recipe": in_namespace + ':' + in_prepend + file[6:-5]
#                     }
#                 }
#             },
#             "requirements": [
#                 [
#                     "has_the_recipe"
#                 ]
#             ]
#         }
#         with open('output/advancements/' + file[6:], 'w') as g:
#             json.dump(advancement_json, g, ensure_ascii=False, indent=2)

# convert forge conditional to neoforge conditions
for file in input_files:
    if file.endswith('.json'):
        with open(file, 'r') as f:
            json_file = json.load(f)
            if (json_file.get('recipes')) is not None:
                inner_recipe = json_file['recipes'][0]['recipe']
                inner_recipe['neoforge:conditions'] = json_file['recipes'][0]['conditions']

                relative_path = file[6:]
                output_path = os.path.join('output', relative_path)

                os.makedirs(os.path.dirname(output_path), exist_ok=True)

                with open(output_path, 'w') as g:
                    json.dump(inner_recipe, g, ensure_ascii=False, indent=2)
