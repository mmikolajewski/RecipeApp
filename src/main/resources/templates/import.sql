INSERT INTO
    category(id, name_in_pl,image_adress, text)
VALUES
    (1, 'Śniadanie', 'breakfast.jpg', 'Śniadanie to taka fajna rzecz...coś tam coś'),
    (2, 'Objad', 'dinner.jpg', 'Objad to taka fajna rzecz...coś tam coś'),
    (3, 'Kolacja', 'supper.jpg', 'Kolacja to taka fajna rzecz...coś tam coś'),
    (4,'Przekąska', 'snack.jpg', 'Przekaska to taka fajna rzecz...coś tam coś');

INSERT INTO
    recipe(id, name, description, text, difficulty_level, add_time, image_adress, timing, likes, category_id)
VALUES
    (1, 'Kisiel', 'Poczuj się jak elita', 'Aby przygotować kisiel potrzebujesz', 'HARD', '2023-04-04', 'kisiel.jpg', 15, 5, 4),
    (2, 'Kurczak z ryżem', 'Tradycyjnie, ale z klasą', 'Najpierw nakarm kurczaka ryżem', 'EASY', '2023-04-04', 'chicken.jpg', 23, 2, 2),
    (3, 'Krewetki po jugodlandzku w kawiorze bumberejskim', 'Zacznij dzień z godnością', 'Najpierw upoluj kawior', 'HARD', '2023-04-04', 'krewetki.jpg', 15, 5, 3),
    (4, 'kremówka', 'Coś słodkiego', 'W drodze do Wadowic', 'MODERATE', '2023-04-04', 'kremowka.jpg', 50, 3, 4),
    (5, 'Kora', 'Z braku laku', 'Nic nie smakuje lepiej niż', 'MODERATE', '2023-04-04', 'kisiel.jpg', 15, 5, 4);
