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

INSERT INTO HW_USER(USERID, LOGIN, PASSWORD) VALUES (
    1,
    'admin',
    '66dc580a095b441a50865ebd53426a9d471b6d12c3200972b8f41ce03c56686b2d52e2d8849021c3'
);

INSERT INTO HW_USER(USERID, LOGIN, PASSWORD) VALUES (
    2,
    'user',
    'e864723c471f6ece7b89237ffd05be6e6972f2810e8a062172ca4b478ca24e088429c85558389cbc'
);

INSERT INTO HW_ROLE(ROLEID, ROLESYSNAME) VALUES (
    1,
    'ADMIN'
);

INSERT INTO HW_ROLE(ROLEID, ROLESYSNAME) VALUES (
    2,
    'USER'
);

INSERT INTO HW_USER_ROLE(USERROLEID, ROLEID, USERID) VALUES (
    1, 1, 1
);
INSERT INTO HW_USER_ROLE(USERROLEID, ROLEID, USERID) VALUES (
    2, 2, 2
);