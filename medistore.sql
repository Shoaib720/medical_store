CREATE TABLE medicine_type (
    id INT AUTO_INCREMENT,
    medicine_type_name VARCHAR(60) NOT NULL,
    description VARCHAR(300) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE store_type (
    id INT AUTO_INCREMENT,
    type_name VARCHAR(60) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE medical_store (
    store_name VARCHAR(60) NOT NULL, 
    username VARCHAR(60) NOT NULL, 
    password VARCHAR(60) NOT NULL, 
    store_email_id VARCHAR(60) NOT NULL, 
    mobile_number VARCHAR(12) NOT NULL, 
    address_1 VARCHAR(100) NOT NULL, 
    address_2 VARCHAR(100) NOT NULL, 
    store_license VARCHAR(60) NOT NULL, 
    store_type_id INT NOT NULL, 
    store_registration_no VARCHAR(60) NOT NULL, 
    id INT AUTO_INCREMENT,
    PRIMARY KEY (id),
    Foreign Key (store_type_id) REFERENCES store_type(id)
);

CREATE TABLE medicine_details (
    medicine_name VARCHAR(60) NOT NULL,
    medicine_details VARCHAR(300) NOT NULL,
    medicine_price DECIMAL(5,2) NOT NULL,
    medicine_quantity INT NOT NULL,
    medicine_expiry_date TIMESTAMP NOT NULL,
    store_id INT NOT NULL,
    medicine_type_id INT NOT NULL,
    id VARCHAR(60) NOT NULL,
    PRIMARY KEY (id),
    Foreign Key (store_id) REFERENCES medical_store(id),
    Foreign Key (medicine_type_id) REFERENCES medicine_type(id)
);

INSERT INTO store_type (type_name) VALUE
    ("Ayurvedic"),
    ("Unani"),
    ("Generic");

INSERT INTO medicine_type (medicine_type_name, description) VALUE
    ("analgesic", "a drug that reduces pain"),
    ("antacid", "a medicine that reduces the amount of acid in your stomach"),
    ("antibiotic", "a drug that cures illnesses and infections caused by bacteria."),
    ("antihistamine", "a drug used to treat an allergy"),
    ("anti-inflammatory", "a drug taken to reduce inflammation"),
    ("antiviral", "a drug or treatment that is used to treat an infection or disease caused by a virus"),
    ("capsule", "a small round container filled with medicine that you swallow whole"),
    ("contraceptive", "a drug, method, or object used for preventing a woman from becoming pregnant"),
    ("drops", "liquid medicine that you put into your eyes, ears, or nose"),
    ("fertility", "a drug given to a woman to improve her fertility"),
    ("injection", "a drug or another substance that is injected into your body"),
    ("syrup", "a sweet liquid that contains medicine"),
    ("tablet", "a small hard round piece of medicine that you swallow");

INSERT INTO medical_store VALUE
    ("medistore","admin","Admin@123","admin@gmail.com","9867546321", "A-256, Diwana Apartment, Nalla Nagar", "Fatepay Road (West)", 1, 1, "RT1243", 1);