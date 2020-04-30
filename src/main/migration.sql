use adlister_db;

CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) DEFAULT 'NONE',
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE ads(
        id INT NOT NULL AUTO_INCREMENT,
        user_id INT,
        FOREIGN KEY (user_id) references adlister_db.users(id),
        title VARCHAR(50) DEFAULT 'NONE',
        description VARCHAR(450) DEFAULT 'NONE',
        PRIMARY KEY (id)
);