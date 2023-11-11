INSERT INTO medicine(name) VALUES ('tablet1');
INSERT INTO medicine(name) VALUES ('tablet2');
INSERT INTO medicine(name) VALUES ('tablet3');
INSERT INTO medicine(name) VALUES ('tablet4');

INSERT INTO pharmacy(name, city, street, house_number) VALUES ('pharmacy1', 'Minsk', 'Lesnaya', '44');
INSERT INTO pharmacy(name, city, street, house_number) VALUES ('pharmacy2', 'Minsk', 'Berezova', '44');
INSERT INTO pharmacy(name, city, street, house_number) VALUES ('pharmacy3', 'Grodno', 'Shiskova', '44');
INSERT INTO pharmacy(name, city, street, house_number) VALUES ('pharmacy4', 'Vilnus', 'Amobova', '44');

INSERT INTO pharmacy_medicine(medicine_id, pharmacy_id) VALUES (1, 1);
INSERT INTO pharmacy_medicine(medicine_id, pharmacy_id) VALUES (1, 2);
INSERT INTO pharmacy_medicine(medicine_id, pharmacy_id) VALUES (3, 3);
INSERT INTO pharmacy_medicine(medicine_id, pharmacy_id) VALUES (4, 4);

INSERT INTO users(username, password) VALUES ('User1', '$2a$12$Um0tz42Dcf9gyBlQCF7SxuaP5VWXh4JhYGtuOppNBn6vykKPbiQFe');
INSERT INTO users(username, password) VALUES ('User2','$2a$12$HQUr.70OEb4LsrZXAvOU2uU86mJrr/i.KgORChVhiz5J8V0ENFYLu');
INSERT INTO users(username, password) VALUES ('User3','$2a$12$lsuR8kOL2QZMj.fGkWvY4uLAABmoZDEAdrf0ecEqBJU42AQuKOFNK');
INSERT INTO users(username, password) VALUES ('User4','$2a$12$XlQAgHZASqQ.aSldNhzcveYKDz4eDlf2SXwBxerk6KuOiTtrBvzO6');
