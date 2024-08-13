CREATE TABLE tb_chef (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         position VARCHAR(255) NOT NULL,
                         income INT NOT NULL
);

CREATE TABLE tb_department (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               description TEXT NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               chef_id INT,
                               FOREIGN KEY (chef_id) REFERENCES tb_chef(id)
);

CREATE TABLE tb_worker (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           income INT NOT NULL,
                           age INT NOT NULL,
                           position VARCHAR(255) NOT NULL,
                           department_id INT,
                           FOREIGN KEY (department_id) REFERENCES tb_department(id)
);
