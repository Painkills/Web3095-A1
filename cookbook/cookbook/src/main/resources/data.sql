INSERT INTO CHEF (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, CHEF_PASSWORD) VALUES('Alimania', 'Juanito', 'juanito@email', '123');
INSERT INTO CHEF (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, CHEF_PASSWORD) VALUES('Navaja', 'Pedro', 'pedro@email', '123');

INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INSTRUCTIONS, CREATOR_ID) VALUES ('Chocolate Chip Cookies', 'Dessert', 'Put em all together and bake at 300 for 15 min.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INSTRUCTIONS, CREATOR_ID) VALUES ('Ajiaco', 'Main', 'Cook the chicken, boil the potatoes and cassava in water, add bouillon, mince the chicken and put it in the water, add corn, eat.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INSTRUCTIONS, CREATOR_ID) VALUES ('Empanadas', 'Appetizer', 'I dont know, just do your best so that when you fry em the dough is crispy and the other stuff is inside.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INSTRUCTIONS, CREATOR_ID) VALUES ('Quesadillas', 'Appetizer', 'Put cheese on tortilla. Fold tortilla. Heat.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INSTRUCTIONS, CREATOR_ID) VALUES ('Plain Water', 'Drink', 'Do not heat the H20', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INSTRUCTIONS, CREATOR_ID) VALUES ('Cold Water', 'Drink', 'Remove heat from the H20 till solid. Stop removing heat.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INSTRUCTIONS, CREATOR_ID) VALUES ('Spicy Water', 'Drink', 'Put cinnamon in the water. Keep Adding.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INSTRUCTIONS, CREATOR_ID) VALUES ('Air Water', 'Drink', 'Heat the H20 till bubbles. Dont stop heating.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));


INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Empanadas'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-11-29');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Plain Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-11-29');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-11-30');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Quesadillas'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-11-30');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-12-2');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-12-3');

INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Quesadillas'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'), '2022-11-29');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'), '2022-11-30');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'), '2022-12-2');


INSERT INTO FAVORITE (RECIPE_ID, CHEF_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Plain Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO FAVORITE (RECIPE_ID, CHEF_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Cold Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO FAVORITE (RECIPE_ID, CHEF_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Spicy Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO FAVORITE (RECIPE_ID, CHEF_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Air Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));

INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('flour');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('butter');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('sugar');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('egg');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('chocolate chip');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('vanilla');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('chicken');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('potato');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('corn');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('cream');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('water');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('cassava');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('bouillon');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('meat');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('rice');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('tortillas');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('cheese');
INSERT INTO INGREDIENT (INGREDIENT_NAME) VALUES ('cinnamon');

INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'flour'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'butter'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'sugar'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'egg'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'chocolate chip'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'vanilla'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'chicken'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'potato'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'corn'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'cream'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'water'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'cassava'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'bouillon'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Empanadas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'flour'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Empanadas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'egg'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Empanadas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'water'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Empanadas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'rice'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Empanadas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'meat'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Empanadas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'butter'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Quesadillas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'tortillas'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Quesadillas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'cheese'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Quesadillas'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'butter'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Plain Water'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'water'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Cold Water'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'water'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Spicy Water'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'water'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Spicy Water'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'cinnamon'));
INSERT INTO RECIPE_HAS_INGREDIENT (RECIPE_ID, INGREDIENT_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Air Water'), (SELECT INGREDIENT_ID FROM INGREDIENT WHERE INGREDIENT_NAME = 'water'));










