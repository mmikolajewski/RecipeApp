INSERT INTO
    category(id, name_inpl,image_address, text)
VALUES
    (1, 'Śniadanie', 'breakfast.jpg', ',to jak pierwsze spojrzenie na świat po nocy pełnej przygód w krainie snów. To moment, kiedy twoje oczy rozpędzają się tak szybko, że nawet kawa nie nadąża za nimi.'),
    (2, 'Objad', 'dinner.jpg', ', to taka przepustka do świata, gdzie kanapki i sałatki zamieniają się w prawdziwe smakowe superbohaterki. To jak Avengersi kuchni, którzy zjednoczeni w swojej smakowej mocy walczą z głodem i nudą, dając ci ekscytujące widowisko na talerzu.'),
    (3, 'Kolacja', 'supper.jpg', 'to jak przedstawienie teatralne, gdzie dania wchodzą na scenę w pełnym blasku i elegancji. To taka gastronomiczna opera, gdzie sosy śpiewają arie smaku, a mięso tańczy w rytmie widelców.'),
    (4, 'Przekąska', 'snack.jpg', ', to małe cuda w kuchni, które ratują nas przed głodem i nudą.');

INSERT INTO
    recipe(name, description, text, difficulty_level, add_time, image_address, timing, likes, category_id, author)
VALUES
    ('Kisiel', 'Poczuj się jak elita', 'Aby przygotować kisiel potrzebujesz', 'EASY', '2023-04-04', 'kisiel.jpg', 15, 5, 4, 'Tomasz Zajadał'),
    ('Kurczak z ryżem', 'Tradycyjnie, ale z klasą', 'Najpierw nakarm kurczaka ryżem', 'EASY', '2023-04-04', 'chicken.jpg', 23, 2, 2, 'Anna Zajadał'),
    ('Krewetki po jugodlandzku w kawiorze bumberejskim', 'Zacznij dzień z godnością', 'Najpierw upoluj kawior', 'HARD', '2023-04-04', 'krewetki.jpg', 15, 5, 3, 'Irena Przekąska'),
    ('kremówka', 'Coś słodkiego', 'W drodze do Wadowic', 'MODERATE', '2023-04-04', 'kremowka.jpg', 50, 3, 1, 'Anna Wiatr'),
    ('Pulpety z soczewicy', 'Nie ma nic lepszego', 'Przygotować warzywa: cebulę drobno posiekać, czosnek i chili drobno posiekać, cukinię umyć i pokroić w kostkę. Pomidory sparzyć wrzątkiem, obrać i pokroić w kostkę.
Pulpeciki: Cebulę zeszklić na oliwie. Połączyć z ugotowaną soczewicą i kaszą jaglaną, wszystko dokładnie wymieszać, doprawić solą i pieprzem. Z powstałej masy uformować małe pulpeciki i obtoczyć je w oliwie. Smażyć na oliwie na dobrze rozgrzanej patelni aż będą zrumienione. Uwaga: pulpeciki trzeba obracać bardzo delikatnie i z wyczuciem aby się nie rozpadły.
Sos: Cebulę zeszklić na oliwie, dodać czosnek, chili i chwilę podsmażyć. Dodać cukinię i smażyć mieszając przez ok. 2 - 3 minuty. W międzyczasie posolić aby cukinia zmiękła oraz dodać przyprawy aby uwolnić ich aromat podczas podsmażania. Dodać pomidory, posolić i doprawić pieprzem. Wymieszać i smażyć ok. 4 - 5 minut mieszając od czasu do czasu. Podawać z pulpecikami posypując listkami kolendry.', 'MODERATE', '2023-04-04', 'pulpety.jpg', 60, 2, 2, 'Tomasz Stypa');
