INSERT INTO CHEF (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, CHEF_PASSWORD) VALUES('Alimania', 'Juanito', 'chicomalo@email.com', 'Ali123');
INSERT INTO CHEF (LAST_NAME, FIRST_NAME, EMAIL_ADDRESS, CHEF_PASSWORD) VALUES('Navaja', 'Pedro', 'teapu@niala.com', '123Nav');

INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INGREDIENTS, INSTRUCTIONS, CREATOR_ID) VALUES ('Chocolate Chip Cookies', 'Dessert', 'Flour, Butter, Sugar, Eggs, Chocolate Chips, Vanilla', 'Put em all together and bake at 300 for 15 min.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INGREDIENTS, INSTRUCTIONS, CREATOR_ID) VALUES ('Ajiaco', 'Main', 'Chicken, creole potato, potato, corn, guascas, cream, water, cassava, bouillon', 'CHEF the chicken, boil the potatoes and cassava in water, add bouillon, mince the chicken and put it in the water, add corn, eat.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INGREDIENTS, INSTRUCTIONS, CREATOR_ID) VALUES ('Empanadas', 'Appetizer', 'Flour, butter, meat, rice, egg', 'I dont know, just do your best so that when you fry em the dough is crispy and the other stuff is inside.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INGREDIENTS, INSTRUCTIONS, CREATOR_ID) VALUES ('Quesadillas', 'Appetizer', 'Tortillas, cheese', 'Put cheese on tortilla. Fold tortilla. Heat.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INGREDIENTS, INSTRUCTIONS, CREATOR_ID) VALUES ('Plain Water', 'Drink', 'H20, heat', 'Do not heat the H20', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INGREDIENTS, INSTRUCTIONS, CREATOR_ID) VALUES ('Cold Water', 'Drink', 'H20, heat', 'Remove heat from the H20 till solid. Stop removing heat.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INGREDIENTS, INSTRUCTIONS, CREATOR_ID) VALUES ('Spicy Water', 'Drink', 'H20, cinnamon', 'Put cinnamon in the water. Keep Adding.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));
INSERT INTO RECIPE (RECIPE_NAME, CATEGORY, INGREDIENTS, INSTRUCTIONS, CREATOR_ID) VALUES ('Air Water', 'Drink', 'H20, heat', 'Heat the H20 till bubbles. Dont stop heating.', (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'));


INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Empanadas'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-10-22');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Boiled Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-10-23');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-10-20');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Quesadillas'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-10-20');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Ajiaco'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-10-21');
INSERT INTO MEAL_PLAN (RECIPE_ID, CHEF_ID, MEAL_PLAN_DATE) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Chocolate Chip Cookies'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Pedro'), '2022-10-26');


INSERT INTO FAVORITE (RECIPE_ID, CHEF_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Plain Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO FAVORITE (RECIPE_ID, CHEF_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Cold Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO FAVORITE (RECIPE_ID, CHEF_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Spicy Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));
INSERT INTO FAVORITE (RECIPE_ID, CHEF_ID) VALUES ((SELECT RECIPE_ID FROM RECIPE WHERE RECIPE_NAME = 'Air Water'), (SELECT CHEF_ID FROM CHEF WHERE FIRST_NAME = 'Juanito'));



