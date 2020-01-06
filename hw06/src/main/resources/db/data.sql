INSERT INTO HW_AUTHOR(AUTHORNAME) VALUES ('Рэй Брэдбери');
INSERT INTO HW_AUTHOR(AUTHORNAME) VALUES ('Эрих Мария Ремарк');
INSERT INTO HW_AUTHOR(AUTHORNAME) VALUES ('Олдос Хаксли');
INSERT INTO HW_AUTHOR(AUTHORNAME) VALUES ('Хулио Кортасар');

INSERT INTO HW_GENRE(GENRENAME) VALUES ('Научная фантастика');
INSERT INTO HW_GENRE(GENRENAME) VALUES ('Роман');
INSERT INTO HW_GENRE(GENRENAME) VALUES ('Антироман');
INSERT INTO HW_GENRE(GENRENAME) VALUES ('Классическая проза');

INSERT INTO HW_BOOK(BOOKNAME, AUTHORID, GENREID) VALUES (
    '451 градус по фаренгейту',
    (SELECT AUTHORID FROM HW_AUTHOR WHERE AUTHORNAME = 'Рэй Брэдбери'),
    (SELECT GENREID FROM HW_GENRE WHERE GENRENAME = 'Научная фантастика')
);
INSERT INTO HW_BOOK(BOOKNAME, AUTHORID, GENREID) VALUES (
    'Триумфальная арка',
    (SELECT AUTHORID FROM HW_AUTHOR WHERE AUTHORNAME = 'Эрих Мария Ремарк'),
    (SELECT GENREID FROM HW_GENRE WHERE GENRENAME = 'Роман')
);
INSERT INTO HW_BOOK(BOOKNAME, AUTHORID, GENREID) VALUES (
    'О дивный новый мир',
    (SELECT AUTHORID FROM HW_AUTHOR WHERE AUTHORNAME = 'Олдос Хаксли'),
    (SELECT GENREID FROM HW_GENRE WHERE GENRENAME = 'Роман')
);
INSERT INTO HW_BOOK(BOOKNAME, AUTHORID, GENREID) VALUES (
    'Игра в классики',
    (SELECT AUTHORID FROM HW_AUTHOR WHERE AUTHORNAME = 'Хулио Кортасар'),
    (SELECT GENREID FROM HW_GENRE WHERE GENRENAME = 'Антироман')
);
INSERT INTO HW_BOOK(BOOKNAME, AUTHORID, GENREID) VALUES (
    'Жизнь взаймы',
    (SELECT AUTHORID FROM HW_AUTHOR WHERE AUTHORNAME = 'Эрих Мария Ремарк'),
    (SELECT GENREID FROM HW_GENRE WHERE GENRENAME = 'Классическая проза')
);

INSERT INTO HW_COMMENT(BOOKID, COMMENT) VALUES (
    1,
    '451 градус по фаренгейту, Рэй Брэдбери'
);

INSERT INTO HW_COMMENT(BOOKID, COMMENT) VALUES (
    2,
    'Триумфальная арка, Эрих Мария Ремарк'
);

INSERT INTO HW_COMMENT(BOOKID, COMMENT) VALUES (
    3,
    'О дивный новый мир, Олдос Хаксли'
);

INSERT INTO HW_COMMENT(BOOKID, COMMENT) VALUES (
    3,
    'О дивный новый мир, Олдос Хаксли, сатирический антиутопический роман'
);

INSERT INTO HW_COMMENT(BOOKID, COMMENT) VALUES (
    4,
    'Игра в классики, Хулио Кортасар'
);

INSERT INTO HW_COMMENT(BOOKID, COMMENT) VALUES (
    5,
    'Жизнь взаймы, Эрих Мария Ремарк'
);