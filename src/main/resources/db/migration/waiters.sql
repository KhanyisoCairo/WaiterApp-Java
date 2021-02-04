CREATE TABLE  UserName(
    id  SERIAL PRIMARY KEY,
    firstName TEXT,
    lastName TEXT,
    password TEXT,
    confirmPassword TEXT
--    counter INT
);

CREATE TABLE Days(
    id  SERIAL PRIMARY KEY,
    Days_In_A_Week TEXT
);

CREATE TABLE Waiters(
    user_id INT REFERENCES UserName(id) ON DELETE CASCADE ON UPDATE CASCADE,
    day_id INT REFERENCES Days(id) ON DELETE CASCADE ON UPDATE CASCADE,
    password INT REFERENCES UserName(id) ON DELETE CASCADE ON UPDATE CASCADE
    is_checked TEXT
);


